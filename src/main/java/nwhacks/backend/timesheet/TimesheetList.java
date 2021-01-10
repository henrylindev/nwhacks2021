package nwhacks.backend.timesheet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import nwhacks.backend.employee.EditableEmployee;
import nwhacks.backend.employee.Employee;
import nwhacks.backend.employee.EmployeeManager;
@Named("timesheetList")
@ConversationScoped
public class TimesheetList implements Serializable {

	@Inject @Dependent private TimeSheetManager sheetManager;
	private List<EditableTimesheet> list;
	@Inject Conversation conversation;
	private String searchTerm;
	
	public List<EditableTimesheet> getList() {
		if (!conversation.isTransient()) {
			conversation.end();
		}
		conversation.begin();
        if (list == null) {
            refreshList();
        }
        return list;
    }

	public List<EditableTimesheet> refreshList() {
		Timesheet[] timesheets = sheetManager.getAll();
        list = new ArrayList<EditableTimesheet>();
        for (int i = 0; i < timesheets.length; i++) {
            list.add(new EditableTimesheet(timesheets[i]));
        }
        System.out.println("running");
        return list;
    }
	
	public List<EditableTimesheet> search() {
		Timesheet[] timesheets = sheetManager.search(searchTerm);
		list = new ArrayList<EditableTimesheet>();
		for(int i = 0; i < timesheets.length; i++) {
			list.add(new EditableTimesheet(timesheets[i]));
		}
		System.out.println("timesheets search: " + Arrays.deepToString(timesheets));
		return list;
	}

	
	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
}

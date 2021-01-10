package nwhacks.backend.timesheetrow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

//import nwhacks.backend.account.EditableTimesheetRow;
//import nwhacks.backend.account.TimesheetRow;
//import nwhacks.backend.account.RowManager;


@Named("timesheetRowList")
@ConversationScoped
public class TimesheetRowList implements Serializable{

    @Inject @Dependent private RowManager rowManager;
    private List<EditableTimesheetRow> list;
    @Inject Conversation conversation;
    
    public List<EditableTimesheetRow> getList() {
        if(!conversation.isTransient()) {
            conversation.end();
        }
        conversation.begin();
        if (list == null) {
            refreshList();
        }
        return list;
    }
    
    public List<EditableTimesheetRow> refreshList() {
        TimesheetRow[] timesheetrows = RowManager.getAll();
        list = new ArrayList<EditableTimesheetRow>();
        for (int i = 0; i < timesheetrows.length; i++) {
            list.add(new EditableTimesheetRow(timesheetrows[i]));
        }
        System.out.println("running");
        return list;
        
    }
}

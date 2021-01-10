package nwhacks.backend.employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;


@Named("employeeList")
@ConversationScoped
public class EmployeeList implements Serializable {
	@Inject @Dependent private EmployeeManager employeeManager;
	private List<EditableEmployee> list;
	@Inject Conversation conversation;
	private String searchTerm;
	
	public List<EditableEmployee> getList() {
		if (!conversation.isTransient()) {
			conversation.end();
		}
		conversation.begin();
        if (list == null) {
            refreshList();
        }
        return list;
    }

	public List<EditableEmployee> refreshList() {
		Employee[] employees = employeeManager.getAll();
        list = new ArrayList<EditableEmployee>();
        for (int i = 0; i < employees.length; i++) {
            list.add(new EditableEmployee(employees[i]));
        }
        System.out.println("running");
        return list;
    }
	
	public Employee search() {
//		Employee[] employees = employeeManager.search(searchTerm);
//		list = new ArrayList<EditableEmployee>();
//		for(int i = 0; i < employees.length; i++) {
//			list.add(new EditableEmployee(employees[i]));
//		}
		Employee e = employeeManager.search(searchTerm);
		System.out.println("employees search: " + e);
		return e;
	}

	
	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}


}

package nwhacks.backend.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import nwhacks.backend.employee.EditableEmployee;
import nwhacks.backend.employee.Employee;
import nwhacks.backend.employee.EmployeeManager;

@Named("projectList")
@ConversationScoped
public class ProjectList implements Serializable {
	@Inject @Dependent private ProjectManager projectManager;
	private List<EditableProject> list;
	@Inject Conversation conversation;
	private String searchTerm;
	
	public List<EditableProject> getList() {
		if (!conversation.isTransient()) {
			conversation.end();
		}
		conversation.begin();
        if (list == null) {
            refreshList();
        }
        return list;
    }

	public List<EditableProject> refreshList() {
		Project[] projects = projectManager.getAll();
        list = new ArrayList<EditableProject>();
        for (int i = 0; i < projects.length; i++) {
            list.add(new EditableProject(projects[i]));
        }
        System.out.println("running");
        return list;
    }
	
	public Project search() {
//		Employee[] employees = employeeManager.search(searchTerm);
//		list = new ArrayList<EditableEmployee>();
//		for(int i = 0; i < employees.length; i++) {
//			list.add(new EditableEmployee(employees[i]));
//		}
		Project p = projectManager.search(searchTerm);
		System.out.println("projects search: " + p);
		return p;
	}
	
	public Project searchById() {
//		Employee[] employees = employeeManager.search(searchTerm);
//		list = new ArrayList<EditableEmployee>();
//		for(int i = 0; i < employees.length; i++) {
//			list.add(new EditableEmployee(employees[i]));
//		}
		Project p = projectManager.searchById(UUID.fromString("0ccc5e65-e521-4978-ae72-faf6aa5d1d92"));
		System.out.println("projects search: " + p);
		return p;
	}
	

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
}

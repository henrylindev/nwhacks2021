package nwhacks.backend.project;

import java.io.Serializable;
import java.util.UUID;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="project")
@Named("project")
@SessionScoped
public class Project implements Serializable {
	@Id
	@Column(name="projectid")
	@Type(type = "uuid-char")
	protected UUID projectId;
	
	@Column(name="projectname")
	protected String projectName;
	
	public Project() {}

	public Project(UUID projectId, String projectName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
	}
	
	public Project(String projectName) {
		super();
		this.projectId = UUID.randomUUID();
		this.projectName = projectName;
	}

	public UUID getProjectId() {
		return projectId;
	}

	public void setProjectId(UUID projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String toString() {
		return this.projectName;
	}
	
	
}

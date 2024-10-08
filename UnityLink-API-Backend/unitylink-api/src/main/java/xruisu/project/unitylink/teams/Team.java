package xruisu.project.unitylink.teams;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="teams")
public class Team {

	@Id
	private String teamId;

	private String teamCreator;
	private String teamName;
	private String manager;

	private String creationDate;


	public String getTeamID() {
		return teamId;
	}

	public void setTeamID(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamCreator() {
		return teamCreator;
	}

	public void setTeamCreator(String teamCreator) {
		this.teamCreator = teamCreator;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

}


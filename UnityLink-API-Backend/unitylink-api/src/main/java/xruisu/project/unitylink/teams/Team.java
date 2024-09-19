package xruisu.project.unitylink.teams;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="teams")
public class Team {

	@Id
	private String teamID;

	private String team_name;

	private String team_creator;

	private String creation_date;

	private String manager;

	public String getTeamID() {
		return teamID;
	}

	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	public String getTeamName() {
		return team_name;
	}

	public void setTeamName(String team_name) {
		this.team_name = team_name;
	}

	public String getTeamCreator() {
		return team_creator;
	}

	public void setTeamCreator(String team_creator) {
		this.team_creator = team_creator;
	}

	public String getCreationDate() {
		return creation_date;
	}

	public void setCreationDate(String creation_date) {
		this.creation_date = creation_date;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

}


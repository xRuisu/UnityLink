package xruisu.project.unitylink.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")

public class User {
	
	@Id
	private String unique_id;
	
	private String sessionID;
	
	private String first_name;

	private String last_name;
	
	private String email;
	
	private String password;
	
	private String confirmPassword;
		
	private String role;

	private String location;
	
	private WebPerms access_type;
	

	 String getUnqiueID() {
		return unique_id;
	}

	public void setUnqiueID(String uid) {
		this.unique_id = uid;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String lastName) {
		this.last_name = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public String getEmpPosition() {
		return role;
	}

	public void setEmpPosition(String empPosition) {
		this.role = empPosition;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public WebPerms getAccessType() {
		return access_type;
	}

	public void setAccessType(WebPerms string) {
		this.access_type = string;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
}

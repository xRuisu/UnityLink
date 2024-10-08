package xruisu.project.unitylink.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")

public class User {

	@Id
	private String userId;
	private String sessionId;

	private String firstName;
	private String lastName;

	private String email;
	private String password;

	private String role;
	private String manager;
	
	private String location;
	private String accessType;

	//private String confirmPassword;

	public String getUnqiueID() {
		return userId;
	}

	public void setUniqueID(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	//	public void setConfirmPassword(String confirmPassword) {
	//		this.confirmPassword = confirmPassword;
	//	}
	//	
	//	public String getConfirmPassword() {
	//		return confirmPassword;
	//	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getSessionID() {
		return sessionId;
	}

	public void setSessionID(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
}

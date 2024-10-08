package xruisu.project.unitylink.security;

import xruisu.project.unitylink.user.User;
import xruisu.project.unitylink.user.UserRegistrationDTO;

public interface SecuredResource {
	String validateUser(UserRegistrationDTO userDTO, User user ,String email);
	boolean emailExists(String email);
}

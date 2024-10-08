package xruisu.project.unitylink.security;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xruisu.project.unitylink.user.User;
import xruisu.project.unitylink.user.UserRegistrationDTO;
import xruisu.project.unitylink.user.UserRepository;
import xruisu.project.unitylink.user.WebPerms;
import xruisu.project.unitylink.utility.UserUUIDUtility;

@Service
public class UserSecurityService implements SecuredResource {

	private static final Logger logger = LoggerFactory.getLogger(UserSecurityService.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public String validateUser(UserRegistrationDTO userDTO, User user, String email) {
		logger.info(":: @UserSecurityService :: -> Initializing...");
		Optional<User> optionalUser = userRepository.findByEmail(email);

		if (optionalUser.isPresent()) {
			// Validate password match
			if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
				logger.warn(":: @UserSecurityService :: -> Your passwords don't match, please try again."); 
				return "redirect:/mismatch.html";
			} else {
				logger.warn(":: @UserSecurityService :: -> Email already exists."); 
				return "redirect:/alreadyexists.html";
			}
		} else {
			// No user exists, so create a new user
			logger.info(":: @UserSecurityService :: -> Creating new user...");

			//Generate and assign UUID
			UserUUIDUtility.generateUniqueUserID(userDTO.getFirstName(), userDTO.getLastName());
			user.setUniqueID(UserUUIDUtility.getUniqueUserID());	
			
			//Assign first and last name
			user.setFirstName(userDTO.getFirstName());
			user.setLastName(userDTO.getLastName());
			
			//Assign users email
			user.setEmail(userDTO.getEmail());
			
			//Assign all other variables
			user.setLocation("INDH");
			user.setRole("DG Agent");
			user.setManager("Ron Caheal");

			logger.info(":: @UserSecurityService :: -> Applying default permissions...");
			user.setAccessType(WebPerms.IS_GUEST.toString());

			userRepository.save(user);
			return "redirect:/index.html"; // Success, redirect to appropriate page
		}
	}
	
	@Override
	public boolean emailExists(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		return user.isPresent();
	}
}
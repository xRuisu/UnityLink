package xruisu.project.unitylink.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import xruisu.project.unitylink.user.User;
import xruisu.project.unitylink.user.UserRepository;
import xruisu.project.unitylink.utility.UserUtility;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	private final UserRepository userRepository;

	 @GetMapping("/register")
	    public String redirectBody() {
	        return "/Index.html";
	    }

	@PostMapping("/register")
	public ResponseEntity<?> submitForm(@RequestBody User user, Model model) {
		logger.info("Validating user passwords...");
		if (!user.getPassword().equals(user.getConfirmPassword())) {
	        return ResponseEntity.badRequest().body("Passwords don't match, please try again.");
	    }
		Map<String, Object> response = new HashMap<>();
		response.put("message", "Successful submission");
		response.put("Create User", user);
		UserUtility.generateUID(user.getFirstName(), user.getLastName());
		user.setUnqiueID(UserUtility.validateUUID());
		
		userRepository.save(user);
		logger.info(":: @ServiceHandler :: -> Successfully saved the following result!");
		
		logger.info("User count updated: " + userRepository.count());		
		return ResponseEntity.ok(response);
	}
}


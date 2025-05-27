package xruisu.project.unitylink.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import xruisu.project.unitylink.security.UserSecurityService;
import xruisu.project.unitylink.user.User;
import xruisu.project.unitylink.user.UserRegistrationDTO;

@Controller
public class UserController {

	private final UserSecurityService userSecurityService;

	public UserController(UserSecurityService userSecurityService) {
		this.userSecurityService = userSecurityService;
	}

	@GetMapping("/register")
	public String redirectBody() {
		return "Index";
	}

	@PostMapping("/register")
	public String submitForm(@RequestBody UserRegistrationDTO userDTO, User user, Model model) {
		Map<String, Object> response = new HashMap<>();
		response.put("message", ":: @UserController :: -> Successful submission");
		response.put(":: @UserController :: -> Data:", userDTO);

		// Call the user security service and handle redirection
		String redirectUrl = userSecurityService.validateUser(userDTO, user, userDTO.getEmail());

		return redirectUrl; // Return the proper redirection URL from ValidateUser
	}
}

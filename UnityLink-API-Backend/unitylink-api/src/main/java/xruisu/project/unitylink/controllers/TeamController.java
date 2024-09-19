package xruisu.project.unitylink.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import xruisu.project.unitylink.teams.Team;
import xruisu.project.unitylink.teams.TeamRepository;
import xruisu.project.unitylink.user.User;
import xruisu.project.unitylink.utility.TeamsUtility;
import xruisu.project.unitylink.utility.TimeDateUtility;

@Controller
public class TeamController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeamController.class);


	@Autowired
	public TeamController(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	private final TeamRepository teamRepository;
	
	@GetMapping("/team") 
	public String teamRedirect() {
		return "/Index.html";
	}

	@PostMapping("/team")
	public ResponseEntity<Map<String, Object>> createTeam(Team team, User user, TeamsUtility utility) {
	    Map<String, Object> response = new HashMap<>();
	    response.put("Create Team", team);
	    team.setTeamID(utility.getGeneratedTeamID());
	    TeamsUtility.authCount++;
	    // Check if a team with the same ID already exists
	    Optional<Team> existingTeam = teamRepository.findById(team.getTeamID());
	    
	    logger.info("Validating team id...");
	    if (existingTeam.isPresent()) {
	        logger.warn("Team with the same ID already exists.");
	    	logger.info("Generating new team ID...");
	    	team.setTeamID(utility.getGeneratedTeamID());
	        // Handle the case where a duplicate ID is found
	        response.put("message", "Team with the same ID already exists.");
	        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	    } else {
	        // Proceed with saving the new team
	    	team.setTeamCreator(user.getFirstName() + " " + user.getLastName());
	        team.setCreationDate(TimeDateUtility.getCreationDate());
	        team.setManager("Ron Caheal");
	        team.setTeamName("The Testing Team!");
	        
	        teamRepository.save(team);
	        logger.info("Successfully saved the team.");

	        response.put("message", "Team created successfully. " + team.getTeamID());
	        response.put("team", team);
	        return ResponseEntity.ok(response);
	    }
	}

}

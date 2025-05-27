package xruisu.project.unitylink.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import xruisu.project.unitylink.teams.Team;
import xruisu.project.unitylink.teams.TeamRepository;
import xruisu.project.unitylink.user.User;
import xruisu.project.unitylink.user.UserRepository;

@Service
public class SearchService {

    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    public SearchService(TeamRepository teamRepository, UserRepository userRepository) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
    }

    // Search both teams and users, return them separately in a Map
    public Map<String, Object> search(String query) {
        Optional<Team> teams = teamRepository.findById(query); // Search for teams
        Optional<User> users = userRepository.findById(query); // Search for users

        Map<String, Object> searchResults = new HashMap<>();
        searchResults.put("teams", teams); // Put list of teams into the map
        searchResults.put("users", users); // Put list of users into the map

        return searchResults; // Return the map containing both
    }
}

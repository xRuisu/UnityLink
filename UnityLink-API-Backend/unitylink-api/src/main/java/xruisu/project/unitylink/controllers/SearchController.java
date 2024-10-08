package xruisu.project.unitylink.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xruisu.project.unitylink.services.SearchService;
@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search-results")
    public ResponseEntity<Map<String, Object>> search(@RequestParam("query") String query) {
        Map<String, Object> results = searchService.search(query);
        return ResponseEntity.ok(results);
    }
  
    @PostMapping("/search")
    public String handleSearch(@RequestParam("query") String query) {
    	Map<String, Object> results = searchService.search(query);
    	
        // You can add logic here to validate the query, check the database, etc.

        // Redirect to the search results page, passing the query as a parameter
        return "redirect:/search-results?query=" + query;
    }
    
}

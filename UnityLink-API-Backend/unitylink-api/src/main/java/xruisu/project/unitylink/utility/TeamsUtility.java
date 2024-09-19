package xruisu.project.unitylink.utility;

import java.security.SecureRandom;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TeamsUtility {

	private static final Logger logger = LoggerFactory.getLogger(TeamsUtility.class);
	
	private final int LENGTH = 3;
	public static long authCount = 0;
	
	public String getGeneratedTeamID() {
		logger.info(":: @TeamsUtility :: -> Generating... ");
		
		var id = generateRandomChar(LENGTH) + generateRandomNumber(LENGTH) + "@"+authCount;
	
		logger.info(":: @TeamsUtility :: -> Successfully created new team id: " + id);
		
		return id;
	}

	private String generateRandomChar(int length) {
		
		final var CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		
		var random = new SecureRandom();
		var builder = new StringBuilder(length);
		
		for (var i = 0; i < length; i++) {
			var randomIndex = random.nextInt(CHARACTERS.length());
			var randomChar = CHARACTERS.charAt(randomIndex);
			builder.append(randomChar);
		}
		return builder.toString();
	}

	private int generateRandomNumber(int length) {
		
		var random = new Random();
		
		int minValue = (int) Math.pow(10, LENGTH - 1);
		int maxValue = (int) Math.pow(10, LENGTH) - 1;
		
		return random.nextInt(maxValue - minValue + 1) + minValue;
	}
}

package xruisu.project.unitylink.utility;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xruisu.project.unitylink.barcode.ZXing;

public class UserUtility {

	private static final Logger logger = LoggerFactory.getLogger(UserUtility.class);

	private static String UniqueUserID;
		
	public static String validateUUID() {
		var randomUUID = UUID.randomUUID();
		logger.info("Initializing validater...");
		if(!getUniqueUserID().isBlank()) {
		final var uid = "@"+getUniqueUserID() + "-" + randomUUID.toString();
		logger.info("Success: Validated and generating uuid...");
		return uid;
		} else {
			logger.warn("Failed, required variables missing!");
			return null;
		}
	}
	
	public static void generateUID(String firstName, String lastName) {

		//Get decoded barcode data from ZXingDecoder.class
		String decodedData = ZXing.getDecodedData();
		logger.info(":: @UIDGenerator :: -> Successfully assigned FID to a variable!");

		//First initial from firstName
		var firstChar = firstName.charAt(0);
		logger.info(":: @UIDGenerator :: -> Successfully got first initial!");
		//Last initial from lastName 
		var lastChar = lastName.charAt(0);
		logger.info(":: @UIDGenerator :: -> Successfully got last initial!");
		//For easy readability and longer UID length we will fill after first initial and last initial
		final var filler = 0;

		//Checks if FID is greater than 3
		if (decodedData.length() >= 3) {
			logger.info(":: @UIDGenerator :: -> The FID successfully passed length requirements!");
			//Grabs FID number from barcode, then cuts it down to the last three digits of the fid
			var NumUID = decodedData.substring(decodedData.length() - 3);
			logger.info(":: @UIDGenerator :: -> Successfully shortened FID!");
			//Creates a new ID (Unique ID) out of the scanned id
			String UniqueUserID = Character.toString(firstChar) + filler + Character.toString(lastChar) + filler + NumUID;
			logger.info(":: @UIDGenerator :: -> Successfully created Unique ID: {" + UniqueUserID + "}");
			setUniqueUserID(UniqueUserID.toLowerCase());
		} else {
			//Handles if FID is less than 3 digits long
			logger.error("@UIDGenerator :: -> Failed to generate UID! FID cannot be less than 3 digits!");
		}
		logger.info(":: @UIDGenerator :: -> Successfully assigned Unique ID to user!");
	}

	public static final String getUniqueUserID() {
		return UniqueUserID;
	}

	private static void setUniqueUserID(String UniqueUserID) {
		UserUtility.UniqueUserID = UniqueUserID;
	}
}

package xruisu.project.unitylink.utility;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xruisu.project.unitylink.barcode.ZXing;

public class UserUUIDUtility {
	
	private static final Logger logger = LoggerFactory.getLogger(UserUUIDUtility.class);


    private static String uniqueUserID;

    public static void generateUniqueUserID(String firstName, String lastName) {
        String decodedData = ZXing.getDecodedData();
        logger.info(":: @UIDGenerator :: -> Successfully assigned FID to a variable!");

        char firstChar = firstName.charAt(0);
        char lastChar = lastName.charAt(0);
        String filler = "0";

        if (decodedData.length() >= 3) {
            logger.info(":: @UIDGenerator :: -> The FID successfully passed length requirements!");
            String numUID = decodedData.substring(decodedData.length() - 3);
            logger.info(":: @UIDGenerator :: -> Successfully shortened FID!");
            uniqueUserID = String.format("%c%s%c%s%s", firstChar, filler, lastChar, filler, numUID).toLowerCase();
            logger.info(":: @UIDGenerator :: -> Successfully created Unique ID: {" + uniqueUserID + "}");
        } else {
            logger.error("@UIDGenerator :: -> Failed to generate UID! FID cannot be less than 3 digits!");
            throw new IllegalArgumentException("FID length must be at least 3.");
        }
    }

    public static String getUniqueUserID() {
        return uniqueUserID;
    }

    public static String generateUUIDWithUserID() {
        UUID randomUUID = UUID.randomUUID();
        logger.info(":: @UserSecurityService :: -> Initializing UUID generation...");
        if (!getUniqueUserID().isBlank()) {
            String uid = "@" + getUniqueUserID() + "-" + randomUUID.toString();
            logger.info(":: @UserSecurityService :: -> Successfully generated UUID: " + uid);
            return uid;
        } else {
            logger.warn(":: @UserSecurityService :: -> Required variables are missing!");
            return null; // handle throwing an exception or handling this case
        }
    }
}

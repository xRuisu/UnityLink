package xruisu.project.unitylink.barcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class ZXing extends ZXingDecoder {

	private static final Logger logger = LoggerFactory.getLogger(ZXing.class);

	@PostConstruct
	public void initialize() {
		logger.info(":: @ZXing :: -> Initializing...");

		//Set path to file
		setFilePath("C:\\Users\\ruisu\\Documents\\Desktop PC\\Downloads\\CodeReader\\fid.jpg");

		//Convert the image to grayscale
		logger.info(":: @ZXing :: -> Converting...");
		convertImage();


		//Decode the image file
		logger.info(":: @ZXing :: -> Decoding...");
		decodeBarcode();
		logger.info(":: @ZXing :: -> Complete.");
	}
}

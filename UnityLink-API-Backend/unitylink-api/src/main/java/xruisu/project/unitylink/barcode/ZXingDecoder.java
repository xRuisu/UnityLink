package xruisu.project.unitylink.barcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;

public abstract class ZXingDecoder extends ZXingConverter implements ZXingable {

	private static final Logger logger = LoggerFactory.getLogger(ZXingDecoder.class);

	private static String decodedResult;

	@Override
	public void decodeBarcode() {
		try {
			setDecodedData(new MultiFormatReader().decode(getBitmap()).toString());
			logger.info(":: @ZXingDecoder :: -> Data decoded successfully:  {" + getDecodedData() + "}");
		} catch (NotFoundException e) {
			e.printStackTrace();
			logger.warn(":: @ZXingDecoder :: -> The decoder failed! Something went wrong!");
			logger.debug("ZXingDecoderDebugger: " + getDecodedData());
		}
	}

	public static String getDecodedData() {
		return decodedResult;
	}

	private void setDecodedData(String decodedData) {
		ZXingDecoder.decodedResult = decodedData;
	}
}

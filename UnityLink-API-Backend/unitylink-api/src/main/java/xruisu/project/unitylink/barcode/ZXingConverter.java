package xruisu.project.unitylink.barcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public abstract class ZXingConverter implements ZXingable {

	private static final Logger logger = LoggerFactory.getLogger(ZXingConverter.class);

	private BufferedImage img;
	private LuminanceSource src;
	private BinaryBitmap bitmap;
	private String filePath;

	public void convertImage() {
		try {
			setImg(ImageIO.read(new File(getFilePath())));
			setSrc(new CLuminance(getImg()));
			setBitmap(new BinaryBitmap(new HybridBinarizer(getSrc())));
		} catch(IOException e) {
			e.printStackTrace();
			logger.warn(":: @ZXingConverter :: -> Failed to convert image!");
		}
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	protected BinaryBitmap getBitmap() {
		return bitmap;
	}
	private String getFilePath() {
		return filePath;
	}
	private BufferedImage getImg() {
		return img;
	}
	private void setImg(BufferedImage img) {
		this.img = img;
	}
	private LuminanceSource getSrc() {
		return src;
	}
	private void setSrc(LuminanceSource src) {
		this.src = src;
	}
	private void setBitmap(BinaryBitmap bitmap) {
		this.bitmap = bitmap;
	}

}
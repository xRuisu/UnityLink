package xruisu.project.unitylink.barcode;

import java.awt.image.BufferedImage;

import com.google.zxing.LuminanceSource;

class CLuminance extends LuminanceSource {
	private final byte[] luminances;

	public CLuminance(BufferedImage image) {
		super(image.getWidth(), image.getHeight());
		int width = image.getWidth();
		int height = image.getHeight();
		luminances = new byte[width * height];
		int[] pixels = image.getRGB(0, 0, width, height, null, 0, width);
		for (int y = 0; y < height; y++) {
			int offset = y * width;
			for (int x = 0; x < width; x++) {
				int pixel = pixels[offset + x];
				int r = (pixel >> 16) & 0xff;
				int g = (pixel >> 8) & 0xff;
				int b = pixel & 0xff;
				luminances[offset + x] = (byte) ((r + g + b) / 3);
			}
		}
	}

	@Override
	public byte[] getRow(int y, byte[] row) {
		if (row == null || row.length < getWidth()) {
			row = new byte[getWidth()];
		}
		System.arraycopy(luminances, y * getWidth(), row, 0, getWidth());
		return row;
	}

	@Override
	public byte[] getMatrix() {
		return luminances;
	}
}
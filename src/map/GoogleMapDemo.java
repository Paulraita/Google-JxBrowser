package map;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GoogleMapDemo {
	public static void main(String[] args) throws IOException {
		JFrame test = new JFrame("Google Maps");
		try {
			String latitude = "40.714728";
			String longitude = "-73.998672";
			String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=" + latitude + "," + longitude
					+ "&zoom=11&size=612x612&scale=2&maptype=roadmap";
			String destinationFile = "img/image.jpg";

			// read the map image from Google
			// then save it to a local file: image.jpg
			URL url = new URL(imageUrl);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(destinationFile);
			byte[] b = new byte[2048];
			int length;
			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}
			is.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		// create a GUI component that loads the image: image.jpg
		//
		ImageIcon imageIcon = new ImageIcon(
				(new ImageIcon("image.jpg")).getImage().getScaledInstance(630, 600, java.awt.Image.SCALE_SMOOTH));
		test.add(new JLabel(imageIcon));
		// show the GUI window
		test.setVisible(true);
		test.pack();
	}
}
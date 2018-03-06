package map;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

public class BrowserSample {
	public static void main(String[] args) {
		
		System.setProperty("teamdev.license.info", "true");
		Browser browser = new Browser();
		BrowserView browserView = new BrowserView(browser);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(browserView, BorderLayout.CENTER);
		frame.setSize(700, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		browser.loadURL("http://maps.google.com");
	}
}
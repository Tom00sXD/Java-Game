package com.tom00s.engine;
import javax.swing.*;

import java.awt.*;

public class WindowManager {
	private static int resX;
	private static int resY;
	
	private static String gamename;
	private static String lFile;
	
	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();
	
	public static void createF(String FrameTitle, int FWidth, int FHeight) {
		gamename = FrameTitle; resX = FWidth; resY = FHeight;
		frame.setName("Main frame");
		frame.setTitle(gamename);
		frame.setSize(resX, resY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	public static void addP() {
		panel.setSize(resX, resY);
		System.out.println("Panel created in frame " + frame.getName() + " with sizes: (" + panel.getWidth() + ", " + panel.getHeight() + ")");
		frame.add(panel);
	}
	public static void updt(Component obj) {
		frame.remove(obj);
		frame.add(obj);
		SwingUtilities.updateComponentTreeUI(frame);
	}
}
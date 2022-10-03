package com.tom00s.engine;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Game {
	
	public static Boolean running = true;
	public static int nextUpdate = 0;
	public static int runT = 0;
	public static int fps;
	
	public static void game() {
		JPanel panel = WindowManager.panel;
		JFrame frame = WindowManager.frame;

		LocalDate date;
		LocalTime time = LocalTime.now();
		int fSec = time.getSecond() / 10;

		JLabel label = new JLabel("", SwingConstants.CENTER);
		label.setText("Amogus");
		label.setVisible(true);
		frame.add(label);
		
		while (running = true) { //Main loop
			time = LocalTime.now();
			date = LocalDate.now();
			nextUpdate = runT + 1 / 10;
			runT = time.getSecond() / 10 - fSec;
			
			if (runT == nextUpdate) {
				nextUpdate++;
				//System.out.println("Run time: " + runT + "s");
				label.setText(Integer.toString(runT));
				WindowManager.updt(label);
			}
		}
	}
}

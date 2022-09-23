package com.tom00s.engine;

import java.util.Scanner;

public class Main {
	
	private static String file;
	private static String TLFile = "/assets/config.json"; //If the game is on play testing mode, open the default launch config file
	private static Boolean isPlayTest = false;
	
	public static void main(String[] args) {
		Boolean running = Game.running;
		running = true;
		
		if (!isPlayTest == true) {
			if (args.length == 0) {
				checkFiles(0);
			} else {
				file = args[0];
				checkFiles(1);
			}
		} 
		
		else {
			checkFiles(2);
		}
		
	}
	private static void checkFiles(int state) {
		switch (state) {
			case 0:
				Scanner sc = new Scanner(System.in);
				System.err.println("Error: Launch configuration file not specified. Press any key to continue.");
				sc.nextLine();
				System.exit(0);
			
			case 1:
				String lFile = file;
				
				
				WindowManager.createF(
						LaunchFileRead.getString(lFile, "gamename"), 
						LaunchFileRead.getVal(lFile, "sizeX"), 
						LaunchFileRead.getVal(lFile, "sizeY")
						);
				System.out.println("Game running");
				Game.game();
			case 2:

				WindowManager.createF(
						LaunchFileRead.getString(TLFile, "gamename"), 
						LaunchFileRead.getVal(TLFile, "sizeX"), 
						LaunchFileRead.getVal(TLFile, "sizeY")
						);
				System.out.println("Game running");
				Game.game();
		}
		}
}
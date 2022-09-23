package com.tom00s.engine;
import java.io.InputStream;
import java.util.Scanner;

import org.json.JSONTokener;
import org.json.*;

public class LaunchFileRead {
	
    private static String resourceName;
    private static InputStream is;
    private static String obj;
    private static int val;
    private static int ver = 3;
    
    private static void openFile(String res) {
    	resourceName = res;
        is = LaunchFileRead.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }
    }
    
    /* 
    private static void verCheck(String file) { //Workin' on this, can't get the game to stop when verR != ver
    	int verR = getVal(file, "ver");
    	Scanner sc = new Scanner(System.in);
    	if (verR == ver) {
    	} else if (ver > verR){
    		System.err.println("Game configuration file is outdated! Please change and run again");
    		System.out.println("Press any key to continue.");
    		sc.nextLine();
    		System.exit(0);
    	} else {
    		System.err.println("Game configuration file is too new! Please change and run again");
    		System.out.println("Press any key to continue.");
    		sc.nextLine();
    		System.exit(0);
    	}
    } */
    
    public static String getString(String file, String Object) {
		openFile(file);
		
    	JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);
        
		obj = object.getString(Object);
		
    	return obj;
    }
    
    public static int getVal(String file, String Object) {
		openFile(file);
		
    	JSONTokener tokener = new JSONTokener(is);
    	JSONObject object = new JSONObject(tokener);
    	
    	val = object.getInt(Object);
    	
    	return val;
    }
}
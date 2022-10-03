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
    public static int ver = 3;
    
    private static void openFile(String res) {
    	resourceName = res;
        is = LaunchFileRead.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }
    }
    
    
    public static void verCheck(String file) {
    	String verS = getString(file, "ver");
    	int verR = Integer.parseInt(verS);
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.print(ver + verR);
    	if (verR > ver && verR < ver) {
    		return;
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
    }
    
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

package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public final class GameLog {
	private static String log = "-----------------------Welcome Traveler----------------------- \n\n";
	private static boolean writing = false;
	
	public static void writeToLog(String subject, String object){
		if (object == "")
			return;
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date today = Calendar.getInstance().getTime(); 
		String reportDate = df.format(today);
		object = reportDate + ": " + subject + ":\n----------------------------------\n" + object;
		object += "\n-----------------------------------------------------------------------\n";
		log+=object;
		writing = true;
	} 
	public static void doneWriting(){
		writing = false;
	}
	public static boolean isWriting(){
		return writing;
	}
	public static String getLog(){
		writing = false;
		return log;
	}

}

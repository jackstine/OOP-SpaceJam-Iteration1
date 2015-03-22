package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public final class GameLog {
	private static String log = "<html><html>";
	private static boolean writing = false;
	
	
	public static void write(String s){
		GameLog.writeToLog(s);
	}
	public static void writeToLog(String object){
		if (object == "")
			return;
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date today = Calendar.getInstance().getTime(); 
		String reportDate = df.format(today);
		object = reportDate + ": \n--------------------------------------------\n" + object;
		object += "\n--------------------------------------------\n";
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
		System.out.println(log);
		writing = false;
		return log;
	}

}

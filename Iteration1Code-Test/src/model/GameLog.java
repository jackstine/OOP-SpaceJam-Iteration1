package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public final class GameLog {
	private static String log = "hi";
	private static boolean writing = false;
	
	
	public static void write(String s){
		GameLog.writeToLog(s);
	}
	public static void writeToLog(String s){
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date today = Calendar.getInstance().getTime(); 
		String reportDate = df.format(today);
		s = reportDate + ": \n--------------------------------------------\n" + s;
		s += "\n--------------------------------------------\n";
		log+=s;
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

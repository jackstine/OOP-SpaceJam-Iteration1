package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public final class GameLog {
	private static ArrayList<String> log = new ArrayList<String>();
	private static boolean writing = false;
	
	public static void writeToLog(String s){
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date today = Calendar.getInstance().getTime(); 
		String reportDate = df.format(today);
		s = reportDate + ": \n--------------------------------------------\n" + s;
		s += "\n--------------------------------------------\n";
		if(log.size() > 20){
			log.remove(0);
		}
		log.add(s);
		writing = true;
	} 
	public static void doneWriting(){
		writing = false;
	}
	public static boolean isWriting(){
		return writing;
	}
	public static String getLog(){
		String j = "";
		for(int i = 0; i < log.size(); ++i){
			j += log.get(i);
		}
		return j;
	}

}

package utilities;

import java.awt.Font;
import java.io.File;

public class FontHandler {
	
	public Font ApocalypseNowFont(){
		try{
		return Font.createFont(Font.TRUETYPE_FONT, new File("src/res/fonts/Apocalypse_Now.ttf"));
		} catch (Exception e){
			System.out.println("Whoops");
		}
		return null;
	}
	
	public Font AfterDisasterFont(){
		try{
			return Font.createFont(Font.TRUETYPE_FONT, new File("src/res/fonts/After_Disaster.ttf"));
		} catch (Exception e){
			System.out.println("Whoops");
		}
		return null;
}
}
package utilities;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

public class FontHandler {
	
	public Font ApocalypseNowFont(){
		try{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/res/fonts/Apocalypse_Now.ttf")));
		return Font.createFont(Font.TRUETYPE_FONT, new File("src/res/fonts/Apocalypse_Now.ttf"));
		} catch (Exception e){
			System.out.println("Whoops");
		}
		return null;
	}
	
	public Font AfterDisasterFont(){
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/res/fonts/After_Disaster.ttf")));
			return Font.createFont(Font.TRUETYPE_FONT, new File("src/res/fonts/After_Disaster.ttf"));
		} catch (Exception e){
			System.out.println("Whoops");
		}
		return null;
}
}
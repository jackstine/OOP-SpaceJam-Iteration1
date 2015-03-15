package utilities;

import java.applet.AudioClip;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.applet.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import sun.applet.Main;

public class BackgroundMusicPlayer {

	private static final String filePath = "src/res/audio/HumanAbstract-CrossingTheRubicon8Bit.wav";
	private static URL mp3URL = null;
	private static AudioClip clip = null;
	
	public BackgroundMusicPlayer() {
		fetchMP3URL();
		if (mp3URL != null) {
			playMusic();
		}
	}
	
	private void playMusic() {
		MusicThread thread = new MusicThread();
		thread.start();
	}
	
	private void fetchMP3URL() {
		
		try {
			mp3URL = new File(filePath).toURI().toURL();
			System.out.println("Background music successfully initialized.");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error finding sound file.");
		}
		
	}
	
	private class MusicThread extends Thread {
		@Override
		public void run() {
			try {
			;
		        Clip clip = AudioSystem.getClip();
		        // getAudioInputStream() also accepts a File or InputStream
		        AudioInputStream ais = AudioSystem.
		            getAudioInputStream( mp3URL );
		        clip.open(ais);
		        clip.loop(Clip.LOOP_CONTINUOUSLY);
		        System.out.println("LOOPIN AND A LOOPIN");
		   
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

package utilities;

import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public abstract class SoundEffect {
	private static URL mp3URL = null;
	private static AudioClip clip = null;
	
	public SoundEffect() {
		fetchMP3URL();
		if (mp3URL != null) {
			playMusic();
		}
	}
	
	public URL getURL() {
		return mp3URL;
	}
	
	protected abstract String getFilePath();
	
	protected void playMusic() {
		MusicThread thread = new MusicThread();
		thread.start();
	}
	
	protected void fetchMP3URL() {
		
		try {
			mp3URL = new File(getFilePath()).toURI().toURL();
			System.out.println("Sound effect successfully initialized.");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error finding sound file.");
		}
		
	}
	
	protected class MusicThread extends Thread {
		@Override
		public void run() {
			try {
			;
		        Clip clip = AudioSystem.getClip();
		        // getAudioInputStream() also accepts a File or InputStream
		        AudioInputStream ais = AudioSystem.
		            getAudioInputStream( mp3URL );
		        clip.open(ais);
		        clip.loop(0);
		   
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

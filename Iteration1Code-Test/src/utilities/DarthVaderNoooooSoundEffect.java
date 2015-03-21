package utilities;

public class DarthVaderNoooooSoundEffect extends SoundEffect{

public DarthVaderNoooooSoundEffect() {
		
		fetchMP3URL();
		if (getURL() != null) {
			playMusic();
		}
	}
	
	
	@Override
	protected String getFilePath() {
		// TODO Auto-generated method stub
		return "src/res/audio/nooo.wav";
	}

}

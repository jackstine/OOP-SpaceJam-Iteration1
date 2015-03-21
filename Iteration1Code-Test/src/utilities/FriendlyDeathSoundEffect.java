package utilities;

public class FriendlyDeathSoundEffect extends SoundEffect{

public FriendlyDeathSoundEffect() {
		
		fetchMP3URL();
		if (getURL() != null) {
			playMusic();
		}
	}
	
	@Override
	protected String getFilePath() {
		// TODO Auto-generated method stub
		return "src/res/audio/FriendlyDeath.wav";
	}

}

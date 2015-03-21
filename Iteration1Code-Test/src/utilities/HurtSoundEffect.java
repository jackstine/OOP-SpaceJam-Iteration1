package utilities;

public class HurtSoundEffect extends SoundEffect {

	public HurtSoundEffect() {
		
		fetchMP3URL();
		if (getURL() != null) {
			playMusic();
		}
		
	}
	
	@Override
	protected String getFilePath() {
		// TODO Auto-generated method stub
		int x = (int) (Math.random() * 2);
		return  x==0 ? "src/res/audio/Pain.wav" : "src/res/audio/MaleGrunt.wav";
	}

}

package utilities;

public class DeathSoundEffect extends SoundEffect {

	public DeathSoundEffect() {
		
		fetchMP3URL();
		if (getURL() != null) {
			playMusic();
		}
		
	}
	
	@Override
	protected String getFilePath() {
		// TODO Auto-generated method stub
		return "src/res/audio/EnemyDeath.wav";
	}

}


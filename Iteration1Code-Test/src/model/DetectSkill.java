package model;

public class DetectSkill extends Skill {
	//might need to pass some type of handler maybe. Should know about the map or the tile
	//with a trap on it.
	
	public DetectSkill(){
		super();
	}
	
	public String toString() {
		return "Detect:" + this.getSkillLevel();
	}
	
	public void displayTrap(){  //influence radius stuff in here perhaps
		if(this.getSkillLevel()>5/*placeholder 5*/){ //scan through current tile radius and check for traps.
			// make traps visible.  //check each tile for trap. If trap then display if detect level
									//high enough.
		}
	}

}

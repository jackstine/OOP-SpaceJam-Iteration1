package model;

import java.util.HashMap;
import java.util.Map;

public class HunterSkillFactory extends SkillFactory {

	protected Map<String, Skill> createOccupationSkills() {
		Map<String, Skill> map = new HashMap<String, Skill>();
		
		Skill creep = new CreepSkill();
		Skill pickPocket = new PickPocketSkill();
		Skill rangedWeapon = new RangedWeaponSkill();
		Skill trap = new TrapSkill();
		
		map.put("Creep", creep);
		map.put("Pick pocket", pickPocket);
		map.put("Ranged weapon", rangedWeapon);
		map.put("Trap", trap);
		
		return map;
	}
}

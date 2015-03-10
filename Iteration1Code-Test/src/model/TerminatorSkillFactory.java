package model;

import java.util.HashMap;
import java.util.Map;

public class TerminatorSkillFactory extends SkillFactory {

	protected Map<String, Skill> createOccupationSkills() {
		Map<String, Skill> map = new HashMap<String, Skill>();
		
		Skill oneHandedWeapon = new OneHandedWeaponSkill();
		Skill twoHandedWeapon = new TwoHandedWeaponSkill();
		Skill brawling = new BrawlingSkill();
		
		map.put("One-handed weapon", oneHandedWeapon);
		map.put("Two-handed weapon", twoHandedWeapon);
		map.put("Brawling", brawling);
		
		return map;
	}
}

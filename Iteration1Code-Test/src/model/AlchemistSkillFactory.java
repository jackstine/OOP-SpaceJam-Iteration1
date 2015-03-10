package model;

import java.util.HashMap;
import java.util.Map;

public class AlchemistSkillFactory extends SkillFactory {

	protected Map<String, Skill> createOccupationSkills() {
		Map<String, Skill> map = new HashMap<String, Skill>();
		
		Skill bane = new BaneSkill();
		Skill boon = new BoonSkill();
		Skill enchantment = new EnchantmentSkill();
		Skill staff = new StaffSkill();
		
		map.put("Bane", bane);
		map.put("Boon", boon);
		map.put("Enchantment", enchantment);
		map.put("Staff", staff);
		
		return map;
	}
}
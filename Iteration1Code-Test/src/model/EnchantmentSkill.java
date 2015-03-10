package model;

public class EnchantmentSkill extends Skill {
	
	public EnchantmentSkill() {
		super();
	}
	
	public String toString() {
		return "Enchantment:" + this.getSkillLevel();
	}
}

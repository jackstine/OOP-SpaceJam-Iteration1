package model.visitor;

import model.entity.Entity;
import model.items.AlchemistWeapon;
import model.items.HunterWeapon;
import model.items.TerminatorBrawling;
import model.items.TerminatorSingleWeapon;
import model.items.TerminatorTwoHandedWeapon;

public class WeaponVisitor{
	public Entity entity;
	public int skill;
	
	public WeaponVisitor(Entity entity){
		this.entity = entity;
	}
	
	public void accept(TerminatorSingleWeapon w){
		this.skill = entity.getSkillValue("One-handed weapon");
	}
	
	public void accept(TerminatorTwoHandedWeapon w){
		this.skill = entity.getSkillValue("Two-handed weapon");
	}
	
	public void accept(TerminatorBrawling w){
		this.skill = entity.getSkillValue("Brawling");
	}
	
	public void accept(HunterWeapon w){
		this.skill = 0;
	}
	
	public void accept(AlchemistWeapon w){
		this.skill = 0;
	}
	
	public int getSkill(){return this.skill;}

}

package model.visitor;

import model.TrapHandler;
import model.entity.Entity;
import model.occupation.*;

public class OccupationVisitor {
	private Entity entity;
	private Occupation occupation;
	boolean val=false;
	
	public OccupationVisitor(Entity entity){
		this.entity=entity;
	}
	
	public void accept(Terminator t){
		setBoolean(false);
	}
	
	public void accept(Alchemist a){
		setBoolean(false);
	}
	
	public void accept(Hunter h){
		setBoolean(true);
	}
	
	public boolean getBoolean(){
		return val;
	}
	
	public void setBoolean(boolean val){
		this.val=val;
	}
	
	
	
	
	
}

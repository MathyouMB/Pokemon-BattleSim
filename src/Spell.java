
public class Spell extends Action{//spells do dmg or magic damage, they extend action
	
    public Spell(String name, boolean  aspect,int DamC) {
    	super(name, true);
    	this.damageCentre=DamC;
    	this.physicalOrMagic=aspect;
    }
    
    
}


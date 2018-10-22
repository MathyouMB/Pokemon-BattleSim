
public class Action {
		
		///Action///////////////////
		String name; 
		boolean physicalOrMagic;//true for physical, false for magic //physical or magic  physical moves use strength stat, magic use wisdom and charisma
		boolean typeOfMove; //true for spell, false for spell

		///Spell/////////////////////
		int damageCentre;
		int damageMod;

		///Support/////////////
		int statIndex;
		int statAmmount;
		
	   public Action(String name, boolean isDamaging) { 
	    	this.name=name;
	    	this.typeOfMove=isDamaging;
	   }
    
	   public String Intruction() { // prints on the buttons so you can see what attacks do
		   if (typeOfMove) {
			   if (physicalOrMagic) {
				   return(" ("+damageCentre+ " + STR"+")");
			   } else {
				   return(" ("+damageCentre+ " + ITG"+")");
			   }
		   } else {
				   return(" (+ "+statAmmount+")");
			   }
		   }
	   
    
    
}


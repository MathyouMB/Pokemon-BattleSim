
public class Support extends Action{ //support actions raise stats, they extend action
		
    public Support(String name, int st, int ammount) {
    	super(name,false);
    	statIndex = st;
    	statAmmount = ammount;
    }
    
    
}



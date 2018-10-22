import java.net.MalformedURLException;
import java.util.ArrayList;

public class MonsterGroup { //hold the player's, and enemy's monsters
	ArrayList <Monster> monsters = new ArrayList();
	final int TOTALMONSTERSCREATED = 14;
	final int DONTPUTTESTINPARTY = 1;
	
	public MonsterGroup() throws MalformedURLException{ //for player and enemy groups
		
	}
	
	public MonsterGroup(boolean full) throws MalformedURLException{ //generates the main monster list
		if (full == true){
		for (int monsterIndex = 0; monsterIndex <= TOTALMONSTERSCREATED; monsterIndex++) {
		
				monsters.add(new Monster(monsterIndex));

			}
		}
	}
	
	public void resetParty(){ //resets party (gets called when you leave that screen)
		//System.out.println("started remove---");
		monsters.clear();
	}
	public void printParty(){ //testing method)
	//	 System.out.println("party----");
		for (int i = 0; i < monsters.size(); i++) {
			 System.out.println(monsters.get(i));
			
		}
	}
	
	public void generateEqualParty(int m) throws MalformedURLException{ //generates opponents team.... (m is the size of the players monster group)
		// System.out.println("Opponent----");
		
		for (int i = 0; i < m; i++) {
			 int randomgen=(int)(Math.random()*TOTALMONSTERSCREATED-DONTPUTTESTINPARTY ); //generate m ammount of the 14 monsters to form an enemy team - 1 because 14 is the test character
			 this.monsters.add(new Monster(randomgen));
			
		}
		//this.printParty();
	}
}

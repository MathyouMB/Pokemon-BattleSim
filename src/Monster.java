import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Monster { // are the monsters
	ImageIcon icnPicture; //picture of that monster
	String Name; // monsters name
	Stats MonsterStats; //stat handler
	ArrayList <Action> actionList = new ArrayList (); //a list of a monsters attacks
	String Lore; //holds that monsters lore string
	
	public Monster(int i) throws MalformedURLException{
		//these are essentially the placeholder templates you could put different monsters. For now they have the same moves but they could all be easily modified.
		
		if (i == 0){
			icnPicture = new ImageIcon(new URL("https://i.imgur.com/ozkFqHm.png"));
			Name = "CornMan";
			MonsterStats = new Stats(25,2,10,0,1,3);
			actionList.add(new Spell("Kernel Punch",true,5));
			actionList.add(new Spell("Magic Move",false,5));
			actionList.add(new Support("Increase ITG",5,4));
			actionList.add(new Support("Increase STR",2,4));
			Lore = ("Is a man, made of corn, yells angrily at opponents, telling them to eat their corn, does damage because he’s so loud, this is a special attack as it doesn’t contact its opponents.");
		}
		if (i == 1){
			icnPicture = new ImageIcon(new URL("https://i.imgur.com/umA6qvL.png"));
			Name = "Wizerd";
			MonsterStats = new Stats(20,1,10,3,0,5);
			actionList.add(new Spell("Staff Stab",true,5));
			actionList.add(new Spell("Book Throw",false,5));
			actionList.add(new Support("Increase STR",2,4));
			actionList.add(new Support("Increase CHA",6,2));
			Lore = ("Is actually not very smart, just throwing spell books at people, and hits them with his magic staff, knows absolutely no magic.");
		}
		if (i == 2){
			icnPicture = new ImageIcon(new URL("https://i.imgur.com/zDBtT96.png"));
			Name = "Paper Plane";
			MonsterStats = new Stats(20,0,10,-5,0,-4);
			actionList.add(new Spell("Papercut",true,5));
			actionList.add(new Spell("Poke Eye",false,7));
			actionList.add(new Support("Increase CHA",6,2));
			actionList.add(new Support("Increase STR",2,4));
			Lore = ("Very light but can easily and effectively stab people in the eye or give them paper cuts.");
		}
		if (i == 3){
			icnPicture = new ImageIcon(new URL("https://i.imgur.com/L7mvgJL.png"));
			Name = "BootGall";
			MonsterStats = new Stats(25,2,10,0,0,2);
			actionList.add(new Spell("Boot Kick",true,5));
			actionList.add(new Spell("Eye Lazer",false,5));
			actionList.add(new Support("Increase CON",4,4));
			actionList.add(new Support("Increase STR",2,3));
			Lore =("Could use its magic eye to use magic but prefers to simply kick people in stead.");
		}
		if (i == 4){
			icnPicture = new ImageIcon(new URL("https://i.imgur.com/CmfnD0J.png"));
			Name = "Epic lib";
			MonsterStats = new Stats(20,0,10,5,1,-5);
			actionList.add(new Spell("Not the Illuminati Slap",true,5));
			actionList.add(new Spell("Evil Glare",false,5));
			actionList.add(new Support("Increase ITG",5,4));
			actionList.add(new Support("Increase CHA",6,3));
			Lore = ("Is the opposite of the illuminati, therefore can’t do very much to many people.");
		}
		if (i == 5){
			icnPicture = new ImageIcon(new URL("https://i.imgur.com/Tw4F29A.png"));
			Name = "FledPlant";
			MonsterStats = new Stats(15,6,10,0,4,0);
			actionList.add(new Spell("Body Slam",true,5));
			actionList.add(new Spell("Eggplant Magic",false,5));
			actionList.add(new Support("Increase ITG",5,6));
			actionList.add(new Support("Increase CON",4,4));
			Lore = ("Punches and kicks people, can also set them on fire, with the fire surrounding its body.");
		}
		if (i == 6){
			icnPicture = new ImageIcon(new URL("https://i.imgur.com/Plktg0j.png"));
			Name = "Starboi";
			MonsterStats = new Stats(40,3,10,-2,1,-2);
			actionList.add(new Spell("Star Punch",true,2));
			actionList.add(new Spell("Star Beam",false,3));
			actionList.add(new Support("Increase ITG",5,1));
			actionList.add(new Support("Increase STR",2,1));
			Lore =("Is magical, being a star/group of stars, does a lot of damage and has a lot of health has very low defences.");
		}
		if (i == 7){
			icnPicture = new ImageIcon(new URL("https://i.imgur.com/VMwhuJx.png"));
			Name = "Triangular Guitar";
			MonsterStats = new Stats(20,0,10,-5,1,-3);
			actionList.add(new Spell("Triangular Punch",true,3));
			actionList.add(new Spell("Boosting Song",false,5));
			actionList.add(new Support("Increase ITG",5,4));
			actionList.add(new Support("Increase STR",2,7));
			Lore =("Magic as it plays music that can damage opponents or give boosts to it’s team.");
		}
		if (i == 8){
			icnPicture = new ImageIcon(new URL("https://i.imgur.com/DWGyZ8y.png"));
			Name = "Modern art in latin";
			MonsterStats = new Stats(15,0,10,-5,2,0);
			actionList.add(new Spell("Painting Smash",true,5));
			actionList.add(new Spell("Confusing Meaning",false,7));
			actionList.add(new Support("Increase ITG",5,4));
			actionList.add(new Support("Increase STR",2,4));
			Lore = ("Very much confuses opponents, also likes to smash itself into people then make them feel bad for breaking through the art.");
		/*poop*/} // that comment is Dallas' contribution ;-;
		if (i == 9){
			icnPicture = new ImageIcon(new URL("https://i.imgur.com/jAP9pJT.png"));
			Name = "Nando is Sad";
			MonsterStats = new Stats(17,-2,10,0,2,3);
			actionList.add(new Spell("Xenoblade Reference",true,5));
			actionList.add(new Spell("Xenoblade Reference 2",false,5));
			actionList.add(new Support("Increase ITG",5,4));
			actionList.add(new Support("Increase STR",2,4));
			Lore = ("Is constantly sad but can still hit opponents for lots of damage by smashing itself into opponents.");
		}
		if (i == 10){
			icnPicture = new ImageIcon(new URL("https://i.imgur.com/ilhdHqu.png"));
			Name = "Dpad";
			MonsterStats = new Stats(18,-4,10,0,2,-4);
			actionList.add(new Spell("Right Button",true,3));
			actionList.add(new Spell("Left Button",false,4));
			actionList.add(new Support("Increase ITG",5,4));
			actionList.add(new Support("Increase STR",2,7));
			Lore = ("Being a very emotional being, it uses magic based on the emotions of those around it.");
		}
		if (i == 11){
			icnPicture = new ImageIcon(new URL("https://i.imgur.com/7Yhej4m.png"));
			Name = "Mustache fairy";
			MonsterStats = new Stats(15,-2,10,-4,6,5);
			actionList.add(new Spell("Mustache Tickle",true,3));
			actionList.add(new Spell("Fairy Dust",false,6));
			actionList.add(new Support("Increase STR",2,4));
			actionList.add(new Support("Increase CHA",6,3));
			Lore =("Being a fairy it can inherently use magic however looking like a flying mustache also often confuses opponents.");
			
		}
		if (i == 12){
			icnPicture = new ImageIcon(new URL("https://i.imgur.com/K4Hq0Q0.png"));
			Name = "Neville";
			MonsterStats = new Stats(10,1,10,6,1,6);
			actionList.add(new Spell("Cat Joke",true,5));
			actionList.add(new Spell("Puurfect Joke",false,5));
			actionList.add(new Support("Increase ITG",5,4));
			actionList.add(new Support("Increase STR",2,4));
			Lore =("As a creation of the all powerful one, it has only a fraction of the power of Ms. Shaw.");
		}
		if (i == 13){ // the test character tbh 
			icnPicture = new ImageIcon(new URL("https://i.imgur.com/TlCzn6p.png"));
			Name = "Shaw";
			MonsterStats = new Stats(1000,1,10,1,1,1);
			actionList.add(new Spell("Instant Win",true,50));
			actionList.add(new Spell("Magic Move I guess",false,50));
			actionList.add(new Support("Increase ITG",5,4));
			actionList.add(new Support("Increase STR",2,4));
			Lore =("As the one in charge of the creators of the world, she is extremely powerful and nearly impossible to defeat.");
		}
		
		
	}
	public String toString(){
		 return this.Name;
	 }
	public String MonsterStats() { //this is the formatting for the stat and photo display on the battle screen
		String txt =("<html>Name: " +this.Name + "<br>---------------------<br>"+"HP: "+ this.MonsterStats.hp + "/"+this.MonsterStats.mhp+"<br>"+"STR: "+ this.MonsterStats.str+ "<br>"+"DEX: "+ this.MonsterStats.dex + "<br>"+"CON: "+ this.MonsterStats.con+ "<br>"+"ITG: "+ this.MonsterStats.itg + "<br>"+"CHA: "+ this.MonsterStats.cha+"</html>");	
		return txt;
		
	}
}

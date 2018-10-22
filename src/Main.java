import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

//Paul, Sky, and Matt
//03/11/2018
//The following program is a pokemon style battle system template. It has a working gui, monster templates, stats, and attacks. It is a prototype so there are a few bugs.

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {
	//gui stuff
	JLabel  lblTitleImage = new JLabel(""); // the title
	JLabel  lblPlayerStats = new JLabel(""); // current players monster stats on battle screen
	JLabel  lblEnemyStats = new JLabel(""); // current enemy's monster stats on abttle screen
	JLabel  lblBattleLog = new JLabel(""); // says the last action... who attacked.. who died etc.
	JLabel  lblLore = new JLabel(""); // displays Lore
	JButton btnPlay = new JButton("Play"); // the button on homescreen
	JButton btnStart = new JButton("Next"); //advances turns
	JButton btnBack = new JButton("Back"); // goes back a screen
	static JButton btnSelectMonsters []; // monsters on select screen
	static JButton btnSelectPlayerMonsters []; // hold selected monsters on select screen
	static JButton btnMonsterAttacks []; // the attack buttons on attack screen
	final int SELECTIONLOCATION = 100; //constant for forcing location space on buttons
	final int GUIMOVEOVER350 = 350;
	final int GUIMOVEDOWN50 = 50;
	final int GUIMOVEOVER240 = 240;
	// switching screen
	static int intCurrentScreen = 0; //index of which screen you are on
	static final int SCREENFORWARD = 1; 
	static final int SCREENBACKWARD = -1;
	//images
	final ImageIcon icnTitle = new ImageIcon(new URL("https://i.imgur.com/LUEszkG.png"));
	final ImageIcon icnBlank = new ImageIcon();
	//MonsterGroup
	static MonsterGroup monsterList; //a list of all monsters
	static MonsterGroup playerGroup; //the monsters the player is choosing / choosen
	static MonsterGroup enemyGroup; // the enemies monsters
	int intPartyPosition = -1; // used for keeping track of your space in players selected party on selection screen
	int currentMonsterIndex = 0; //index of players current monster (in battle)
	int currentEnemyMonsterIndex = 0; //index of enemy's current monster (in battle)
	boolean SelectedAttack = false; //turns true after you press an attack button

	public Main () throws MalformedURLException{//the contructor for all the gui stuff (where all gui stuff is added)
	
		playerGroup = new MonsterGroup();
		enemyGroup = new MonsterGroup();
		monsterList = new MonsterGroup(true);
		btnSelectMonsters = new JButton[monsterList.monsters.size()];
		btnSelectPlayerMonsters = new JButton[4];
		btnMonsterAttacks  = new JButton[5];
		
        JFrame gameFrame = new JFrame("IdontactuallyknowMon By Paul, Sky, and Matt");
	 	gameFrame.setLayout(null);
        gameFrame.setSize(800,600);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        
        lblTitleImage.setBounds(0,0,800,150);
        lblTitleImage.setBackground(Color.BLACK);
        lblTitleImage.setIcon(icnTitle);
        lblTitleImage.setVisible(true);
        
        lblPlayerStats.setBounds(100,50,800,150);
        lblPlayerStats.setBackground(Color.BLACK);
        lblPlayerStats.setVisible(false);
        
        lblEnemyStats.setBounds(450,50,800,150);
        lblEnemyStats.setBackground(Color.BLACK);
        lblEnemyStats.setVisible(false);
        
        lblBattleLog.setBounds(100,250,800,150);
        lblBattleLog.setBackground(Color.BLACK);
        lblBattleLog.setVisible(false);
        
        lblLore.setBounds(50,250,800,150);
        lblLore.setBackground(Color.BLACK);
        lblLore.setVisible(false);
        
        btnPlay.setSize(100,40);
        btnPlay.setVisible(true);
        btnPlay.setLocation(600,460);
        btnPlay.setBackground(Color.WHITE);
        btnPlay.addActionListener(this);
        
        btnStart.setSize(100,40);
        btnStart.setVisible(true);
        btnStart.setLocation(600,460);
        btnStart.setBackground(Color.WHITE);
        btnStart.addActionListener(this);
        
        btnBack.setSize(100,40);
        btnBack.setVisible(false);
        btnBack.setLocation(600,500);
        btnBack.setBackground(Color.WHITE);
        btnBack.addActionListener(this);
       
        
        
        //***This bit is for spacing the attack buttons in a square shape, after placing 2 buttons it moves the y down 50
      
        int k = 0;
        int count2 = 0; 
        for(int i = 0; i < btnMonsterAttacks.length-1; i++) {
        		
        		btnMonsterAttacks[i] = new JButton(String.valueOf(i));
        		btnMonsterAttacks[i].setSize(300,50);
        		btnMonsterAttacks[i].setLocation(SELECTIONLOCATION+(SELECTIONLOCATION+200)*count2,GUIMOVEOVER350+(GUIMOVEDOWN50)*k);
        		btnMonsterAttacks[i].setVisible(false);
        		btnMonsterAttacks[i].addActionListener(this);
	        	count2++;
	        	
	        	if (count2 >= 2){
        			k++;
        			count2= 0;
        		}

        }
        
        //*** this does the same thing as the last  bit except it spaces 7 monsters in a row before dropping a row down. This is the formatting for the selection screen
    
        int j = 0;
        int count7 = 0;
        for(int i = 0; i < monsterList.monsters.size(); i++) {
	        	btnSelectMonsters[i] = new JButton(String.valueOf(i));
	        	btnSelectMonsters[i].setSize(100,100);
	        	btnSelectMonsters[i].setIcon(monsterList.monsters.get(i).icnPicture);
	        	btnSelectMonsters[i].setLocation(GUIMOVEDOWN50+SELECTIONLOCATION*count7,SELECTIONLOCATION+SELECTIONLOCATION*j);
	        	btnSelectMonsters[i].setText(monsterList.monsters.get(i).Name);
	        	btnSelectMonsters[i].setVisible(false);
	        	btnSelectMonsters[i].addActionListener(this);
	        	count7++;
	        	
	        	if (count7 >= 7){
        			j++;
        			count7= 0;
        		}

        }
        
        for(int i = 0; i < btnSelectPlayerMonsters.length-1; i++) {
        	btnSelectPlayerMonsters[i] = new JButton(String.valueOf(i));
        	btnSelectPlayerMonsters[i].setSize(100,100);
        	btnSelectPlayerMonsters[i].setLocation(GUIMOVEOVER240+SELECTIONLOCATION*i,GUIMOVEOVER350);
        	btnSelectPlayerMonsters[i].setVisible(false);
        	btnSelectPlayerMonsters[i].addActionListener(this);
        }
        
        
        for(int i = 0; i < monsterList.monsters.size(); i++){
        	gameFrame.add(btnSelectMonsters[i]);
        }
        for(int i = 0; i < btnSelectPlayerMonsters.length-1; i++){
        	gameFrame.add(btnSelectPlayerMonsters[i]);
        }
        for(int i = 0; i < btnMonsterAttacks.length-1; i++){
        	gameFrame.add(btnMonsterAttacks[i]);
        }
        gameFrame.add(lblTitleImage);
        gameFrame.add(lblPlayerStats);
        gameFrame.add(lblEnemyStats);
        gameFrame.add(lblBattleLog);
        gameFrame.add(lblLore);
        gameFrame.add(btnPlay);
        gameFrame.add(btnStart);
        gameFrame.add(btnBack);
	}
	
	public static void main(String[]args) throws MalformedURLException{//printed test cases 
		Main gui = new Main();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//actionListener
	
		
		 if (e.getSource().equals(btnPlay)){
			try {
				switchScreen(SCREENFORWARD); //switch screen method controls which gui elements are visible
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		 }
		 //start turn
		 if (e.getSource().equals(btnStart)){
			turnOrder(); //start turn
		 }
		 if (e.getSource().equals(btnBack)){
			try {
				switchScreen(SCREENBACKWARD); //switch screen method controls which gui elements are visible
				resetGroups(); // make sure the monster groups are empty
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
	
		 }
		 
		 //select screen buttons
			for (int i = 0; i < btnSelectMonsters.length; i++) {
	            if (e.getSource() == btnSelectMonsters[i]) {
	            	btnPlay.setVisible(true); // if you pressed a select button you have a monster if your party and you can play
	            	if (intPartyPosition < 2){
		            	intPartyPosition++; // max out the party size at 3
		            	btnSelectPlayerMonsters[intPartyPosition].setIcon(monsterList.monsters.get(i).icnPicture); //set party icon to your selected monster
		            	lblLore.setText(monsterList.monsters.get(i).Lore); //display lore
		            	try {
							playerGroup.monsters.add(new Monster(i)); // add monster to party
						} catch (MalformedURLException e1) {
							e1.printStackTrace();
					}
		            	
		            	}
	            	
	            }
	         
	            
	        }
			
		//press attack button	
			for (int i = 0; i < btnMonsterAttacks.length; i++) {
	            if (e.getSource() == btnMonsterAttacks[i]) {
	            	btnStart.setVisible(true); // if you attacked you can press the advance turn button
	            	if (SelectedAttack == false){ // if havent attacked
	            		castAction(playerGroup,enemyGroup,currentMonsterIndex,currentEnemyMonsterIndex,i); //cast selected attack
	            		SelectedAttack = true; // you have attacked
	            	}
	            	changeArrayButtonVisibility(btnMonsterAttacks,false); // you have attacked so make attack buttons invisible
	            }
	         
	            
	        }
		
	}

	public void switchScreen(int screenIndex) throws MalformedURLException{ //controls whats visible on gui
		intCurrentScreen += screenIndex;
		if (intCurrentScreen == 0){
			setHomeScreen();
		}else if(intCurrentScreen == 1){
			setSelectScreen();
		}else if(intCurrentScreen == 2){
			setBattleScreen();
		}
		
		 
	}
	
    public void setHomeScreen(){ //every gui element visible on homescreen
	    lblTitleImage.setVisible(true);
		lblTitleImage.setIcon(icnTitle);
		btnPlay.setVisible(true);
		btnStart.setVisible(false);
		btnBack.setVisible(false);
		lblLore.setVisible(false);
		resetGroups();	
		changeArrayButtonVisibility(btnSelectMonsters,false);
		changeArrayButtonVisibility(btnSelectPlayerMonsters,false);
		  
	}
	
	public void setSelectScreen(){ //every gui element visible on select screen
		 lblTitleImage.setVisible(false);
		 btnPlay.setVisible(false);
		 btnStart.setVisible(false);
		 btnBack.setVisible(true);
		 enemyGroup.resetParty();
		 lblEnemyStats.setVisible(false);
		 lblBattleLog.setText(" ");
		 lblLore.setVisible(true);
		 lblLore.setText(" ");
		 lblPlayerStats.setVisible(false);
		 lblBattleLog.setVisible(false);
		 currentMonsterIndex = 0;
		 currentEnemyMonsterIndex = 0;
	   	 changeArrayButtonVisibility(btnSelectMonsters,true);
		 changeArrayButtonVisibility(btnSelectPlayerMonsters,true);
		 changeArrayButtonVisibility(btnMonsterAttacks,false);
		 
		 
	}
	
	public void setBattleScreen() throws MalformedURLException{ //every gui element visible on battle screen
		enemyGroup.generateEqualParty(playerGroup.monsters.size());
		 btnStart.setVisible(true);
		 btnPlay.setVisible(false);
		 lblLore.setVisible(false);
		 lblLore.setText(" ");
		 lblPlayerStats.setVisible(true);
		 lblPlayerStats.setText(playerGroup.monsters.get(0).MonsterStats());
		 lblPlayerStats.setIcon(playerGroup.monsters.get(0).icnPicture);
		 lblEnemyStats.setVisible(true);
		 lblEnemyStats.setText(enemyGroup.monsters.get(0).MonsterStats());
		 lblEnemyStats.setIcon(enemyGroup.monsters.get(0).icnPicture);		
		 lblBattleLog.setVisible(true);
		 changeArrayButtonVisibility(btnSelectMonsters,false);
		 changeArrayButtonVisibility(btnSelectPlayerMonsters,false);
		 fixMoveNames();
	}
	
	public void changeArrayButtonVisibility(JButton[] a,boolean b) {//method that sets all buttons in a button array to visible
		for (int i = 0; i < a.length - 1; i++) {
			 a[i].setVisible(b); // put a button for each hotel in the place of the find rooms button
			
		  }
	}
	
	public boolean dexCheck(Monster Ally, Monster Enemy){ //checks turn order
		
		
		///*** ok so in pokemon the dex stat decides who goes first, but because people can change there dex stat sometimes it changes the turn order.
		///*** for the sake of simplicity im gonna make it so despite the dex stat the enemy always goes first for now because with our gui it makes testing confusing.
		
		
		boolean turnOrder;
		if (Ally.MonsterStats.dex>Enemy.MonsterStats.dex){
			turnOrder=true; //if player has high dex he goes first
		}
		else if (Ally.MonsterStats.dex<Enemy.MonsterStats.dex){
			turnOrder=false;
		}
		else{
			Random rand = new Random(); // Generate the new random number
			int randomGen = rand.nextInt(10);
			if (randomGen>=6){
				turnOrder=true;
			}
			else{
				turnOrder=false;
			}
		}
	//	return turnOrder; //this would make dex manipulate turns
		
		return false; //enemy goes first
	}
	
	public void turnOrder() { //makes turn order
		
		if(dexCheck (playerGroup.monsters.get(currentMonsterIndex),enemyGroup.monsters.get(currentEnemyMonsterIndex))) {
			turn(0,1);//order 0 means the player
			
		} else {
			turn(1,1);//order 1 means enemy goes first

		}
		
	}
	
	public void turn(int order,int round) { //handles whos turn it is currently
		Random rand = new Random(); // Generate the new random number
		int randomGen = rand.nextInt(3); //every monster has 4 attacks so generate 0-3 as the action index
		
	  	SelectedAttack = false;//new turn so you havent attacked yet
		
	  	if (order == 0) { //player goes first
			//ask attack
			changeArrayButtonVisibility(btnMonsterAttacks,true); //if player is attacking display attack options
			btnStart.setVisible(false); // if attacking you cant go to next turn yet, so make the next turn button invisible
			if (SelectedAttack){ //if you attacked do these things
				if (round == 1) {
					CheckifMonsterDead();
					turn(0,round-1);
				} else{
					turnOrder(); // if your move is the 2nd move go back to the turn order maker when your done your move.
				}
			}
			
		} else if (order == 1) {//player goes secound
			
			//System.out.println(randomGen);
			castAction(enemyGroup,playerGroup,currentEnemyMonsterIndex,currentMonsterIndex,randomGen); //pick one of the 4 enemy attacks
			if (round == 1) {
				CheckifMonsterDead();
				turn(0,round-1);
			} else{
				turnOrder(); // if your move is the 2nd move go back to the turn order maker when your done your move.
			}
		}
		
	}
	
	public void castAction(MonsterGroup m, MonsterGroup m2, int i, int i2,int actionNum ) {//handles what every action does
		int dmg = 0;
			if (m.monsters.get(i).actionList.get(actionNum).typeOfMove) { // if your move is an attack and not support
				if (m.monsters.get(i).actionList.get(actionNum).physicalOrMagic) { // if the attack is physical
					dmg = (m.monsters.get(i).actionList.get(actionNum).damageCentre + m.monsters.get(i).MonsterStats.str - m2.monsters.get(i2).MonsterStats.con); // use physical dmg 
					if (dmg <= 0) {
						m2.monsters.get(i2).MonsterStats.hp -= 0; // if the stats make the skill go into the negatives make it zero so no one gains health
					} else {
					m2.monsters.get(i2).MonsterStats.hp -= dmg; //attack normally
					lblBattleLog.setText(m.monsters.get(i).Name+" used.. "+ m.monsters.get(i).actionList.get(actionNum).name+"."); //display the attack
					}
				} else { // if the attack is magic
					dmg = (m.monsters.get(i).actionList.get(actionNum).damageCentre + m.monsters.get(i).MonsterStats.itg - m2.monsters.get(i2).MonsterStats.cha); //use magic dmg
					if (dmg <= 0) {
						m2.monsters.get(i2).MonsterStats.hp -= 0;// if the stats make the skill go into the negatives make it zero so no one gains health
					} else {
					m2.monsters.get(i2).MonsterStats.hp -= dmg;//attack normally
					lblBattleLog.setText(m.monsters.get(i).Name+" used.. "+ m.monsters.get(i).actionList.get(actionNum).name+".");//display the attack
					}
		
				}
				refreshStats(); //refresh stats
			
			} else { // if the action is a support action
			
				lblBattleLog.setText(m.monsters.get(i).Name+" used.. "+ m.monsters.get(i).actionList.get(actionNum).name+"."); //display action in gui
				if(m.monsters.get(i).actionList.get(actionNum).statIndex == 5) { //if support skill raised itg
					m.monsters.get(i).MonsterStats.itg += m.monsters.get(i).actionList.get(actionNum).statAmmount;
				}
				if(m.monsters.get(i).actionList.get(actionNum).statIndex == 2) { //if support skill raised str
					m.monsters.get(i).MonsterStats.str += m.monsters.get(i).actionList.get(actionNum).statAmmount;
				}
				if(m.monsters.get(i).actionList.get(actionNum).statIndex == 6) { //if support skill raised cha
					m.monsters.get(i).MonsterStats.cha += m.monsters.get(i).actionList.get(actionNum).statAmmount;
				}
				if(m.monsters.get(i).actionList.get(actionNum).statIndex == 4) { //if support skill raised con
					m.monsters.get(i).MonsterStats.con += m.monsters.get(i).actionList.get(actionNum).statAmmount;
				}
				refreshStats(); //refresh stats
			}
			CheckifMonsterDead(); //check if anyone died after the attack was casted.
			
	}
	
	public void refreshStats() { // refresh gui displayed stats
		 lblPlayerStats.setVisible(true);
		 lblPlayerStats.setText(playerGroup.monsters.get(currentMonsterIndex).MonsterStats());
		 lblPlayerStats.setIcon(playerGroup.monsters.get(currentMonsterIndex).icnPicture);
		 lblEnemyStats.setVisible(true);
		 lblEnemyStats.setText(enemyGroup.monsters.get(currentEnemyMonsterIndex).MonsterStats());
		 lblEnemyStats.setIcon(enemyGroup.monsters.get(currentEnemyMonsterIndex).icnPicture);
		 
		fixMoveNames();
	}
	
	public void CheckifMonsterDead() { //check if you have won or lose or if a monster is out of hp
	
		if(playerGroup.monsters.get(currentMonsterIndex).MonsterStats.hp<=0) { // if hp is less than zero
			lblBattleLog.setText(playerGroup.monsters.get(currentMonsterIndex).Name+" has fainted because of an enemy attack."); //that monster died
			if (currentMonsterIndex+1 < playerGroup.monsters.size()) {
				currentMonsterIndex++; //switch to next monster if you still have monsters in your group
				refreshStats(); //refresh stats to current monsters stats
			} else {
				lblBattleLog.setText("Player out of monsters... you lose."); // if you have non left you lose
				gameOver();
			}
		}
		
		if(enemyGroup.monsters.get(currentEnemyMonsterIndex).MonsterStats.hp<=0) {// if hp is less than zero
			lblBattleLog.setText(enemyGroup.monsters.get(currentEnemyMonsterIndex).Name+" has fainted because of a player attack.");//that monster died
			if (currentEnemyMonsterIndex+1 < enemyGroup.monsters.size()) {
				currentEnemyMonsterIndex++;
				refreshStats();
			} else {
				lblBattleLog.setText("Enemy out of monsters... you Win!!!"); //if enemy has no monsters left you win
				gameOver();
			}
		}
	
	}
	
	public void gameOver() { // makes sure you have to press back when the game is over
		btnStart.setVisible(false);
		changeArrayButtonVisibility(btnMonsterAttacks,false);
		
	}
	
	public void fixMoveNames() { //updates names of moves displayed on attack buttons
		 for(int i = 0; i < btnMonsterAttacks.length-1; i++) {
				btnMonsterAttacks[i].setText(playerGroup.monsters.get(currentMonsterIndex).actionList.get(i).name+playerGroup.monsters.get(currentMonsterIndex).actionList.get(i).Intruction());
			 }
	}
	
	public void resetGroups() { //when you hit back make sure all monster groups are empty
		intPartyPosition = -1;
		playerGroup.resetParty();
		enemyGroup.resetParty();
		for (int i = 0;i<btnSelectPlayerMonsters.length-1;i++){
			btnSelectPlayerMonsters[i].setIcon(icnBlank);
		}
	}

}

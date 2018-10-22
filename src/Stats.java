import java.util.ArrayList;

public class Stats { //stat objects hold a monsters stats
//	final int NUMOFSTATS = 7;
	int hp; //hitPoints
	int mhp;
	int str;//Strength (physical attack mod)
	int dex;//Dexterity (decides turn order)
	int con;//Constitution (physical defense mod)
	int itg;//Intelligence (Magical attack mod)
	int cha;//Charisma (Magical defense mod)
	
	public Stats(int h, int s,int d,int c,int i,int ch) {
		this.hp = h;
		this.mhp = h;
		this.str = s;
		this.dex = d;
		this.con = c;
		this.itg = i;
		this.cha = ch;

	}	
	public Stats() {
		this.hp = 0;
		this.str = 0;
		this.dex = 0;
		this.con = 0;
		this.itg = 0;
		this.cha = 0;

	}
}

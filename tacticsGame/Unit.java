package tacticsGame;

public abstract class Unit {
	String name;			// Unit's name
	int lvl;				// Unit's level
	int xPos, yPos, move;	// Coordinates on the board and distance unit can move
	int atk, mag, range;	// Attack and Magic stats and basic attack range
	int hp, mp;				// Hit points and Magic points
	double evade, acc;		// Evasion and Accuracy stats
	
	public Unit(String name, int move, int atk, int hp){
		this.name = name;
		this.move = move;
		this.atk = atk;
		this.hp = hp;
		
		this.lvl = 1;
		this.mag = 0;
		this.range = 1;
		this.mp = 0;
	}
	
	public void attack(Unit other){
		double toHit = this.acc - other.evade;
		// Generate random number between 1 and 100
		if(true/*Random number < toHit*/){
			other.takeDamage(this.atk);
		}
	}
	
	public void takeDamage(int dmg){
		hp -= dmg;
	}
}

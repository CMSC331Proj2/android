package tacticsGame;

import java.awt.*;

@SuppressWarnings("unused")
public abstract class Unit {
	private String name;			// Unit's name
	private int lvl;				// Unit's level
	private int xPos, yPos, move;	// Coordinates on the board and distance unit can move
	private int atk, mag, range;	// Attack and Magic stats and basic attack range
	private int hp, mp;				// Hit points and Magic points
	private double evade, acc;		// Evasion and Accuracy stats
	private Image sprite;
	private boolean visible;
	
	public Unit(String name, int move, int atk, int hp, int x, int y){
		this.name = name;
		this.move = move;
		this.atk = atk;
		this.hp = hp;
		xPos = x;
		yPos = y;
		
		lvl = 1;
		mag = 0;
		range = 1;
		mp = 0;
		visible = true;
		sprite = Sprites.PLACEHOLDER.getSprite();
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
	
	public boolean isVisible(){
		return visible;
	}
	
	public int getX(){
    	return xPos;
    }
	
	public int getY(){
    	return yPos;
    }
	
	public void setCoords(int x, int y){
		xPos = x;
		yPos = y;
	}
	
	public Image getImage(){
		return sprite;
	}
	
	public int getMoveRange(){
		return move;
	}
	
	public String getName(){
		return name;
	}
}

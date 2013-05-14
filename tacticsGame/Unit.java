package androidGame.tacticalrpg;

import android.annotation.SuppressLint;
import java.awt.*;

@SuppressLint("DefaultLocale") @SuppressWarnings("unused")
public abstract class Unit {
	protected String name, team;		// Unit's name
	protected int lvl, sprite;			// Unit's level
	protected int xPos, yPos, move;		// Coordinates on board and distance unit can move
	protected int atk, mag, range;		// Attack and Magic stats and basic attack range
	protected int maxHP, hp, maxMP, mp;	// Hit points and Mana points
	protected boolean dead, acted, moved;
	
	public Unit(String name, int move, int atk, int hp, int x, int y){
		this.name = name;
		this.move = move;
		this.atk = atk;
		this.hp = this.maxHP = hp;
		xPos = x;
		yPos = y;
		
		lvl = 1;
		mag = 0;
		range = 1;
		mp = this.maxMP = 0;
		dead = false;
		acted = false;
		moved = false;
	}
	
	public String attack(Unit other){
		String msg;
		
		other.takeDamage(this.atk);
		msg = String.format("%s hits %s for %d damage\n", name, other.getName(), atk);
		
		if(other.isDead()){
			msg += String.format("%s has died...", other.getName());
		}
		
		return msg;
	}
	
	public void takeDamage(int dmg){
		hp -= dmg;
		if(hp <= 0){
			hp = 0;
			dead = true;

		}
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
	
	public int getMoveRange(){
		return move;
	}
	
	public int getAttackRange(){
		return range;
	}
	
	public String getName(){
		return name;
	}
	
	public int getImage(){
		return sprite;
	}
	
	public String getInfo(){
		String stats = String.format("<html>%s<br>", name);
		stats += String.format("HP: %d/%d<br>", hp, maxHP);
		stats += String.format("MP: %d/%d<br>", mp, maxMP);
		stats += String.format("Attack: %d<br>", atk);
		stats += String.format("Move: %d<br></html>", move);
		return stats;
	}
	
	public boolean isDead(){
		return dead;
	}
}

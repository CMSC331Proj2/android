package tacticsGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Space extends JButton {
	private Unit unit;
	private ImageIcon sprite = new ImageIcon();
	public boolean inRange;
	private int x, y;
	
	public Space(ActionListener al, int x, int y){
		unit = null;
		inRange = false;
		this.x = x;
		this.y = y;
		this.setPreferredSize(new Dimension(70, 70));
		this.setBackground(Color.WHITE);
		this.addActionListener(al);
	}
	
	public Space(Unit newUnit, ActionListener al, int x, int y){
		this(al, x, y);
		unit = newUnit;
		sprite.setImage(unit.getImage());
		this.setIcon(sprite);
	}
	
	public void addUnit(Unit newUnit){
		if(unit == null){
			unit = newUnit;
			sprite.setImage(unit.getImage());
			this.setIcon(sprite);
		}
	}
	
	public Unit getUnit(){
		return unit;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean isEmpty(){
		return unit == null;
	}
	
	public void clear(){
		unit = null;
		setIcon(null);
	}
}

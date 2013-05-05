package tacticsGame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BattleGrid extends JPanel {
	LinkedList<LinkedList<Space>> spaces;
	int height, width;
	
	public BattleGrid(int x, int y, ActionListener al){
		height = y;
		width = x;
		setLayout(new GridLayout(y, x));
		setMaximumSize(new Dimension(700, 700));
		spaces = new LinkedList<LinkedList<Space>>();
		for(int i = 0; i < y; i++){
			spaces.add(new LinkedList<Space>());
			for(int j = 0; j < x; j++){
				spaces.get(i).add(new Space(al, j, i));
				add(space(j, i));
			}
		}
	}
	
	public Space space(int x, int y){
		if(x < width && y < height && x >= 0 && y >= 0){
			return spaces.get(y).get(x);
		} else {
			return null;
		}
	}
	
	public Unit unitAt(int x, int y){
		return space(x, y).getUnit();
	}
	
	public void addUnit(Unit newUnit){
		space(newUnit.getX(), newUnit.getY()).addUnit(newUnit);
	}
	
	public void addUnit(Unit newUnit, int x, int y){
		space(x, y).addUnit(newUnit);
		space(newUnit.getX(), newUnit.getY()).clear();
		space(x, y).getUnit().setCoords(x, y);
	}
	
	public void showMoveRange(Unit unit){
		showRange(unit.getX(), unit.getY(), unit.getMoveRange());
	}
	
	public void showRange(int x, int y, int range){
		if(x < width && y < height && x >= 0 && y >= 0 && range >= 0){
			space(x, y).setBackground(Color.GREEN);
			space(x, y).inRange = true;
			showRange(x + 1, y, range - 1);
			showRange(x, y + 1, range - 1);
			showRange(x - 1, y, range - 1);
			showRange(x, y - 1, range - 1);
		}
	}
	
	public void moveUnit(Unit unit, int x, int y){
		if(space(x, y).inRange){
			addUnit(unit, x, y);
			resetRangeIndicator();
		}
	}
	
	public void resetRangeIndicator(){
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				space(i, j).setBackground(Color.WHITE);
				space(i, j).inRange = false;
			}
		}
	}
}

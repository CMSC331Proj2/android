package androidGame.tacticalrpg;

import java.util.*;

import android.annotation.*;
import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;

@SuppressLint("ViewConstructor")
public class BattleGrid extends GridLayout {
	ArrayList<ArrayList<View>> spaces;
	
	public BattleGrid(Context cont, int x, int y){
		super(cont);
		setColumnCount(x);
		setRowCount(y);
		spaces = new ArrayList<ArrayList<View>>();
		for(int i = 0; i < y; i++){
			spaces.add(new ArrayList<View>());
			for(int j = 0; j < x; j++){
				spaces.get(i).add(new Space(cont, j, i));
			}
		}
		
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				addView(space(j, i));
			}
		}
		
		setPadding(1, 1, 1, 1);
		setBackgroundColor(Color.BLACK);
	}
	
	public Space space(int x, int y){
		if(x < getRowCount() && y < getColumnCount() && x >= 0 && y >= 0){
			return (Space) spaces.get(y).get(x);
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
		if(x < getRowCount() && y < getColumnCount() && x >= 0 && y >= 0 && range >= 0){
			space(x, y).setBackgroundColor(Color.GREEN);
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
		for(int i = 0; i < getRowCount(); i++){
			for(int j = 0; j < getColumnCount(); j++){
				space(i, j).setBackgroundColor(Color.WHITE);
				space(i, j).inRange = false;
			}
		}
	}
}

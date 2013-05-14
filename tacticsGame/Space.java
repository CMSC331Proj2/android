package androidGame.tacticalrpg;

import android.annotation.*;
import android.content.*;
import android.graphics.*;
import android.widget.*;

@SuppressLint("ViewConstructor")
public class Space extends ImageButton {
	private Unit unit;
	private int sprite;
	public boolean inRange;
	private int xCoord, yCoord;
	
	public Space(Context cont, int x, int y){
		super(cont);
		unit = null;
		inRange = false;
		xCoord = x;
		yCoord = y;
		setBackgroundColor(Color.WHITE);
		setClickable(true);
		setBackgroundResource(R.drawable.grass);
		setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		setMinimumHeight(75);
		setMinimumWidth(75);
		setCropToPadding(true);
	}
	
	public Space(Context cont, Unit newUnit, int x, int y){
		this(cont, x, y);
		addUnit(newUnit);
	}
	
	public void addUnit(Unit newUnit){
		if(unit == null){
			unit = newUnit;
			sprite = unit.getImage();
			setImageResource(sprite);
		}
	}
	
	public Unit getUnit(){
		return unit;
	}
	
	public int getXCoord(){
		return xCoord;
	}
	
	public int getYCoord(){
		return yCoord;
	}
	
	public boolean isEmpty(){
		return unit == null;
	}
	
	public void clear(){
		unit = null;
		sprite = 0;
		setImageDrawable(null);
	}
}

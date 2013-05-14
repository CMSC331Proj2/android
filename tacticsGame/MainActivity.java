package androidGame.tacticalrpg;

import android.os.*;
import android.annotation.SuppressLint;
import android.app.*;
import android.view.*;

public class MainActivity extends Activity {

	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		BattleGrid grid = new BattleGrid(getBaseContext(), 10, 10);
		setContentView(grid);
		
		grid.addUnit(new Warrior("Conan", "Blue", 1, 3));
		grid.addUnit(new Mage("Gandalf", "Blue", 2, 1));
		grid.addUnit(new Archer("Robin Hood", "Red", 4, 6));
		grid.addUnit(new Archer("Also Robin Hood", "Red", 5, 2));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

package tacticsGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Board extends JPanel {
	private BattleGrid grid;
	private JPanel menu = new JPanel();
	//private JPanel unitInfo = new JPanel();
	private JButton attack = new JButton("Attack");
	private JButton move = new JButton("Move");
	private JButton inv = new JButton("Inventory");
	private JButton wait = new JButton("Wait");

	private Warrior conan;
	private Unit selectedUnit = null;
	
	private boolean moving, attacking;
	
    public Board(){
        setFocusable(true);
        setBackground(Color.WHITE);
		setDoubleBuffered(true);
		setSize(1000, 700);
		setLayout(new FlowLayout());
		
		add(menu);
		menu.setLayout(new GridLayout(4, 1));
		menu.add(attack);
		menu.add(move);
		menu.add(inv);
		menu.add(wait);
		attack.addActionListener(new ButtonListener());
		move.addActionListener(new ButtonListener());
		inv.addActionListener(new ButtonListener());
		wait.addActionListener(new ButtonListener());
		

		grid = new BattleGrid(10, 10, new UnitListener());
		add(grid);
		conan = new Warrior("Conan", 5, 3);
		grid.addUnit(conan);
    }
    
    private class ButtonListener implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		String actionCommand = e.getActionCommand();
    		
    		if(selectedUnit != null){
    			if(actionCommand.equals("Move")){
    				grid.showMoveRange(selectedUnit);
    				moving = true;
    			}
    		}
    	}
    }
    
    private class UnitListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			Space selectedSpace =(Space) e.getSource();
			
			if(moving){
				if(selectedSpace.isEmpty() && selectedSpace.inRange){
					grid.moveUnit(selectedUnit, selectedSpace.getX(), selectedSpace.getY());
				}
			} else {
				selectedUnit = selectedSpace.getUnit();
			}
		}
	}
}
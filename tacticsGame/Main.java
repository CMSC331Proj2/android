package tacticsGame;

import javax.swing.JFrame;

public class Main extends JFrame {

	public Main(){
		add(new Board());
        setTitle("Tactical RPG");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 280);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
	}
	
	public static void main(String[] args){
		new Main();
	}

}

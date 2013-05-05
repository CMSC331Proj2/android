package tacticsGame;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame {

	public Main(){
		add(new Board());
        setTitle("Tactical RPG");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
	}
	
	public static void main(String[] args){
		new Main();
	}

}

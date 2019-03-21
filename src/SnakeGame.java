
import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class SnakeGame extends JFrame{
	SnakeGame(){
		setTitle("SNAKE");
		setSize(Screen.getScreenWidth()+26,Screen.getScreenHeight()+48);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //
		setVisible(true);
	    Screen panel=new Screen();
		add(panel);
	}
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            JFrame frame = new SnakeGame();
	        }
	    });
	}
}

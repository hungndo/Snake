
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import javax.swing.JPanel;
@SuppressWarnings("serial")
public class Screen extends JPanel implements ActionListener{
	private static final int SCREEN_HEIGHT=500, SCREEN_WIDTH=500,CELL_LENGTH= 10;
	public static boolean gameIsStillGoingOn=true;
	private Apple apple=new Apple();
	private Snake snake=new Snake();
	Screen(){

		addKeyListener(new Keys());
		setBackground(Color.BLACK);
		//setPreferredSize(new Dimension(SCREEN_WIDTH +14,SCREEN_HEIGHT+7));
		setFocusable(true);
		initializeGame();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void initializeGame() {
		apple.summon();
		this.addKeyListener(new Keys());
		//init snake
		for(int i=1;i<10;i++) {
			snake.increaseSnakesLengthBy(1);
			snake.setSnakeX(i, snake.getSnakeX(0)-i*CELL_LENGTH);
		}
	    Timer t= new Timer(70,this);
	    t.start();
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		for(int i=snake.getTail();i>-1;i--) {
			g.fillRect(snake.getSnakeX(i), snake.getSnakeY(i), CELL_LENGTH, CELL_LENGTH);
		}
		g.setColor(Color.RED);
		g.fillRect(apple.getAppleX(), apple.getAppleY(), CELL_LENGTH, CELL_LENGTH);
	}
	public boolean snakeBitesTheApple() {
		if(snake.getSnakeX(0)==apple.getAppleX()&&snake.getSnakeY(0)==apple.getAppleY()) {
			return true;
		}
		else return false;
		
	}
	public boolean snakeKillsHimself() {
		for(int i=snake.getTail();i>3;i--)
			if(snake.getSnakeX(i)==snake.getSnakeX(0)&&snake.getSnakeY(i)==snake.getSnakeY(0)) {
				System.out.print(i);
				return true;
			}
		return false;
	}
	private class Keys extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if(Snake.getCurrentDirection()!='S')
					Snake.setCurrentDirection('N');
					break;
			case KeyEvent.VK_DOWN:
				if(Snake.getCurrentDirection()!='N')
					Snake.setCurrentDirection('S');
					break;
			case KeyEvent.VK_RIGHT:
				if(Snake.getCurrentDirection()!='W')
					Snake.setCurrentDirection('E');
					break;
			case KeyEvent.VK_LEFT:
				if(Snake.getCurrentDirection()!='E')
					Snake.setCurrentDirection('W');
					break;
			}
		}
	}
	public static int getCELL_LENGTH() {
		return CELL_LENGTH;
	}
	public static int getScreenHeight() {
		return SCREEN_HEIGHT;
	}
	public static int getScreenWidth() {
		return SCREEN_WIDTH;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(gameIsStillGoingOn) {
			repaint();
			snake.move();
			if(snakeBitesTheApple()) {
				snake.increaseSnakesLengthBy(2);
				apple.summon();
				System.out.printf(" %d  %d \n",apple.getAppleX(),apple.getAppleY());
			}
			if(snakeKillsHimself()) {
				gameIsStillGoingOn=false;
			}
		}
		else {
			//System.out.println("Jjsjsjs");
		}
	}
}

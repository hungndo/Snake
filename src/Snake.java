//import java.util.Scanner;
import java.awt.List;
import java.util.ArrayList;
public class Snake{
	private ArrayList<Integer> snakeX= new ArrayList<Integer>();
	private ArrayList<Integer> snakeY= new ArrayList<Integer>();
	private static char currentDirection;
	private int tail=0;
	private static final int HEAD=0;
	
	public int getTail() {
		return tail;
	}
	public static char getCurrentDirection() {
		return currentDirection;
	}
	public static void setCurrentDirection(char a) {
		currentDirection = a;
	}
	public int getSnakeX(int i) {
		return snakeX.get(i);
	}
	public int getSnakeY(int i) {
		return snakeY.get(i);
	}
	
	public void setSnakeX(int index,int x) {
		snakeX.set(index, x);
	}
	public void setSnakeY(int index,int x) {
		snakeY.set(index, x);
	}
	Snake(){
		currentDirection='N';
		snakeX.add(250);
		snakeY.add(250);
	}
	public void increaseSnakesLengthBy(int x ) {
		for(int i=0;i<x;i++) {
			snakeX.add(snakeX.get(tail));
			snakeY.add(snakeY.get(tail));
			tail++;
		}
	}
	public void move() {
		//moves body
		for(int i=tail;i>HEAD;i--) {
			snakeX.set(i,snakeX.get(i-1));
			snakeY.set(i,snakeY.get(i-1));
		}
		//moves head
		switch(currentDirection) {
			case 'N':
				snakeY.set(0, snakeY.get(0)-Screen.getCELL_LENGTH());
				break;
			case 'S':
				snakeY.set(0, snakeY.get(0)+Screen.getCELL_LENGTH());
				break;
			case 'W':
				snakeX.set(0, snakeX.get(0)-Screen.getCELL_LENGTH());
				break;
			case 'E':
				snakeX.set(0, snakeX.get(0)+Screen.getCELL_LENGTH());
				break;
		}

	}
}

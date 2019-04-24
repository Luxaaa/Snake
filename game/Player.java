package com.luxaaa.snake.game;

public class Player {
	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;
	static final int SPEED = 20;
	
	private int[] X;
	private int[] Y;
	private int bodySize;
	private MovingDirection direction;
	
	
	public Player(int startX, int startY, int gameW, int gameH, int bodySize) {
		this.bodySize = bodySize+1;   // +1 cause head is not part of body
		direction = MovingDirection.RIGHT;
		initPlayer(startX, startY, gameW, gameH);
	}
	
	public void move() {
		// move body (not head)
		for(int i=bodySize; i>0; i--) {
			X[i] = X[i-1];
			Y[i] = Y[i-1];
		}
		// move head
		switch (direction) {
		case UP:
				Y[0] -=SPEED;
			break;
		case DOWN:
			Y[0] +=SPEED;
			break;
		case LEFT:
			X[0] -=SPEED;
			break;
		case RIGHT:
			X[0] +=SPEED;
		break;
		default:
			break;
		}
	}
	
	
	public boolean checkDeath(int gameW, int gameH) {
		/*	Death if:
		 *	head outside Screeen
		 *	Head hits Body
		 */
		
		// check head outside screen
		if(this.X[0] < 0 || this.X[0] > gameW-WIDTH) return true;
		if(this.Y[0] < 0 || this.Y[0] > gameH-HEIGHT) return true;
		
		// check is eating body
		for(int i=bodySize; i>4; i--) {
			if(X[i] == X[0] && Y[i] == Y[0]) {
				return true;
			}
		}
		
		return false;
	}
	
	public void addBodyPart() {
		bodySize++;
	}
	
	private void initPlayer(int startX, int startY, int gameW, int gameH) {
		X =new int[(gameW*gameH) - (WIDTH*HEIGHT)];
		Y =new int[(gameW*gameH) - (WIDTH*HEIGHT)];
		
		for(int i =0; i<bodySize; i++) {
			X[i] = startX- (WIDTH*i);
			Y[i] = startY;
		}
	}
	
	
	// Getters and Setters
	public int[] getX() {
		return X;
	}
	public int[] getY() {
		return Y;
	}
	public int getBodySize() {
		return bodySize;
	}
	public void setBodySize(int size) {
		this.bodySize = size;
	}
	public MovingDirection getMovingDIrection() {
		return direction;
	}
	public void setMovingDirection(MovingDirection direction) {
		switch (direction) {
		case UP:
			if(this.direction == MovingDirection.DOWN) return;
			break;
		case DOWN:
			if(this.direction == MovingDirection.UP) return;
			break;
		case LEFT:
			if(this.direction == MovingDirection.RIGHT) return;
			break;
		case RIGHT:
			if(this.direction == MovingDirection.LEFT) return;
			break;
		
		default:
			break;
		}
		this.direction = direction;
	}
	
	
	
	
	
	public enum MovingDirection {
		UP,
		DOWN,
		LEFT,
		RIGHT;
	}
}

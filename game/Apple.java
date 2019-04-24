package com.luxaaa.snake.game;

import java.util.Random;

public class Apple {
	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;
	
	private int X;
	private int Y;
	
	
	public void spawn(int gameW, int gameH) {
		Random random =new Random();
		X = random.nextInt(gameW/WIDTH) * WIDTH;
		Y = random.nextInt(gameH/HEIGHT) * HEIGHT;
	}
	
	public boolean checkEaten(Player player) {
		if(player.getX()[0] ==X && player.getY()[0] == Y) {
			return true;
		}
		return false;
	}
	
	public int getX() {
		return X;
	}
	public int getY() {
		return Y;
	}
	
}

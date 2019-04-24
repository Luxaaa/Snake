package com.luxaaa.snake.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.luxaaa.snake.game.Player;
import com.luxaaa.snake.game.Player.MovingDirection;

public class PlayerController implements KeyListener {
	Player player;
	public  PlayerController(Player player) {
		this.player = player;
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		/*
		 *  W or UP  - UP
		 *  A or LEFT - LEFT
		 *  S or DOWN - DOWN
		 *  D or RIGHT - RIGHT
		 */
		
		
		if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
			player.setMovingDirection(MovingDirection.UP);
		} else if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
			player.setMovingDirection(MovingDirection.LEFT);
		} else if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
			player.setMovingDirection(MovingDirection.DOWN);
		} else if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
			player.setMovingDirection(MovingDirection.RIGHT);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

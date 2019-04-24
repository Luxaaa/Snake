package com.luxaaa.snake.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.luxaaa.snake.game.Apple;
import com.luxaaa.snake.game.Player;

public class GameScreen extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int STEPTIME = 200; 
	private Timer timer;
	
	
	// game elements
	Player player;
	Apple apple;
	
		
	public GameScreen() {
		setPreferredSize(new Dimension(800, 800));
		setFocusable(true);
		requestFocus();
		
		initGame();
		startGame();
		
			}
	
	private void initGame() {
		timer =new Timer(STEPTIME, this);
		player =new Player(this.getPreferredSize().width/2, this.getPreferredSize().height/2, this.getPreferredSize().width, this.getPreferredSize().height, 3);
		apple =new Apple();
		apple.spawn(this.getPreferredSize().width, this.getPreferredSize().height);
		this.addKeyListener(new PlayerController(player));
		
		
	}

	
	private void startGame() {
		timer.restart();
	}
	private void stopGame() {
		timer.stop();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(player.checkDeath(this.getPreferredSize().width, this.getPreferredSize().height)) { 
			stopGame();
			return;
		}
		
		
		player.move();
		this.repaint();
		
		// eat
			if(apple.checkEaten(player)) {
				apple.spawn(getPreferredSize().width, getPreferredSize().height);
				player.addBodyPart();
			}
				
		}
	
	public void paint(Graphics g) {
		// fill background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getPreferredSize().width, this.getPreferredSize().height);
		
		
			// draw body (not head)
			g.setColor(Color.YELLOW);
			for(int i =1; i<player.getBodySize(); i++) {
				g.fillOval(player.getX()[i], player.getY()[i], Player.WIDTH, Player.HEIGHT);
			}
			// draw head
					g.setColor(Color.RED);
					g.fillOval(player.getX()[0], player.getY()[0], Player.WIDTH, Player.HEIGHT);
		
			// draw Apple
			g.setColor(Color.CYAN);
			g.fillOval(apple.getX(), apple.getY(), Apple.WIDTH, Apple.HEIGHT);
			
			g.setColor(Color.LIGHT_GRAY);
			g.drawString("Score: "+(player.getBodySize()-4), 10, 20);
		
		}	
		
		
		
		
}

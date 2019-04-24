package com.luxaaa.snake.ui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GameScreen gameScreen;
	
	public MainFrame() {
		this.setResizable(false);
		initUI();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	private void initUI()  {
		gameScreen =new GameScreen();
		this.add(gameScreen);
	}
}

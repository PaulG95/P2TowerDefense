package TowerDefense;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame
{
	private Field field[][];
	private GamePanel gamePanel;
	
	public View(GamePanel gamePanel)
	{	
		this.gamePanel = gamePanel;				
		getContentPane().add(this.gamePanel);
		repaint();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Values.FRAME_WIDTH,Values.FRAME_HEIGHT);
		setLocation(200, 10);
		setVisible(true);
		
	}
	
	public GamePanel getGamePanel(){
		return gamePanel;
	}

}

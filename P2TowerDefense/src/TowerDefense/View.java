package TowerDefense;

import java.awt.BorderLayout;

import javax.swing.JFrame;
/**
 * This class represents the Game-Frame.
 * It contains the Game-Field
 * @see GamePanel
 * @author Bettina
 *
 */
@SuppressWarnings("serial")
public class View extends JFrame
{
	private GamePanel gamePanel;
	private SitePanel gui;
	/**
	 * The View is created with an instance of the GamePanel
	 * @param gamePanel which is responsible for painting all the components
	 */
	public View(GamePanel gamePanel, SitePanel gui)
	{	
		this.gui = gui;
		this.gamePanel = gamePanel;	
		getContentPane().add(this.gamePanel);
		repaint();
		
		add(gui, BorderLayout.EAST);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Values.FRAME_WIDTH,Values.FRAME_HEIGHT);
		setLocation(200, 10);
		setVisible(true);
		
	}
	
	/**
	 * @return The GamePanel is returned.
	 */
	public GamePanel getGamePanel(){
		return gamePanel;
	}
	
	/**
	 * @return Returns the SidePanel
	 */
	public SitePanel getGUI(){
		return gui;
	}
}

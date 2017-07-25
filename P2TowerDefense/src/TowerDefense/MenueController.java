package TowerDefense;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenueController{

	/**
	 * This class represents the Controller for the Menue.
	 * It contains all functions of the View.
	 * @see MenueView
	 * @author Vincent
	 *
	 */
	
	private static MenueView view;
	private static boolean startgame;
	private TowerDefenseMain tDm;
	
	/**
	 * Initialisierung der Main Methode
	 * zum Starten des Spiels
	 */
	public static void main(String[] args) {
		
		if(startgame = true){
		new TowerDefenseMain();
		}
	}
	
	public MenueController(MenueView view, TowerDefenseMain tDM) {
		// TODO Auto-generated constructor stub
		this.tDm = new TowerDefenseMain();
		this.view = new MenueView();
		
		/**
		 * This is the ActionListener
		 * change the boolean from startgame
		 */		
		
		
		view.startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startgame = true;
			}
		});
		
		/**
		 * This is the ActionListener
		 * to end the game
		 */		
		
		view.exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		});
		
		/**
		 * This is the ActionListener
		 * to show the ScoreList
		 */		
		
		view.scoreBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
			
	}
	
}

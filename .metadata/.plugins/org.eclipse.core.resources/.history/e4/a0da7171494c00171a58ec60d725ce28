package TowerDefense;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.Box;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SitePanel extends JFrame{

	
	private JButton t1Btn;
	private JButton t2Btn;
	private JButton t3Btn;
	private JButton t4Btn;
	
	private Color color = new Color (200,255,255);
	private Color btnColor = new Color (100,200,200);
	
	private JButton save;
	private JButton end;
	private JButton nextWave;
	
	public SitePanel(){
		
		//MainLayout
		JPanel pl = new JPanel(new GridLayout(3, 1));
		
		//TowerPanel
		JPanel towerPl = new JPanel ();
		towerPl.setBackground(color);
		
		//InfoBox
		JPanel towerInfoPl = new JPanel();
		towerInfoPl.setBackground(color);
		
		//MenuPanel
		JPanel menuPl = new JPanel();
		menuPl.setBackground(color);
		
		
/*
 * 		TOWERPANEL
 */
			
		JPanel towerGrid = new JPanel(new GridLayout(2, 2, 20, 20));
		towerGrid.setBackground(color);
		towerGrid.setPreferredSize(new Dimension(200, 200));
		
		t1Btn = new JButton("Tower 1");
		t1Btn.setBackground(btnColor);
		
		t2Btn = new JButton("Tower 2");
		t2Btn.setBackground(btnColor);
		
		t3Btn = new JButton("Tower 3");
		t3Btn.setBackground(btnColor);
		
		t4Btn = new JButton("Tower 4");
		t4Btn.setBackground(btnColor);
		
/*	
 * 		INFOPANEL
 */
		
		JPanel info = new JPanel(new GridLayout(4,1,20,20));
		info.setBackground(new Color(255,255,245));
		info.setPreferredSize(new Dimension(200, 200));
		
		JLabel cost = new JLabel ("Cost: ");
		JLabel damage = new JLabel ("Damage: ");
		JLabel range = new JLabel ("Range: ");
		JLabel frequence = new JLabel ("Shootfrequence: ");
		
		
/*
 * 		MENUPANEL
 */

		JPanel menuGrid = new JPanel(new GridLayout(3,1, 20, 20));
		menuGrid.setBackground(color);
		menuGrid.setPreferredSize(new Dimension(200, 200));
		
		nextWave = new JButton ("Next Wave");
		nextWave.setBackground(btnColor);
		
		save = new JButton ("Save");
		save.setBackground(btnColor);
		
		end = new JButton ("End");
		end.setBackground(btnColor);
		
		
		//Add Buttons to TowerPanel
		
		towerGrid.add(t1Btn);
		towerGrid.add(t2Btn);
		towerGrid.add(t3Btn);
		towerGrid.add(t4Btn);
		
		// Add Labels to InfoPanel
		
		info.add(cost);
		info.add(damage);
		info.add(range);
		info.add(frequence);
			
		// Add Buttons to Menu
		menuGrid.add(nextWave);
		menuGrid.add(save);
		menuGrid.add(end);
		
		//Add everything
		towerPl.add(towerGrid, BorderLayout.CENTER);
		menuPl.add(menuGrid, BorderLayout.CENTER);
		towerInfoPl.add(info, BorderLayout.CENTER);

		pl.add(towerPl);
		pl.add(towerInfoPl);
		pl.add(menuPl);
		
		add(pl);
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 700);
		setVisible(true);
		
	}
	
}

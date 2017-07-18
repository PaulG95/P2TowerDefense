package TowerDefense;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SitePanel extends JPanel{

	
	private JButton t1Btn;
	private JButton t2Btn;
	private JButton t3Btn;
	private JButton t4Btn;
	
	private Color color = new Color (200,255,255);
	private Color btnColor = new Color (100,200,200);
	
	private JButton save;
	private JButton end;
	private JButton nextWave;
	
	private JLabel attribut1,attribut2,attribut3,attribut4, name;
	
	public SitePanel(){
		
		setLayout(new GridLayout(3, 1));
		
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
		
		t1Btn = new JButton("Shooter");
		t1Btn.setBackground(btnColor);
		
		t2Btn = new JButton("Shotgun");
		t2Btn.setBackground(btnColor);
		
		t3Btn = new JButton("Sniper");
		t3Btn.setBackground(btnColor);
		
		t4Btn = new JButton("Tower 4");
		t4Btn.setBackground(btnColor);
		
/*	
 * 		INFOPANEL
 */
		
		JPanel info = new JPanel(new GridLayout(5,1));
		info.setBackground(new Color(255,255,245));
		info.setPreferredSize(new Dimension(200, 200));
		
		name = new JLabel();
		attribut1 = new JLabel();
		attribut2 = new JLabel();
		attribut3 = new JLabel();
		attribut4 = new JLabel();
		
		
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
		
		info.add(name);
		info.add(attribut1);
		info.add(attribut2);
		info.add(attribut3);
		info.add(attribut4);
			
		// Add Buttons to Menu
		menuGrid.add(nextWave);
		menuGrid.add(save);
		menuGrid.add(end);
		
		//Add everything
		towerPl.add(towerGrid, BorderLayout.CENTER);
		menuPl.add(menuGrid, BorderLayout.CENTER);
		towerInfoPl.add(info, BorderLayout.CENTER);

		add(towerPl);
		add(towerInfoPl);
		add(menuPl);
		
		setSize(300, Values.FRAME_HEIGHT);
		setVisible(true);
		
	}

	public JButton getT1Btn() {
		return t1Btn;
	}

	public JButton getT2Btn() {
		return t2Btn;
	}

	public JButton getT3Btn() {
		return t3Btn;
	}

	public JButton getT4Btn() {
		return t4Btn;
	}

	public JButton getSave() {
		return save;
	}

	public JButton getEnd() {
		return end;
	}

	public JButton getNextWave() {
		return nextWave;
	}

	public void setAttribut1(String attribut1) {
		this.attribut1.setText(attribut1);
	}

	public void setAttribut2(String attribut2) {
		this.attribut2.setText(attribut2);
	}

	public void setAttribut3(String attribut3) {
		this.attribut3.setText(attribut3);
	}

	public void setAttribut4(String attribut4) {
		this.attribut4.setText(attribut4);
	}

	public void setName(String name) {
		this.name.setText(name);
	}
	
	public void clearInfo(){
		this.name.setText("");
		this.attribut1.setText("");
		this.attribut2.setText("");
		this.attribut3.setText("");
		this.attribut4.setText("");
	}
	
}

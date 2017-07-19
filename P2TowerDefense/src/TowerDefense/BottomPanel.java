package TowerDefense;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * This Class shows the bottomPanel of the gui
 * It contains all the infos about the Player
 * and the current game
 * @author Bettina
 *
 */
@SuppressWarnings("serial")
public class BottomPanel extends JPanel{

	private JLabel nameLbl,scoreLbl, minLbl, sekLbl, lifeLbl;
	
	public BottomPanel()
	{
		setBackground(new Color (100,200,200));
		
		nameLbl = new JLabel();
		
		JPanel scorePnl = new JPanel();
		scorePnl.setBackground(new Color (100,200,200));
		JPanel lifePnl = new JPanel();
		lifePnl.setBackground(new Color(100,200,200));
		JPanel timePnl = new JPanel();
		timePnl.setBackground(new Color (100,200,200));
		
		JLabel scoreTextLbl = new JLabel("Score: ");
		scoreLbl = new JLabel("0");
		
		JLabel lifeTextLbl = new JLabel("Life: ");
		lifeLbl = new JLabel(String.valueOf(Values.PLAYER_LIFE));
		
		JLabel timeTextLbl = new JLabel("Time: ");
		minLbl = new JLabel("00");
		JLabel timeDots = new JLabel(":");
		sekLbl = new JLabel("00");
		
		scorePnl.add(scoreTextLbl);
		scorePnl.add(scoreLbl);
		
		lifePnl.add(lifeTextLbl);
		lifePnl.add(lifeLbl);
		
		timePnl.add(timeTextLbl);
		timePnl.add(minLbl);
		timePnl.add(timeDots);
		timePnl.add(sekLbl);
		
		add(Box.createGlue());
		add(nameLbl, BorderLayout.WEST);
		add(scorePnl);
		add(Box.createHorizontalStrut(200));
		add(lifePnl);
		add(Box.createHorizontalStrut(200));
		add(timePnl, BorderLayout.EAST);
		add(Box.createGlue());
	}
	
	public void setName(String name)
	{
		this.nameLbl.setText(name);
	}

	public void setNameLbl(String name) {
		this.nameLbl.setText(name);
	}

	public void setScoreLbl(String score) {
		this.scoreLbl.setText(score);
	}

	public void setMinLbl(String min) {
		if(min.length() == 1) min = "0"+min;
		this.minLbl.setText(min);
	}

	public void setSekLbl(String sek) {
		if(sek.length() == 1) sek = "0"+sek;
		this.sekLbl.setText(sek);
	}

	public JLabel getLifeLbl() {
		return lifeLbl;
	}

	public void setLifeLbl(int life) {
		this.lifeLbl.setText(String.valueOf(life));
	}
	
}

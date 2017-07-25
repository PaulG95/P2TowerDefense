package TowerDefense;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class MenueView extends JFrame{
	
	/**
	 * This class represents the Manue-Frame.
	 * @author Vincent
	 *
	 */
	
	JButton startBtn;
	JButton scoreBtn;
	JButton exitBtn;
	private Box menueBtns;
	
	public MenueView(){
		
		getContentPane().setBackground( Color.black );
		
		/**
		 * inintialisierung der Buttons und der Box
		 */
		
		startBtn = new JButton(new ImageIcon("../graphics/start_btn_V1.png"));
		startBtn.setAlignmentX(CENTER_ALIGNMENT);
		startBtn.setAlignmentY(TOP_ALIGNMENT);
		
		scoreBtn = new JButton(new ImageIcon("../graphics/score_btn_V1.png"));
		scoreBtn.setAlignmentX(CENTER_ALIGNMENT);
		scoreBtn.setAlignmentY(CENTER_ALIGNMENT);
		
		exitBtn =  new JButton(new ImageIcon("../graphics/end_btn_V1.png"));
		exitBtn.setAlignmentX(CENTER_ALIGNMENT);
		exitBtn.setAlignmentY(BOTTOM_ALIGNMENT);
		
		menueBtns = Box.createVerticalBox();
		
		/**
		 * hinzufügen der Buttons zur Box
		 */
		
		menueBtns.add(Box.createVerticalStrut(20));
		menueBtns.add(startBtn);
		menueBtns.add(Box.createVerticalStrut(20));
		menueBtns.add(scoreBtn);
		menueBtns.add(Box.createVerticalStrut(20));
		menueBtns.add(exitBtn);
		menueBtns.add(Box.createVerticalStrut(20));
		
		add(menueBtns, BorderLayout.CENTER);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250,300);
		setVisible(true);	
	}
	
	/**
	 * initialisierung der Getter-Methoden
	 */		
	
	public JButton getStartBtn() {
		return startBtn;
	}
	
	public JButton getScoreBtn(){
		return scoreBtn;
	}
	
	public JButton getExitBtn(){
		return exitBtn;
	}

}

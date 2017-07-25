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
	JButton instructionBtn;
	JButton exitBtn;
	private Box menueBtns;
	
	public MenueView(){
		
		getContentPane().setBackground( Color.black );
		
		startBtn = new JButton(new ImageIcon("../graphics/start_btn_V1.png"));
		startBtn.setAlignmentX(CENTER_ALIGNMENT);
		startBtn.setAlignmentY(TOP_ALIGNMENT);
		startBtn.setSize(150, 50);
		
		instructionBtn = new JButton(new ImageIcon("../graphics/instruction_btn_V1.png"));
		instructionBtn.setAlignmentX(CENTER_ALIGNMENT);
		instructionBtn.setAlignmentY(CENTER_ALIGNMENT);
		instructionBtn.setSize(150, 50);
		
		exitBtn =  new JButton(new ImageIcon("../graphics/end_btn_V1.png"));
		exitBtn.setAlignmentX(CENTER_ALIGNMENT);
		exitBtn.setAlignmentY(BOTTOM_ALIGNMENT);
		exitBtn.setSize(150, 50);
		
		menueBtns = Box.createVerticalBox();
		
		menueBtns.add(Box.createVerticalStrut(20));
		menueBtns.add(startBtn);
		menueBtns.add(Box.createVerticalStrut(20));
		menueBtns.add(instructionBtn);
		menueBtns.add(Box.createVerticalStrut(20));
		menueBtns.add(exitBtn);
		menueBtns.add(Box.createVerticalStrut(20));
		
		add(menueBtns, BorderLayout.CENTER);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250,300);
		setVisible(true);	
	}
	
	private void getStartBtn() {
		// TODO Auto-generated method stub
		
	}

}

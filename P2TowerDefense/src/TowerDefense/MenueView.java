package TowerDefenseMenue;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class MenueView extends JFrame{
	
	private JButton startBtn;
	private JButton instructionBtn;
	private JButton exitBtn;
	private Box menueBtns;
	
	public MenueView(){
		
		startBtn = new JButton(new ImageIcon("graphics/start_btn_V1.png"));
		startBtn.setAlignmentX(CENTER_ALIGNMENT);
		
		instructionBtn = new JButton(new ImageIcon("graphics/instruction_btn_V1.png"));
		instructionBtn.setAlignmentX(CENTER_ALIGNMENT);
		
		exitBtn =  new JButton(new ImageIcon("graphics/end_btn_V1.png"));
		exitBtn.setAlignmentX(CENTER_ALIGNMENT);
		
		
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
		pack();
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new MenueView();
	}
	
	private void setStartBtn() {
		// TODO Auto-generated method stub

	}
	
	private void setExitBtn() {
		// TODO Auto-generated method stub

	}
	
	private void setInstructionBtn() {
		// TODO Auto-generated method stub

	}
}

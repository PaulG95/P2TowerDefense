package TowerDefenseMenue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenueController{

	private MenueView view;
	
	
	public MenueController() {
		// TODO Auto-generated constructor stub
		this.view = new MenueView();
		
		view.startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				public static void main(String[] args) {
					new GameController();
				}
				
			}
		});
	
		
		//schlieﬂen aller Fenster
		
		view.exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		});
		
		view.instructionBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
			
		
	}
	
	private JButton getStartBtn() {
		// TODO Auto-generated method stub
		return startBtn;
	}
	
	private JButton getInstructionBtn() {
		// TODO Auto-generated method stub
		return instructionBtn;
	}
	
	public JButton getExitBtn() {
		return exitBtn;
	}
	
	
}

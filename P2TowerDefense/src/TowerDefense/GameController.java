package TowerDefense;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
/**
 * This class represents the Main Controller.
 * It initializes all the other Controller.
 * @author Bettina
 *
 */
public class GameController implements MouseMotionListener
{
	
	private View view;
	private GamePanel gamePanel;
	private Field[][] field;
	private Rectangle hoveredField, clickedField;
	private int fieldX, fieldY;
	
	ArrayList<Tower> towers;
	ArrayList<Enemy> enemys;

	private ArrayList<ArrayList<Bullet>> bullets;	//ArrayList mit den ArrayLists der Bullets	

	/**
	 * The controller is created with the View and the gamefield
	 * @param view
	 * @param field is the array of Field which built the gamefield
	 */
	public GameController(View view, Field[][] field)
	{		
		this.view = view;
		this.gamePanel = view.getGamePanel();
		this.field = field;
		
		enemys = new ArrayList<>();
		towers = new ArrayList<>();
		bullets = new ArrayList<>();
			
		EnemyController enemyController = new EnemyController(view,field,enemys);
		TowerController towerController = new TowerController(view,field,towers,enemys);
		BulletController bulletController = new BulletController(view,towers,enemys);
		
		
		view.addMouseMotionListener(this);
		view.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				super.mouseClicked(e);
				if(!field[fieldX][fieldY].isOccupied())
				{
					towerController.newTower(hoveredField.x, hoveredField.y);
					field[fieldX][fieldY].setOccupied();
				}
				else {
					System.out.println("Bereits belegt");
				}
			}
		});
	}

	@Override
	public void mouseDragged(MouseEvent e) {}

	/**
	 * Overrides the mouseMoved function.
	 * When the Mouse moves over the gameField it highlights the Field that the
	 * mouse is currently moving over
	 * @see Field
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		 
		for(int x=0; x<20; x++)
		{
			for(int y=0; y<20; y++)
			{
				if(mx > field[x][y].getXPos() && mx < field[x][y].getXPos()+Values.FIELD_SIZE
						&& my > field[x][y].getYPos() && my < field[x][y].getYPos()+Values.FIELD_SIZE)
				{
					fieldX = x;
					fieldY = y;
					hoveredField = field[x][y-1].getField();
					gamePanel.setHoveredField(hoveredField);
				}
			}
		}
		try {
			 if(mx > hoveredField.x+hoveredField.width
					 && my > hoveredField.y+hoveredField.height)
			 {
				 hoveredField = null;
				 gamePanel.setHoveredField(hoveredField);
			 }
		} catch(NullPointerException ex){}
	}
}

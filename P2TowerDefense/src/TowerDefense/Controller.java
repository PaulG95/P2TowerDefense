package TowerDefense;

import java.util.ArrayList;

import javax.swing.Timer;
/**
 * This class represents the Main Controller.
 * It initializes all the other Controller.
 * @author Bettina
 *
 */
public class Controller 
{
	
	private View view;
	private GamePanel gamePanel;
	private Field[][] field;
	
	ArrayList<Tower> towers;
	ArrayList<Enemy> enemys;

	private ArrayList<ArrayList<Bullet>> bullets;	//ArrayList mit den ArrayLists der Bullets	

	/**
	 * The controller is created with the View and the gamefield
	 * @param view
	 * @param field is the array of Field which built the gamefield
	 */
	public Controller(View view, Field[][] field)
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
		
	}

}

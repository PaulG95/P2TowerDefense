package TowerDefense;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
/**
 * This class represents the Main Controller.
 * It initializes all the other Controller.
 * @author Bettina
 *
 */
public class GameController implements MouseMotionListener
{
	
	private GamePanel gamePanel;
	private Field[][] field;
	private Rectangle hoveredField;
	private int fieldX, fieldY;
	
	private boolean setTower;
	private String newTowerType;
	
	ArrayList<Tower> towers;
	ArrayList<Enemy> enemys;

	/**
	 * The controller is created with the View and the gamefield
	 * @param view
	 * @param field is the array of Field which built the gamefield
	 */
	public GameController(View view, Field[][] field)
	{		
		this.gamePanel = view.getGamePanel();
		this.field = field;
		
		enemys = new ArrayList<>();
		towers = new ArrayList<>();
			
//		EnemyController enemyController = 
				new EnemyController(view,field,enemys);
		TowerController towerController = 
				new TowerController(view,field,towers,enemys);
//		BulletController bulletController = 
				new BulletController(view,towers,enemys);
		
		
		view.addMouseMotionListener(this);
		view.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				super.mouseClicked(e);

				if(!field[fieldX][fieldY].isOccupied() && !field[fieldX][fieldY].isPath())

				view.getGUI().clearInfo();
				/*
				 * neuen Tower platzieren
				 */
				if(setTower)

				{
					if(!field[fieldX][fieldY].isOccupied())
					{
						towerController.newTower(hoveredField.x, hoveredField.y, newTowerType);
						field[fieldX][fieldY].setOccupied(towers.get(towers.size()-1));
					}
					else {
						view.getGUI().setAttribut1("Dieses Feld ist bereits belegt");
					}
					setTower = false;
				}
				/*
				 * Info anzeigen
				 */
				else 
				{
					if(field[fieldX][fieldY].isOccupied())
					{
						if(field[fieldX][fieldY].getOccupier() instanceof Tower)
						{
							Tower tower = (Tower) field[fieldX][fieldY].getOccupier();
							view.getGUI().setName("               "+tower.getClass().getSimpleName());
							
							if(tower.getRange() >= 150) 		view.getGUI().setAttribut1("Range:          wide");
							else if(tower.getRange() >= 100)	view.getGUI().setAttribut1("Range:          medium");
							else								view.getGUI().setAttribut1("Range:          short");
							
							if(tower.getSpeed() == 1)		view.getGUI().setAttribut2("Speed:          fast");
							else if(tower.getSpeed() == 2)	view.getGUI().setAttribut2("Speed:          medium");
							else							view.getGUI().setAttribut2("Speed:          slow");
							
							view.getGUI().setAttribut3("Damage:      "+ tower.getDamage());
							view.getGUI().setAttribut4("Cost:             "+ tower.getCost());
						}
						else if(field[fieldX][fieldY].getOccupier() instanceof Enemy)
						{
							Enemy enemy = (Enemy) field[fieldX][fieldY].getOccupier();
							view.getGUI().setName("               "+enemy.getClass().getSimpleName());
							view.getGUI().setAttribut1("Hitpoints:        "+ enemy.getHitpoints());
							view.getGUI().setAttribut2("Damage:           "+ enemy.getDamage());
							view.getGUI().setAttribut3("Gold:             "+ enemy.getGold());
						}
					}
				}
			}
		});
		
		view.getGUI().getT1Btn().addActionListener(e->{
			newTowerType = "shooter";
			setTower = true;
		});
		
		view.getGUI().getT2Btn().addActionListener(e->{
			newTowerType = "shotgun";
			setTower = true;
		});
		
		view.getGUI().getT3Btn().addActionListener(e->{
			newTowerType = "sniper";
			setTower = true;
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

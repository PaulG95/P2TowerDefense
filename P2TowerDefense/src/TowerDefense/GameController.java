package TowerDefense;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.Timer;
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
	
	private int min, sek;
	private int score;
	
	private Rectangle hoveredField;
	private int fieldX, fieldY;
	
	private boolean setTower;
	private String newTowerType;
	
	ArrayList<Tower> towers;
	ArrayList<Enemy> enemys;
	
	Tower shooter,shotgun,sniper;

	/**
	 * The controller is created with the View and the gamefield
	 * @param view
	 * @param field is the array of Field which built the gamefield
	 */
	public GameController(View view, Field[][] field, Player player)
	{		
		this.view = view;
		this.gamePanel = view.getGamePanel();
		this.field = field;
		
		Timer timer = new Timer(1000, e->{
			if(sek<60) sek++;
			else 
			{
				min++;
				sek = 0;
			}
			view.getInfos().setSekLbl(String.valueOf(sek));
			view.getInfos().setMinLbl(String.valueOf(min));
		});
		timer.start();
		
		enemys = new ArrayList<>();
		towers = new ArrayList<>();
		
		shooter = new Shooter(0,19, enemys);		//Beispiel Tower für Infoausgabe
		shotgun = new Shotgun(0,19, enemys);
		sniper  = new Sniper(0,19, enemys);
			
		EnemyController enemyController = 
				new EnemyController(view,field,enemys);
		TowerController towerController = 
				new TowerController(view,field,towers,enemys);
//		BulletController bulletController = 
				new BulletController(view,towers,enemys);
		
		enemyController.setPlayer(player);
				
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
					if(!field[fieldX][fieldY].isOccupied() && !field[fieldX][fieldY].isPath())
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
							setTowerInfo(tower);
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
		
		/*
		 * TOWER BUTTONS
		 */
		view.getGUI().getT1Btn().addActionListener(e->{
			if(!setTower)
			{
				setTowerInfo(shooter);
				newTowerType = "shooter";
				setTower = true;
			} else
			{
				view.getGUI().clearInfo();
				setTower = false;
			}
			
		});
		
		view.getGUI().getT2Btn().addActionListener(e->{
			if(!setTower)
			{
				setTowerInfo(shotgun);
				newTowerType = "shotgun";
				setTower = true;
			} else
			{
				view.getGUI().clearInfo();
				setTower = false;
			}
		});
		
		view.getGUI().getT3Btn().addActionListener(e->{
			if(!setTower)
			{
				setTowerInfo(sniper);
				newTowerType = "sniper";
				setTower = true;
			} else
			{
				view.getGUI().clearInfo();
				setTower = false;
			}
		});
	}

	public void setTowerInfo(Tower tower)
	{
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
					fieldY = y-1;
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

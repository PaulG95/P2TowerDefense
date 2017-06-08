package TowerDefense;

import java.util.ArrayList;

import javax.swing.Timer;

public class Controller 
{
	
	private View view;
	private GamePanel gamePanel;
	private Field[][] field;

	Tower tower, tower1;
	Enemy enemy;
	
	ArrayList<Tower> towers;
	ArrayList<Enemy> enemys;
	ArrayList<Bullet> bullets0;						//ArrayLists mit Bullets der einzelnen T�rme
	ArrayList<Bullet> bullets1;
	
	private ArrayList<Integer> bCounter;			//ArrayList mit Countern, die die Bullets durchz�hlen
	private ArrayList<ArrayList<Bullet>> bullets;	//ArrayList mit den ArrayLists der Bullets
	private int arrayCount;							//Variable zum durchiterieren der Arraylists
	
	private Timer bTimer;
	private Timer tTimer;
	
	private int bCounter0;
	private int bCounter1;
	
	public Controller(View view, Field[][] field)
	{		
		this.view = view;
		this.gamePanel = view.getGamePanel();
		this.field = field;
		
		enemys = new ArrayList<>();
		towers = new ArrayList<>();
		bullets = new ArrayList<>();
		
		bullets0 = new ArrayList<>();
		bullets1 = new ArrayList<>();
				
		bCounter0 = 0;
		bCounter1 = 1;
		bCounter = new ArrayList<>();
		bCounter.add(bCounter0);
		bCounter.add(bCounter1);
		arrayCount = 0;
		bullets.add(bullets0);
		bullets.add(bullets1);
		
		enemy = new Enemy(field);
		tower = new Tower(7,4, field, enemys);
		tower1 = new Tower(1,11,field, enemys);
		
		towers.add(tower);
		towers.add(tower1);
		enemys.add(enemy);
				
		gamePanel.setTowers(towers);
		gamePanel.setEnemys(enemys);
		
		tTimer = new Timer(1000,e->															//TOWER-TIMER
		{
			arrayCount = 0;
			for(Tower tower: towers){														//Alle Tower in der ArrayList durchgehen 
				if(tower.checkRange())														//Kontrollieren ob Gegner in Reichweite ist
				{
					if(bullets.get(arrayCount).isEmpty())									//Wenn noch keine Bullets f�r diesen Turm existieren...
					{
						for(int i=0; i<20; i++){
							Bullet bullet = new Bullet(tower.getTarget(),tower,field);		//20 Bullets erstellen
							bullets.get(arrayCount).add(bullet);							//und dem Array hinzuf�gen
						}
						bullets.get(arrayCount).get(0).startMoving();						//1. Bullet beweglich machen
						gamePanel.setBullets(bullets.get(arrayCount));						//Bullets dem Panel hinzuf�gen
					}
					else 
					{
						if(bCounter.get(arrayCount) == 19) bCounter.set(arrayCount, 0);		//counter f�r die einzelnen Bullets bei Bedarf zuruecks.
						else bCounter.set(arrayCount, bCounter.get(arrayCount)+1);			//sonst Counter eins hochz�hlen
						bullets.get(arrayCount).get(bCounter.get(arrayCount)).setEnemy(tower.getTarget());		//Bullet den Enemy �bergeben
						bullets.get(arrayCount).get(bCounter.get(arrayCount)).startMoving();					//Bullet beweglich machen
					}
				}
				arrayCount++;																//ArrayCounter hochz�hlen
			}
		});
		
		bTimer = new Timer(20,e->{															//Bullet-Timer
			arrayCount = 0;																	
			for(int i=0; i<bullets.size(); i++)												//f�r alle Bullet-ArrayLists
			{
				for(Bullet b: bullets.get(arrayCount)){										//jede Bullet durchgehen
					if(b.isMoving())														//wenn die Bullet beweglich ist	
					{
						b.moveBullet();														//Bullet bewegen
					}
					
					if(b.getX() == enemy.getXPos() && b.getY() == enemy.getYPos())			//Wenn Bullet und Enemy kollidieren
					{
						if(enemy.getHitpoints()- b.getDamage() <= 0)						//wenn Enemy kein Leben mehr hat
						{
							enemy.killed();													//Enemy t�ten	
							b.reset();														//Bullet zur�cksetzten
						}
						else{
							enemy.setHitpoints(enemy.getHitpoints()-b.getDamage());			//wenn Enemy noch Leben hat Hitpoint aktualisieren
							b.reset();														//Bullet zur�cksetzen
						}
					}		
					gamePanel.repaint();
				}
				arrayCount++;
			}
		});
		
		Timer timer = new Timer(10,e->{
			if(enemy.getEnemy().y<700)
			{
				enemy.move();
			}
			
			gamePanel.repaint();
		});
		
		tTimer.start();
		timer.start();
		bTimer.start();
		
	}

}

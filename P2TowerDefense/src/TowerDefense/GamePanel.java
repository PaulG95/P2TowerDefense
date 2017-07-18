package TowerDefense;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * This class represents the GamePanel which is painting 
 * all the models.
 * @author Bettina
 *
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private ArrayList<Enemy> enemys;
	private ArrayList<Tower> towers;
	private ArrayList<Bullet> bullets;
	
	private Rectangle hoveredField;
	
	private BufferedImage fighter, runner, tank;
	private BufferedImage shooterBullet, shotgunBullet, sniperBullet;
	private BufferedImage shooter, shotgun, sniper;
	
	private File fighterFile, runnerFile, tankFile;
	private File shooterBulletFile, shotgunBulletFile, sniperBulletFile;
	private File shooterFile, shotgunFile, sniperFile;
	
	private Field[][] field;
	
	public GamePanel(Field[][] field)
	{
		this.field = field;
		
		fighterFile = new File("../graphics/Jet2_Enemy.png");
		runnerFile = new File("../graphics/Plane_Enemy.png");
		tankFile = new File("../graphics/Tank2_Enemy.png");
		shooterBulletFile = new File("../graphics/Blue_Shoot.png");
		shotgunBulletFile = new File("../graphics/Fire_Shoot.png");
		sniperBulletFile = new File("../graphics/Sniper_Shoot.png");
		shooterFile = new File("../graphics/Canon_Tower.png");
		shotgunFile = new File("../graphics/MG_Tower.png");
		sniperFile = new File("../graphics/Sniper_Tower.png");
		
		try {
			this.fighter = ImageIO.read(fighterFile);
			this.runner = ImageIO.read(runnerFile);
			this.tank = ImageIO.read(tankFile);
			this.shooterBullet = ImageIO.read(shooterBulletFile);
			this.shotgunBullet = ImageIO.read(shotgunBulletFile);
			this.sniperBullet = ImageIO.read(sniperBulletFile);
			this.shooter = ImageIO.read(shooterFile);
			this.shotgun = ImageIO.read(shotgunFile);
			this.sniper = ImageIO.read(sniperFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.PINK);
		for(int i=0; i<20; i++){
			for(int j=0; j<20; j++) {
				if(field[i][j].isPath()) g.drawRect(field[i][j].getXPos(),field[i][j].getYPos(),30,30);
			}
		}
		
		g.setColor(Color.RED);
		if(bullets != null)
		{	
			for(Bullet b: bullets)
			{
				if(b.getTowerType().equalsIgnoreCase("Shooter"))
				{
					g.drawImage(shooterBullet, b.getX(), b.getY(), null);
				}
				else if(b.getTowerType().equalsIgnoreCase("Shotgun"))
				{
					g.drawImage(shotgunBullet, b.getX(), b.getY(), null);
				} 
				else if(b.getTowerType().equalsIgnoreCase("Sniper"))
				{
					g.drawImage(sniperBullet, b.getX(), b.getY(), null);
				}
				else g.fillRect(b.getX(), b.getY(), b.getBullet().width, b.getBullet().height);
			}
		}	
		
		g.setColor(Color.DARK_GRAY);
		if(towers != null)
		{
			for(Tower t: towers)
			{
				if(t.getClass().getSimpleName().equalsIgnoreCase("shooter"))
				{
					g.drawImage(shooter, t.getX(), t.getY(), t.getSize(), t.getSize(), null);
				}
				else if(t.getClass().getSimpleName().equalsIgnoreCase("shotgun"))
				{
					g.drawImage(shotgun, t.getX(), t.getY(), t.getSize(), t.getSize(), null);
				}
				else if(t.getClass().getSimpleName().equalsIgnoreCase("sniper"))
				{
					g.drawImage(sniper, t.getX(), t.getY(), t.getSize(), t.getSize(), null);
				}
				else g.fillRect(t.getX(), t.getY(), t.getSize(), t.getSize());
			}
		}
		
		g.setColor(Color.BLUE);
		if(enemys != null)
		{
			
			for(Enemy e: enemys)
			{
//				g.clearRect(e.getXPos(), e.getYPos(), e.getEnemy().width, e.getEnemy().height);
				if(e.getClass().getSimpleName().equalsIgnoreCase("Runner"))
				{
					g.drawImage(runner, e.getXPos(), e.getYPos(), e.getEnemy().width, e.getEnemy().height,null);
				}
				else if(e.getClass().getSimpleName().equalsIgnoreCase("Fighter"))
				{
					g.drawImage(fighter, e.getXPos(), e.getYPos(), e.getEnemy().width, e.getEnemy().height,null);
				}
				else if(e.getClass().getSimpleName().equalsIgnoreCase("Tank"))
				{
					g.drawImage(tank, e.getXPos(), e.getYPos(), e.getEnemy().width, e.getEnemy().height,null);
				}
				else g.fillRect(e.getXPos(), e.getYPos(), e.getEnemy().width, e.getEnemy().height);
			}
		}
		
		Color hoverColor = new Color(0, 255, 255, 70);
		g.setColor(hoverColor);
		if(hoveredField != null)
		{
			g.fillRect(hoveredField.x, hoveredField.y, hoveredField.width, hoveredField.height);
		}
	}
	
	/**
	 * Sets the towers for this canvas
	 * @param towers
	 */
	public void setTowers(ArrayList<Tower> towers)
	{
		this.towers = towers;
	}
	
	/**
	 * sets the enemies for this canvas
	 * @param enemys
	 */
	public void setEnemys(ArrayList<Enemy> enemys)
	{
		this.enemys = enemys;
	}
	
	/**
	 * sets the bullets for this canvas
	 * @param bullets
	 */
	public void setBullets(ArrayList<Bullet> bullets)
	{
		this.bullets = bullets;
	}
	
	/**
	 * adds an ArrayList of bullets to the already
	 * existing list
	 * @param bullets
	 */
	public void addBullets(ArrayList<Bullet> bullets)
	{
		for(Bullet b: bullets)
		{
			this.bullets.add(b);
		}
	}	
	
	/**
	 * sets the field that is currently hovered over
	 * @param field
	 */
	public void setHoveredField(Rectangle field){
		this.hoveredField = field;
	}
}

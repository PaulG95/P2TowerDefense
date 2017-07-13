package TowerDefense;
/**
 * This class creates a gamefield out of
 * many Field and initializes all the classes
 * needed at the start of the game.
 * @author Bettina
 *
 */
public class TowerDefenseMain {

	public static void main(String[] args) 
	{
		/**
		 * Describes the gameField as a grid of Fields
		 * x: This Field's position on the x-Axis
		 * y: This Field's position on the y-Axis
		 */
		Field[][] field = new Field[Values.AMOUNT_OF_XFIELDS][Values.AMOUNT_OF_YFIELDS];

		for(int x=0; x<Values.AMOUNT_OF_XFIELDS; x++)
		{
			for(int y=0; y<Values.AMOUNT_OF_YFIELDS; y++)
			{
				field[x][y] = new Field(x*Values.FIELD_SIZE,y*Values.FIELD_SIZE);
			}
		}
		
		GamePanel gamePanel = new GamePanel(field);
		View view = new View(gamePanel);
		new GameController(view, field);
		
	}
	
}

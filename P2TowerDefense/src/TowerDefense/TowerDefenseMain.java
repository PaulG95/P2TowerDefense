package TowerDefense;

public class TowerDefenseMain {

	public static void main(String[] args) 
	{
		
		Field[][] field = new Field[20][20];

		for(int x=0; x<20; x++)
		{
			for(int y=0; y<20; y++)
			{
				field[x][y] = new Field(x*Values.FIELD_SIZE,y*Values.FIELD_SIZE);
			}
		}
		
		GamePanel gamePanel = new GamePanel(field);
		View view = new View(gamePanel);
		new Controller(view, field);
		
	}
	
}

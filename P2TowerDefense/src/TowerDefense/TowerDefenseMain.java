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
		//Setting the Enemy Path
		for (int x=0; x<3; x++){
			field[x][13].setPath(true);
		}
		for (int y=3; y<14; y++){
			field[2][y].setPath(true);
		}
		for (int x=2; x<20; x++){
			field[x][3].setPath(true);
			if(x==10){
				x = 12;
			}
		}
		for (int y=3; y<9; y++){
			field[10][y].setPath(true);
		}
		for (int x=6; x<10; x++){
			field[x][8].setPath(true);
		}
		for (int y=8; y<16; y++){
			field[6][y].setPath(true);
		}
		for (int x=6; x<17; x++){
			field[x][15].setPath(true);
		}
		for (int y=9; y<16; y++){
			field[16][y].setPath(true);
		}
		for (int x=13; x<17; x++){
			field[x][9].setPath(true);
		}
		for (int y=3; y<10; y++){
			field[13][y].setPath(true);
		}
		//nochmal über das array iterieren, mit immer den benötigten feldern
		//kevins pseudokot äria
		//field[x][y].setPath = true
//		for(int y = 0; y < 100; y++) {
//			field[2][y].setPath(true);
//			if(y == 2) {
//				y = 29;//29
//			
			//++ => 30
			//}}
		
		String testName = "Horst";
		Player player = new Player(testName);
		SitePanel gui = new SitePanel();
		BottomPanel infos = new BottomPanel();
		GamePanel gamePanel = new GamePanel(field);
		View view = new View(gamePanel, gui, infos);
		new GameController(view,field,player);
		
	}
	
}

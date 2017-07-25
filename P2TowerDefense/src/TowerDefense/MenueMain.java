package TowerDefense;

/**
 * This class creates initializes
 * all the classes of the menu
 * needed at the start of the game.
 * @author Vincent
 *
 */

public class MenueMain {

	public static void main(String[] args) {
		
		MenueView view = new MenueView();
		new MenueController(view,null);
		
	}
	
}

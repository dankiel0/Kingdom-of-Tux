package util;

public class Util {
	public static int tileSize = 32;
	
	public static STATE state = STATE.START;
	
	public enum STATE{
		MENU,
		GAME,
		INVENTORY,
		START,
		HELP
	};
	
	
	
}

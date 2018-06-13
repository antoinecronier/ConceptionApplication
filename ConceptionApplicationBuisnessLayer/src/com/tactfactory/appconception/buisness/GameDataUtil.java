package com.tactfactory.appconception.buisness;

public class GameDataUtil {
	public static final String GAME_TURN_PREFIX = "game/";
	public static final String GAME_DATA_SEPARATOR = ",";
	
	public static boolean isSocketDatasOk(String datas){
		boolean result = false;
		if (datas.startsWith(GAME_TURN_PREFIX)) {
			result = true;
		}
		return result;
	}
}

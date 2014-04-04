package cswagner.gassybird;

import com.badlogic.gdx.Game;

import cswagner.gassybird.world.WorldScreen;

public class GassyBird extends Game {
	@Override
	public void create() {
		_instance = this;
		setScreen(new WorldScreen());
	}
	
	public static void restart() {
		_instance.setScreen(new WorldScreen());
	}
	
	public static boolean debug = true;
	public static String debugMessage = "debug";
	private static GassyBird _instance;
}

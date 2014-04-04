package cswagner.gassybird.input;

import com.badlogic.gdx.Gdx;

public class InputManager {
	public static void enable() {		
		_screenClickPos = null;
		_inputHandler = new InputHandler();
		Gdx.input.setInputProcessor(_inputHandler);
	}
	
	public static void disable() {
		_screenClickPos = null;
		Gdx.input.setInputProcessor(null);
	}
	
	public static Point getScreenClickPosition() {
		if(_screenClickPos != null) {	
			// lazy reset only when querying screen click
			Point ptToReturn = new Point(_screenClickPos.getX(), _screenClickPos.getY());
			_screenClickPos = null;
			return ptToReturn;
		}
		return null;
	}	
	
	protected static void setScreenClickPosition(Point posIn) {
		_screenClickPos = posIn;
	}
	
	private static InputHandler _inputHandler;	
	private static Point _screenClickPos;
}

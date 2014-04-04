package cswagner.gassybird.input;

public class Point {
	public Point(int xIn, int yIn) {
		_x = xIn;
		_y = yIn;
	}
	
	public int getX() { return _x; }
	public int getY() { return _y; }
	
	public void set(int xIn, int yIn) {
		_x = xIn;
		_y = yIn;
	}
	public void setX(int xIn) { _x = xIn; }
	public void setY(int yIn) { _y = yIn; }
	
	private int _x,
				_y;
}

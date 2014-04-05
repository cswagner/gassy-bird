package cswagner.gassybird.world.obstacle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import cswagner.gassybird.world.World;

public class Obstacle {
	public Obstacle(World worldIn, int idIn, float horizontalPosIn) {
		_world = worldIn;
		_passedByBird = false;
		
		_id = idIn;
		_position = new Vector2(horizontalPosIn, Obstacle.getValidVerticalPosition());
		
		_controller = new ObstacleController(this);
		_renderer = new ObstacleRenderer(this);
	}
	
	public static float getValidVerticalPosition() { 
		float minPos = World.GROUND_HEIGHT + Obstacle.MIN_SECTION_HEIGHT,
			  maxPos = Gdx.graphics.getHeight() - Obstacle.MIN_SECTION_HEIGHT - Obstacle.OPENING_HEIGHT;
		return (float)(Math.random() * (maxPos - minPos) + minPos);
	}
	
	public World getWorld() { return _world; }
	public boolean wasPassedByBird() { return _passedByBird; }
	public void setPassedByBird(boolean flagIn) { _passedByBird = true; }
	public int getID() { return _id; }
	public Vector2 getPosition() { return _position; }
	public ObstacleController getController() { return _controller; }
	public ObstacleRenderer getRenderer() { return _renderer; }
	
	private World _world;
	private boolean _passedByBird;
	private int _id;
	private Vector2 _position;
	
	private ObstacleController _controller;
	private ObstacleRenderer _renderer;
		
	public static final float WIDTH = 3.0f * World.UNIT,
							  OPENING_HEIGHT = 8.0f * World.UNIT,
							  HORIZONTAL_SPEED = -World.UNIT * 0.1f,
							  MIN_SECTION_HEIGHT = 4.0f * World.UNIT,
							  SPACING = Obstacle.WIDTH + (9.0f * World.UNIT);
}

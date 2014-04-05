package cswagner.gassybird.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import cswagner.gassybird.world.bird.Bird;
import cswagner.gassybird.world.obstacle.Obstacle;

public class World {
	public World() {
		_state = State.STARTING;
		
		_bird = new Bird(this);
		_obstacle1 = new Obstacle(this, 1, World.STARTING_OBSTACLE_LEEWAY + Gdx.graphics.getWidth());
		_obstacle2 = new Obstacle(this, 2, _obstacle1.getPosition().x + Obstacle.SPACING);
		_obstacle3 = new Obstacle(this, 3, _obstacle2.getPosition().x + Obstacle.SPACING);
		
		_controller = new WorldController(this);
		_renderer = new WorldRenderer(this);
	}
	
	public State getState() { return _state; }
	public void setState(State stateIn) { _state = stateIn; }
	public Bird getBird() { return _bird; }
	public Obstacle getObstacle(int whichOne) {
		if(whichOne == 1) return _obstacle1;
		if(whichOne == 2) return _obstacle2;
		if(whichOne == 3) return _obstacle3;
		return null;
	}	
	public WorldController getController() { return _controller; }
	public WorldRenderer getRenderer() { return _renderer; }
	
	public static final float UNIT = (Gdx.graphics.getHeight() < Gdx.graphics.getWidth()) ? 
									 (Gdx.graphics.getHeight()/ 20.0f) :
									 (Gdx.graphics.getWidth() / 20.0f);
	public static final float GROUND_HEIGHT = 5.0f * World.UNIT;
	public static final float STARTING_OBSTACLE_LEEWAY = 10.0f * World.UNIT;
	
	public enum State {
		STARTING,          // waiting for user to tap to start
		RUNNING,           // normal game-play
		FINISHING,         // user has hit an obstacle and no more input should be taken
		FINISHED           // user has hit the ground
	}
	private State _state;	
	private Bird _bird;
	private Obstacle _obstacle1,
					 _obstacle2,
					 _obstacle3;	
	private WorldController _controller;
	private WorldRenderer _renderer;
}

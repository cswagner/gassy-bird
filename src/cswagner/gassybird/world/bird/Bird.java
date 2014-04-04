package cswagner.gassybird.world.bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import cswagner.gassybird.world.World;

public class Bird {
	public Bird(World worldIn) {
		_world = worldIn;
		
		_position = new Vector2(Bird.STARTING_POSX, Bird.STARTING_POSY);
		_velocity = new Vector2(Bird.HORIZONTAL_VELOCITY, 0.0f);			
		_radius = World.UNIT;		
		
		_controller = new BirdController(this);
		_renderer = new BirdRenderer(this);
	}
	
	public World getWorld() { return _world; }
	public Vector2 getPosition() { return _position; }
	public Vector2 getVelocity() { return _velocity; }	
	public float getRadius() { return _radius; }	
	public BirdController getController() { return _controller; }
	public BirdRenderer getRenderer() { return _renderer; }
	
	private World _world;
	private Vector2 _position,
					_velocity;					
	private float _radius;				  
	
	private BirdController _controller;
	private BirdRenderer _renderer;
	
	protected static final float TERMINAL_VELOCITY = -World.UNIT, 	
								 GRAVITY_FORCE = -World.UNIT * 0.03f,
								 GAS_FORCE = World.UNIT * 0.5f,
								 STARTING_POSX = Gdx.graphics.getWidth() * 0.33f,
								 STARTING_POSY = Gdx.graphics.getHeight() * 0.5f,
								 HORIZONTAL_VELOCITY = World.UNIT * 0.5f;
}

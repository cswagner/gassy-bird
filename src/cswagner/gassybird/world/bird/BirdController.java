package cswagner.gassybird.world.bird;

import cswagner.gassybird.input.Point;
import cswagner.gassybird.world.World;
import cswagner.gassybird.world.obstacle.Obstacle;

public class BirdController {
	public BirdController(Bird birdIn) {
		_bird = birdIn;
	}
	
	public void update(float delta) {					
		if(_bird.getVelocity().y > Bird.TERMINAL_VELOCITY) {
			_bird.getVelocity().y += Bird.GRAVITY_FORCE;
		}
	
		// resolve position
		_bird.getPosition().y += _bird.getVelocity().y;		
		
		// world boundary collision handling
		if(_bird.getPosition().y - _bird.getRadius() < World.GROUND_HEIGHT) {
			_bird.getPosition().y = World.GROUND_HEIGHT + _bird.getRadius();
			_bird.getWorld().setState(World.State.FINISHED);			
		}
		
		// obstacle collision handling
		if(_bird.getWorld().getState().equals(World.State.RUNNING)) {
			boolean collidedWithObstacle = false;				
			collidedWithObstacle = checkCollision(_bird.getWorld().getObstacle(1));
			if(!collidedWithObstacle) collidedWithObstacle = checkCollision(_bird.getWorld().getObstacle(2));
			if(!collidedWithObstacle) collidedWithObstacle = checkCollision(_bird.getWorld().getObstacle(3));
			if(collidedWithObstacle) _bird.getWorld().setState(World.State.FINISHING);	
		}
	}
	
	public void onScreenClick(Point screenClickPos) {				
		_bird.getVelocity().y = Bird.GAS_FORCE;
	}
	
	private boolean checkCollision(Obstacle obstacle) {
		float birdFront = _bird.getPosition().x + _bird.getRadius(),
			  birdWidth = 2.0f * _bird.getRadius();
		float obstacleFront = obstacle.getPosition().x + Obstacle.WIDTH;
		boolean collidingInX = (birdFront >= obstacle.getPosition().x) && (birdFront <= (obstacleFront + birdWidth));
		
		if(collidingInX) {
			float birdTop = _bird.getPosition().y + _bird.getRadius(),
				  birdBottom = _bird.getPosition().y - _bird.getRadius();
			boolean collidingInY = (birdTop >= (obstacle.getPosition().y + Obstacle.OPENING_HEIGHT)) || (birdBottom <= obstacle.getPosition().y);
			if(collidingInY) return true;
		}
		return false;
	}
	
	private Bird _bird;
}

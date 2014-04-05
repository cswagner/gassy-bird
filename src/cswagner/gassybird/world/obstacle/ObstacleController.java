package cswagner.gassybird.world.obstacle;


public class ObstacleController {
	public ObstacleController(Obstacle obstacleIn) {
		_obstacle = obstacleIn;
	}
	
	public void update(float delta) {
		_obstacle.getPosition().x += Obstacle.HORIZONTAL_SPEED;
		if(_obstacle.getPosition().x + Obstacle.WIDTH < 0) {
			Obstacle toFollow = null;
			if(_obstacle.getID() == 1) toFollow = _obstacle.getWorld().getObstacle(3);
			if(_obstacle.getID() == 2) toFollow = _obstacle.getWorld().getObstacle(1);
			if(_obstacle.getID() == 3) toFollow = _obstacle.getWorld().getObstacle(2);
			_obstacle.getPosition().x = toFollow.getPosition().x + Obstacle.SPACING;
			_obstacle.getPosition().y = Obstacle.getValidVerticalPosition();
			_obstacle.setPassedByBird(false);
		}
		
		// check if bird made it far enough through this obstacle to count towards score
		if(!_obstacle.wasPassedByBird() && 
		   (_obstacle.getPosition().x + (Obstacle.WIDTH * 0.5f)) <= _obstacle.getWorld().getBird().getPosition().x) {
			_obstacle.setPassedByBird(true);
			_obstacle.getWorld().getBird().passObstacle();
		}
	}
	
	private Obstacle _obstacle;
}

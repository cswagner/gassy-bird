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
		}
	}
	
	private Obstacle _obstacle;
}

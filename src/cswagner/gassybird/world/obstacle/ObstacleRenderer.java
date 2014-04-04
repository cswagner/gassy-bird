package cswagner.gassybird.world.obstacle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import cswagner.gassybird.world.World;

public class ObstacleRenderer {
	public ObstacleRenderer(Obstacle obstacleIn) {
		_obstacle = obstacleIn;
	}
	
	public void render(float delta, OrthographicCamera staticCamera, OrthographicCamera dynamicCamera, SpriteBatch artist) {
		
	}
	
	public void renderDebug(float delta, OrthographicCamera staticCamera, OrthographicCamera dynamicCamera, ShapeRenderer artist) {
		artist.identity();
		if(_obstacle.getID() == 1) artist.setColor(1.0f, 0.0f, 0.0f, 1.0f);
		if(_obstacle.getID() == 2) artist.setColor(1.0f, 1.0f, 0.0f, 1.0f);
		if(_obstacle.getID() == 3) artist.setColor(0.0f, 1.0f, 1.0f, 1.0f);
		artist.translate(_obstacle.getPosition().x, World.GROUND_HEIGHT, 0.0f);
		artist.rect(0.0f, 0.0f, Obstacle.WIDTH, _obstacle.getPosition().y - World.GROUND_HEIGHT);
		artist.translate(0.0f, _obstacle.getPosition().y + Obstacle.OPENING_HEIGHT - World.GROUND_HEIGHT, 0.0f);
		artist.rect(0.0f, 0.0f, Obstacle.WIDTH, Gdx.graphics.getHeight() - _obstacle.getPosition().y - Obstacle.OPENING_HEIGHT);
	}
	
	private Obstacle _obstacle;
}

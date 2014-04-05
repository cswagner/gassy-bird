package cswagner.gassybird.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class WorldRenderer {
	public WorldRenderer(World worldIn) {
		_world = worldIn;
	}
	
	public void render(float delta, OrthographicCamera staticCamera, OrthographicCamera dynamicCamera, SpriteBatch artist) {
		
	}
	
	public void renderDebug(float delta, OrthographicCamera staticCamera, OrthographicCamera dynamicCamera, ShapeRenderer artist) {
		// draws a faint grid for each visible tile		
		artist.identity();		
		artist.setColor(0.0f, 0.0f, 0.25f, 1.0f);				
		for(int row = 0; row < (Gdx.graphics.getHeight() / World.UNIT); ++row) {
			for(int col = 0; col < (Gdx.graphics.getWidth() / World.UNIT); ++col) {
				artist.rect(col * World.UNIT, row * World.UNIT, World.UNIT, World.UNIT);
			}
		}
		
		_world.getObstacle(1).getRenderer().renderDebug(delta, staticCamera, dynamicCamera, artist);
		_world.getObstacle(2).getRenderer().renderDebug(delta, staticCamera, dynamicCamera, artist);
		_world.getObstacle(3).getRenderer().renderDebug(delta, staticCamera, dynamicCamera, artist);
		_world.getBird().getRenderer().renderDebug(delta, staticCamera, dynamicCamera, artist);
		
		// draw ground
		artist.identity();
		artist.setColor(0.0f, 1.0f, 0.0f, 1.0f);
		artist.rect(0.0f, 0.0f, Gdx.graphics.getWidth(), World.GROUND_HEIGHT);	
	}
	
	private World _world;
}

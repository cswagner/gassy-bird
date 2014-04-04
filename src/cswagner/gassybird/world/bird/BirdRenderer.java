package cswagner.gassybird.world.bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BirdRenderer {
	public BirdRenderer(Bird birdIn) {
		_bird = birdIn;
	}
	
	public void render(float delta, OrthographicCamera staticCamera, OrthographicCamera dynamicCamera, SpriteBatch artist) {		
		
	}
	
	public void renderDebug(float delta, OrthographicCamera staticCamera, OrthographicCamera dynamicCamera, ShapeRenderer artist) {
		// draw a white circle
		artist.identity();
		artist.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		Gdx.gl.glLineWidth(5.0f);
		artist.translate(_bird.getPosition().x, _bird.getPosition().y, 0.0f);
		artist.rotate(0.0f, 0.0f, 1.0f, _bird.getVelocity().angle());		
		artist.circle(0.0f, 0.0f, _bird.getRadius(), 36);
		artist.line(0.0f, 0.0f, _bird.getRadius(), 0.0f);		
	}
	
	private Bird _bird;
}

package cswagner.gassybird.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import cswagner.gassybird.GassyBird;
import cswagner.gassybird.input.InputManager;

public class WorldScreen implements Screen {
	public WorldScreen() {
		_world = new World();
		_artist = new SpriteBatch();
		_debugArtist = new ShapeRenderer();
		
		_debugText = new BitmapFont();
		_debugText.scale(2.0f);
		
		InputManager.enable();
		
		initCamera();
	}
	
	@Override
	public void render(float delta) {
		// clear screen
		Gdx.gl.glClearColor(0.0f, 0.0f, 1.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// update world
		_world.getController().update(delta);
		
		// render world
		_artist.begin();
			if(GassyBird.debug) _debugText.draw(_artist, GassyBird.debugMessage, 0.0f, Gdx.graphics.getHeight() - World.UNIT);
			_world.getRenderer().render(delta, _staticCamera, _dynamicCamera, _artist);
		_artist.end();
		if(GassyBird.debug) {
			_debugArtist.begin(ShapeType.Line);
				_world.getRenderer().renderDebug(delta, _staticCamera, _dynamicCamera, _debugArtist);
			_debugArtist.end();
		}
	}
	
	@Override
	public void show() {
		InputManager.enable();
	}
	
	@Override
	public void hide() {
		InputManager.disable();
	}
	
	@Override
	public void pause() {
		InputManager.disable();		
	}
	
	@Override
	public void resume() {
		InputManager.enable();
	}
	
	@Override
	public void dispose() {
		InputManager.disable();
		
		_artist.dispose();
		_debugArtist.dispose();	
	}
	
	@Override
	public void resize(int width, int height) {}
	
	private void initCamera() {
		_staticCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());		
		_staticCamera.position.set(Gdx.graphics.getWidth() / 2.0f, Gdx.graphics.getHeight() / 2.0f, 0.0f);
		_staticCamera.update();
		
		_dynamicCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());		
		_dynamicCamera.position.set(Gdx.graphics.getWidth() / 2.0f, Gdx.graphics.getHeight() / 2.0f, 0.0f);
		_dynamicCamera.update();
	}
	
	private World _world;	// reference to the game world
	
	private OrthographicCamera _staticCamera,	// static camera; good for UI or static elements
	   						   _dynamicCamera;	// dynamic camera; can move around scene
	
	private SpriteBatch _artist;				// normal batch renderer (textures)
	private ShapeRenderer _debugArtist;			// debug batch renderer (wireframes)
	private BitmapFont _debugText;				// debug message rendering
}

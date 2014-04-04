package cswagner.gassybird.world;

import cswagner.gassybird.GassyBird;
import cswagner.gassybird.input.InputManager;
import cswagner.gassybird.input.Point;

public class WorldController {
	static int i = 0;
	public WorldController(World worldIn) {
		_world = worldIn;
	}
	
	public void update(float delta) {
		GassyBird.debugMessage = _world.getState().toString();
		// check if the screen was pressed
		Point screenClickPos = InputManager.getScreenClickPosition();
		if(screenClickPos != null) {
			if(_world.getState().equals(World.State.STARTING)) {
				_world.setState(World.State.RUNNING);	
				_world.getBird().getController().onScreenClick(screenClickPos);
			}else if(_world.getState().equals(World.State.RUNNING)) {
				_world.getBird().getController().onScreenClick(screenClickPos);
			}else if(_world.getState().equals(World.State.FINISHED)) {
				GassyBird.restart();
			}
		}
		
		// update game objects
		if(_world.getState().equals(World.State.RUNNING)) {
			_world.getObstacle(1).getController().update(delta);
			_world.getObstacle(2).getController().update(delta);			
			_world.getObstacle(3).getController().update(delta);
		}
		if(!_world.getState().equals(World.State.STARTING) && !_world.getState().equals(World.State.FINISHED)) {
			_world.getBird().getController().update(delta);
		}
	}
	
	private World _world;
}

package jcheng.gems.screens;

import jcheng.gems.GemCatcher;
import jcheng.gems.entities.DebugRectangle;
import jcheng.gems.entities.GemSpout;
import jcheng.gems.entities.Player;
import jcheng.gems.utils.DragActor;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PlayScreen extends AbstractScreen {
	
	private final Player player;
	private final GemSpout gemSpout;

	public PlayScreen(GemCatcher game) {
		super(game, new PlayStage(GAME_VIEWPORT_WIDTH, GAME_VIEWPORT_HEIGHT));
		player = new Player(this);
		player.setPosition(0, 0);
		gemSpout = new GemSpout(this, player);
		stage.addActor(gemSpout);
		stage.addActor(player);
		stage.addListener(new DragActor(player));
	}

	@Override
	public void dispose() {
		GemCatcher.log("PlayScreen.dispose()");
		super.dispose();
	}
	
	
	public static class PlayStage extends Stage {
		
		private static final int DEBUG_KEYCODE = Input.Keys.D;
		
		public PlayStage(int width, int height) {
			super();
			this.setViewport(width, height, true);
		}
		
		@Override
		public boolean keyDown(int keyCode) {
			if (DEBUG_KEYCODE == keyCode) DebugRectangle.debug = true;
			return true;
		}
		
		@Override
		public boolean keyUp(int keyCode) {
			if (DEBUG_KEYCODE == keyCode) DebugRectangle.debug = false;
			return true;
		}		
	}
	
}

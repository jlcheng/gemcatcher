package jcheng.gems;

import jcheng.gems.screens.PlayScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class GemCatcher extends Game {
	
	public static void log(String msg) {
		Gdx.app.log("GemCatcher", msg);
	}
		
	@Override
	public void create() {		
        setScreen( new PlayScreen( this ) );
	}


}

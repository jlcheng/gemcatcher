package jcheng.gems;

import jcheng.gems.screens.PlayScreen;

import com.badlogic.gdx.Game;

public class GemCatcher extends Game {
	
	public static final String LOG = "GemCatcher";
		
	@Override
	public void create() {		
        setScreen( new PlayScreen( this ) );
	}


}

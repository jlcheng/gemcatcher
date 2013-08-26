package jcheng.gems.screens;

import jcheng.gems.GemCatcher;
import jcheng.gems.entities.GemSpout;
import jcheng.gems.entities.Player;

public class PlayScreen extends AbstractScreen {
	
	public static float MIN_Y = 70; 
	private final Player player;
	private final GemSpout gemSpout;

	public PlayScreen(GemCatcher game) {
		super(game);
		player = new Player(this);
		player.setPosition(0, MIN_Y);
		gemSpout = new GemSpout(this, player);
		stage.addActor(gemSpout);
		stage.addActor(player);
	}


}

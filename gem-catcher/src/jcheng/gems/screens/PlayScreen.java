package jcheng.gems.screens;

import jcheng.gems.GemCatcher;
import jcheng.gems.entities.GemSpout;
import jcheng.gems.entities.Player;
import jcheng.gems.utils.DragActor;

public class PlayScreen extends AbstractScreen {
	
	private final Player player;
	private final GemSpout gemSpout;

	public PlayScreen(GemCatcher game) {
		super(game);
		player = new Player(this);
		player.setPosition(0, 0);
		gemSpout = new GemSpout(this, player);
		stage.addActor(gemSpout);
		stage.addActor(player);
		stage.addListener(new DragActor(player));
	}

}

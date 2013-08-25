package jcheng.gems.screens;

import jcheng.gems.GemCatcher;
import jcheng.gems.entities.GemSpout;
import jcheng.gems.entities.Player;
import jcheng.gems.utils.Draggable;

public class PlayScreen extends AbstractScreen {
	
	private final Player player;
	private final GemSpout gemSpout;

	public PlayScreen(GemCatcher game) {
		super(game);
		player = new Player(this);
		player.addListener(new Draggable(player));
		gemSpout = new GemSpout(this, player);
		stage.addActor(gemSpout);
		stage.addActor(player);
	}


}

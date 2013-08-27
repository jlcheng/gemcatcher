package jcheng.gems.entities;

import jcheng.gems.entities.Gem.GemColor;
import jcheng.gems.screens.AbstractScreen;

import com.badlogic.gdx.scenes.scene2d.Group;

import static com.badlogic.gdx.math.MathUtils.random;
/**
 * Spawns gems from the top of the screen.
 * 
 * @author jcheng
 *
 */
public class GemSpout

//
// Not all entities in the game are visible 'things'. This one is an algorithm that randomly
// drops Gems from the sky.
//
extends Group {
	
	private final AbstractScreen screen;
	private float countDown = 0;
	private final Player player;
	private final int gemsMax = 6;
	private final int gemsCount = 0;

	public GemSpout(AbstractScreen screen, Player player) {
		super();
		this.screen = screen;
		this.player = player;
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		countDown -= delta;
		if (countDown > 0f) return;
		
		countDown = 1 + random(1f);
		if (gemsCount < gemsMax) {
			Gem g = new Gem(randomEnum(GemColor.class) , screen.getAtlas(), player);
			g.setX(random(getStage().getWidth()-g.getWidth()));
			g.setY(getStage().getHeight());
			addActor(g);				
		}
	}
	
	private static <T extends Enum<T>> T randomEnum(Class<T> enumClass) {
		T[] values = enumClass.getEnumConstants();
		return values[random(values.length-1)];
	}
}

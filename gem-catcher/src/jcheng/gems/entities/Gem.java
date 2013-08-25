package jcheng.gems.entities;

import jcheng.gems.utils.ConstantFall;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * A gem falls from the top of the screen. It is removed from the game when
 * it hits bottom or hits the player. If it hits the player, the players
 * increments its count of gems.
 * 
 * @author jcheng
 *
 */
public class Gem extends Image {
	
	public static enum GemColor {
		Blue,
		Green,
		Orange;
	}
	
	private final Player player;
	private final Rectangle rectangle = new Rectangle();
	private final GemColor gemColor;
	
	public Gem(GemColor gemColor, TextureAtlas atlas, Player player) {
		super(atlas.findRegion("Gem " + gemColor.name()));
		this.gemColor = gemColor;
		this.player = player;
		rectangle.setSize(getWidth(), getHeight());
		this.scale(-0.5f);
		
		//
		// Some behaviors can be reused and coded as an 'Action'.
		// 
		addAction(new ConstantFall()); 
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		
		//
		// Some behaviors is best left implemented as part of the entity itself.
		// 
		rectangle.setPosition(getX(), getY());
		if (getY() < 1) {
			remove();
		}
		if (Intersector.overlaps(rectangle, player.getRectangle())) {
			player.increment(this);
			remove();
		}
	}
	
	public GemColor getGemColor() {
		return gemColor;
	}

}

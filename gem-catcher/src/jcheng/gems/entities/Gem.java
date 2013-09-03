package jcheng.gems.entities;

import jcheng.gems.utils.ConstantFall;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
	private final DebugRectangle rectImage;
	
	public Gem(GemColor gemColor, TextureAtlas atlas, Player player, DebugRectangle rectImage) {
		super(atlas.findRegion("Gem " + gemColor.name()));
		this.gemColor = gemColor;
		this.player = player;
		this.setWidth(this.getWidth()*0.5f);
		this.setHeight(this.getHeight()*0.5f);
		rectangle.setSize(getWidth(), getHeight());
		this.rectImage = rectImage;
		
		//
		// Some behaviors can be reused and coded as an 'Action'.
		// 
		addAction(new ConstantFall()); 
	}
	
	@Override
    public void draw(SpriteBatch batch, float parentAlpha) {
		rectImage.drawAround(batch, parentAlpha, this);
		super.draw(batch, parentAlpha);
	}	
	
	@Override
	public void act(float delta) {
		super.act(delta);
		
		//
		// Some behaviors is best left implemented as part of the entity itself.
		// 
		rectangle.setPosition(getX(), getY());
		if (getY() <= 0f) {
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

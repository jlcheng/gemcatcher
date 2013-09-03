package jcheng.gems.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Draws a rectangle using Spritebatch API.
 * 
 * @author jcheng
 *
 */
public class RectImage extends Image {
	
	public RectImage(TextureAtlas atlas) {
		super(atlas.findRegion("1x1"));
	}
	
	/**
	 * Draws a rectangle with the given position and size. 
	 * 
	 * @param batch
	 * @param parentAlpha
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawRect(SpriteBatch batch, float parentAlpha, float x, float y, float width, float height) {
		this.setPosition(x, y);
		this.setSize(width, height);
		this.draw(batch, parentAlpha);
	}

	/**
	 * Draws a rectangle around the given actor.
	 * 
	 * @param batch
	 * @param parentAlpha
	 * @param actor
	 */
	public void drawAround(SpriteBatch batch, float parentAlpha, Actor actor) {
		drawRect(batch, parentAlpha, actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight());
	}	
}

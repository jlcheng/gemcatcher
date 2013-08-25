package jcheng.gems.entities;

import jcheng.gems.entities.Gem.GemColor;
import jcheng.gems.screens.AbstractScreen;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * The Player can only move horizontally on the bottom of the screen. 
 * 
 * @author jcheng
 *
 */
public class Player extends Image {

	private final Rectangle rectangle = new Rectangle();
	private final BitmapFont font;
	private int blueGems = 0;
	private int greenGems = 0;
	private int orangeGems = 0;
	
	public Player(AbstractScreen screen) {
		super(screen.getAtlas().findRegion("Character Cat Girl"));
		this.font = screen.getFont();
		rectangle.setSize(getWidth(), getHeight());
	}
	
    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
    	super.draw(batch, parentAlpha);
    	Stage stage = getStage(); if (stage == null) return;
    	
    	float height = stage.getHeight() - 10;
        font.draw(batch, "Blue: " + blueGems, 5, height);
        font.draw(batch, "Green: " + greenGems, 5, (height -= font.getLineHeight()));
        font.draw(batch, "Orange: " + orangeGems, 5, (height -= font.getLineHeight()));
    }
    	
	public void increment(Gem gem) {
		GemColor gemColor = gem.getGemColor();
		if (gemColor == GemColor.Blue) blueGems++;
		if (gemColor == GemColor.Green) greenGems++;
		if (gemColor == GemColor.Orange) orangeGems++;
	}
	
	public Rectangle getRectangle() {
		rectangle.x = this.getX(); 
		rectangle.y = this.getY();
		return rectangle;
	}

}

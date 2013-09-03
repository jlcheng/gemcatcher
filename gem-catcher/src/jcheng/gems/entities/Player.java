package jcheng.gems.entities;

import jcheng.gems.entities.Gem.GemColor;
import jcheng.gems.screens.AbstractScreen;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * The Player can only move horizontally on the bottom of the screen. 
 * 
 * @author jcheng
 *
 */
public class Player extends Group {

	private final Image girl;
	private final Rectangle rectangle = new Rectangle();
	private final BitmapFont font;
	private int blueGems = 0;
	private int greenGems = 0;
	private int orangeGems = 0;
	private DebugRectangle rectImage;
	
	public Player(AbstractScreen screen) {
		super();
		TextureAtlas atlas = screen.getAtlas();
		this.girl = new Image(atlas.findRegion("Character Cat Girl"));
		this.font = screen.getFont();
		rectangle.setSize(girl.getWidth(), girl.getHeight());
		addActor(girl);
		this.rectImage = new DebugRectangle(atlas);
		
	}

	// Use our custom drawing algorithm
    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
    	rectImage.drawAround(batch, parentAlpha, girl);
    	// super.draw will take care of drawing girl object    	
    	super.draw(batch, parentAlpha);
    	Stage stage = getStage(); if (stage == null) return;
    	    	    	
    	// Draw scores
    	float height = stage.getHeight() - 10;
        font.draw(batch, "Blue: " + blueGems, 5, height);
        font.draw(batch, "Green: " + greenGems, 5, (height -= font.getLineHeight()));
        font.draw(batch, "Orange: " + orangeGems, 5, (height -= font.getLineHeight()));
    }
    
    @Override
    public void setPosition(float x, float y) {
    	girl.setPosition(x, y);
    }

    @Override
    public void setX(float x) {
    	girl.setX(x);
    }
    
    @Override
    public float getX() {
    	return girl.getX();
    }
    
    @Override
    public float getY(){
    	return girl.getY();
    }
    
    @Override
    public float getWidth() {
    	return girl.getWidth();
    }
    
    @Override
    public float getHeight() {
    	return girl.getHeight();
    }
    
	public void increment(Gem gem) {
		GemColor gemColor = gem.getGemColor();
		if (gemColor == GemColor.Blue) blueGems++;
		if (gemColor == GemColor.Green) greenGems++;
		if (gemColor == GemColor.Orange) orangeGems++;
	}
	
	public Rectangle getRectangle() {
		rectangle.x = girl.getX();
		rectangle.y = girl.getY();
		return rectangle;
	}

}

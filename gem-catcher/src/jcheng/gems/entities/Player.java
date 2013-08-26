package jcheng.gems.entities;

import jcheng.gems.entities.Gem.GemColor;
import jcheng.gems.screens.AbstractScreen;
import jcheng.gems.utils.Draggable;

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
	private final Image dropbox;
	private final Rectangle rectangle = new Rectangle();
	private final BitmapFont font;
	private int blueGems = 0;
	private int greenGems = 0;
	private int orangeGems = 0;
	
	public Player(AbstractScreen screen) {
		super();
		TextureAtlas atlas = screen.getAtlas();
		this.girl = new Image(atlas.findRegion("Character Cat Girl"));
		this.dropbox = new Image(screen.getAtlas().findRegion("dropbox"));
		this.font = screen.getFont();
		rectangle.setSize(girl.getWidth(), girl.getHeight());
		
		this.dropbox.addListener(new Draggable(girl));
		addActor(girl);
		addActor(dropbox);
	}
	
    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
    	// Use our custom drawing algorithm
    	Stage stage = getStage(); if (stage == null) return;
    	
    	// Draw girl normally
    	girl.draw(batch, parentAlpha);
    	
    	
    	// Dropbox always drawn below the girl
    	float centerX = girl.getX() + (girl.getWidth()/2f);
    	dropbox.setPosition((centerX - (dropbox.getWidth()/2f)), girl.getY() - dropbox.getHeight());
    	dropbox.draw(batch, parentAlpha);
    	
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

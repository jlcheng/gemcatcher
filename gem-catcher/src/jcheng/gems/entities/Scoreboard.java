package jcheng.gems.entities;

import jcheng.gems.screens.AbstractScreen;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Renders current score 
 * 
 * @author jcheng
 *
 */
public class Scoreboard extends Group {

	private Player player;
	private final BitmapFont font;
	
	public Scoreboard(AbstractScreen screen, Player player) {
		this.font = screen.getFont();
		this.player = player;
	}

	// Use our custom drawing algorithm
    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
    	Stage stage = getStage(); if (stage == null) return;
    	
    	// Draw scores
    	float height = stage.getHeight() - 10;
        font.draw(batch, "Blue: " + player.getBlueGems(), 5, height);
        font.draw(batch, "Green: " + player.getBlueGems(), 5, (height -= font.getLineHeight()));
        font.draw(batch, "Orange: " + player.getOrangeGems(), 5, (height -= font.getLineHeight()));
    }
    
}

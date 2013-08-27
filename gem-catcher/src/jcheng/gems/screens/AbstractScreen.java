package jcheng.gems.screens;

import jcheng.gems.GemCatcher;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * The base class for all game screens.
 */
public abstract class AbstractScreen
    implements
        Screen
{
    public static final int GAME_VIEWPORT_WIDTH = 360, GAME_VIEWPORT_HEIGHT = 640;

    protected final GemCatcher game;
    protected final Stage stage;

    private BitmapFont font;
    private SpriteBatch batch;
    private TextureAtlas atlas;

    public AbstractScreen(
    		GemCatcher game ) {
        this.game = game;
        int width = GAME_VIEWPORT_WIDTH;
        int height = GAME_VIEWPORT_HEIGHT;
        this.stage = new Stage( width, height, true );
    }

    protected String getName() {
        return getClass().getSimpleName();
    }

    public BitmapFont getFont() {
        if( font == null ) {
            font = new BitmapFont();
            font.setColor(Color.WHITE);
        }
        return font;
    }

    public TextureAtlas getAtlas() {
        if( atlas == null ) {
            atlas = new TextureAtlas( Gdx.files.internal( "texture/pack.atlas" ) );
        }
        return atlas;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor( stage );
    }

    // Game loop
    @Override
    public void render(float delta ) {
        // Update the actors 
		stage.act( delta );


        // Render
        // clear the screen with black
        Gdx.gl.glClearColor( 0.0f, 0.0f, 0.0f, 1f );
        
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        // Draw the actors
        stage.draw();
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose()
    {
        GemCatcher.log( "Disposing screen: " + getName() );
        if( font != null ) font.dispose();
        if( batch != null ) batch.dispose();
        if( atlas != null ) atlas.dispose();
    }
    
    
    // Misc method that must be implemented
	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		// Important for mobile devices
	}
	@Override
	public void resume() {
		// Important for mobile devices		
	}
    
}

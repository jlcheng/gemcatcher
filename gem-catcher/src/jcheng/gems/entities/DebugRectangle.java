package jcheng.gems.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class DebugRectangle extends RectImage {
	
	public static boolean debug = false;

	public DebugRectangle(TextureAtlas atlas) {
		super(atlas);
	}
	
	@Override
	public void drawRect(SpriteBatch batch, float parentAlpha, float x, float y, float width, float height) {
		if (DebugRectangle.debug) super.drawRect(batch, parentAlpha, x, y, width, height);
	}

}

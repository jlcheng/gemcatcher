/**
 * 
 */
package jcheng.gems.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

/**
 * InputListener that moves a target {@code Actor} by drag gesture anywhere
 * on the screen.
 * 
 * @author jcheng
 *
 */
public class DragActor extends DragListener {
	
	private final Actor actor;
	
	public DragActor(Actor actor) {
		this.actor = actor;
	}

	@Override public void drag(InputEvent event, float x, float y, int pointer) {
		float maxWidth = actor.getStage().getWidth() - actor.getWidth();
		float newX = MathUtils.clamp(x, 0, maxWidth);
		actor.setX(newX);
	}
}

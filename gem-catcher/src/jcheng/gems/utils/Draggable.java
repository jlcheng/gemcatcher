package jcheng.gems.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class Draggable extends DragListener {
	
	private final Actor actor;
	float touchDownX = 0f;
	
	public Draggable(Actor actor) {
		 this.actor = actor;
	}
	
	@Override public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
		boolean retval = super.touchDown(event, x, y, pointer, button);
		touchDownX = x;
		return retval;
	}
	@Override public void drag(InputEvent event, float x, float y, int pointer) {
		float maxWidth = actor.getStage().getWidth() - actor.getWidth();
		float newX = (actor.getX() + (x - touchDownX));
		newX = MathUtils.clamp(newX, 0, maxWidth);
		actor.setX(newX);
	}
}

package jcheng.gems.utils;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Moves target down at constant rate.
 * 
 * @author jcheng
 *
 */
public class ConstantFall extends Action {
	@Override
	public boolean act(float delta) {
		Actor target = getActor();       if (target == null) return false;
		Stage stage = target.getStage(); if (stage  == null) return false;
		
		float newY = target.getY() - 1;
		newY = Math.max(newY, 0);
		if (newY <= 0) {
			target.removeAction(this);
		}
		target.setY(newY);
		return false;
	}
}

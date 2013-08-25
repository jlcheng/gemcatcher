package jcheng.gems;

import jcheng.gems.GemCatcher;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class GemCatcherDesktop {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "gem-catcher";
		cfg.useGL20 = true;
		cfg.width = 360;
		cfg.height = 640;
		
		new LwjglApplication(new GemCatcher(), cfg);
	}
}

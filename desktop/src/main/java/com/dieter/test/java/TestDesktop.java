package com.dieter.test.java;

import com.dieter.test.core.Test;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class TestDesktop {
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL20 = true;
        config.width = 800;
        config.height = 600;
		new LwjglApplication(new Test(), config);
	}
}

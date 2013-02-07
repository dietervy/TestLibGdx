package com.dieter.test.core;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector3;

import java.util.List;

public class Test implements ApplicationListener {
    public static final int NUM_POINTS = 20;
    Texture texture;
	SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    private CatmullRomSpline catmullRomSpline;
    private Path path;
    int i =0;
    @Override
	public void create () {
		texture = new Texture(Gdx.files.internal("libgdx-logo.png"));
		batch = new SpriteBatch();
        shapeRenderer=new ShapeRenderer();
        long t1 = System.currentTimeMillis();
        catmullRomSpline = new CatmullRomSpline();
        catmullRomSpline.add(new Vector3(600,150,0));
        catmullRomSpline.add(new Vector3(100,100,0));
        catmullRomSpline.add(new Vector3(400,500,0));
        catmullRomSpline.add(new Vector3(700,250,0));
        catmullRomSpline.add(new Vector3(600,150,0));
        catmullRomSpline.add(new Vector3(100,100,0));
        catmullRomSpline.add(new Vector3(400,500,0));
        path = new Path(catmullRomSpline,20);
	}

	@Override
	public void resize (int width, int height) {
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        path.render();
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        shapeRenderer.circle(pathList.get(i).x,pathList.get(i).y,5);
//        if(i>83){
//            i= 0;
//        } else {
//            i++;
//        }
//        shapeRenderer.end();

	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

	@Override
	public void dispose () {
	}
}

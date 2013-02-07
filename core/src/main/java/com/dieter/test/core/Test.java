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
    private List<Vector3> pathList;
    private List<Vector3> normalList;

    @Override
	public void create () {
		texture = new Texture(Gdx.files.internal("libgdx-logo.png"));
		batch = new SpriteBatch();
        shapeRenderer=new ShapeRenderer();
        catmullRomSpline = new CatmullRomSpline();
        catmullRomSpline.add(new Vector3(90,90,0));
        catmullRomSpline.add(new Vector3(100,100,0));
        catmullRomSpline.add(new Vector3(400,500,0));
        catmullRomSpline.add(new Vector3(300,250,0));
        catmullRomSpline.add(new Vector3(600,400,0));
        catmullRomSpline.add(new Vector3(700,50,0));
        catmullRomSpline.add(new Vector3(710,60,0));
        pathList = catmullRomSpline.getPath(NUM_POINTS);
        normalList = catmullRomSpline.getTangentNormals2D(NUM_POINTS);
        //convert to angle
        // atan2(y,x) -> angle ten opzichte van x
        //atan2(x,y) -> tov y
        // multiply by 180/pi -> degrees
        System.out.println(normalList);
	}

	@Override
	public void resize (int width, int height) {
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Point);
        shapeRenderer.setColor(Color.RED);

//        shapeRenderer.line(10, 10, 50, 50);
        for(Vector3 point:pathList){
            shapeRenderer.point(point.x,point.y,point.z);

        }
        shapeRenderer.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.DARK_GRAY);
        for(int i=0;i<84;i++){
            shapeRenderer.line(pathList.get(i).x,pathList.get(i).y,pathList.get(i).x+20*normalList.get(i).x,pathList.get(i).y+20*normalList.get(i).y);
        }
        shapeRenderer.end();

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

package com.dieter.test.core;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector3;

import java.util.List;

/**
 * Copyrights EnergyICT
 * Date: 7/02/13
 * Time: 14:27
 */
public class Path {
    private CatmullRomSpline catmullRomSpline;
    private List<Vector3> pathList;
    private List<Vector3> normalList;
    private int nrOfPoints;
    private int nrOfInterval;


    public Path(CatmullRomSpline catmullRomSpline,int nrOfInterval) {
        this.catmullRomSpline = catmullRomSpline;
        pathList = catmullRomSpline.getPath(nrOfInterval);
        normalList = catmullRomSpline.getTangentNormals2D(nrOfInterval);
        this.nrOfInterval = nrOfInterval;
        nrOfPoints = nrOfInterval*(catmullRomSpline.getControlPoints().size()-3) + catmullRomSpline.getControlPoints().size()-2;
    }

    public int getNrOfPoints() {
        return nrOfPoints;
    }

    public void setNrOfPoints(int nrOfPoints) {
        this.nrOfPoints = nrOfPoints;
    }

    public int getNrOfInterval() {
        return nrOfInterval;
    }

    public void setNrOfInterval(int nrOfInterval) {
        this.nrOfInterval = nrOfInterval;
    }

    public CatmullRomSpline getCatmullRomSpline() {
        return catmullRomSpline;
    }

    public void setCatmullRomSpline(CatmullRomSpline catmullRomSpline) {
        this.catmullRomSpline = catmullRomSpline;
    }

    public List<Vector3> getPathList() {
        return pathList;
    }

    public void setPathList(List<Vector3> pathList) {
        this.pathList = pathList;
    }

    public List<Vector3> getNormalList() {
        return normalList;
    }

    public void setNormalList(List<Vector3> normalList) {
        this.normalList = normalList;
    }

    public void render() {
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Point);
        shapeRenderer.setColor(Color.RED);

        for(Vector3 point:pathList){
            shapeRenderer.point(point.x,point.y,point.z);

        }
        shapeRenderer.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.DARK_GRAY);
        for(int i=0;i<nrOfPoints-1;i++){
            shapeRenderer.line(pathList.get(i).x,pathList.get(i).y,pathList.get(i).x+nrOfInterval*normalList.get(i).x,pathList.get(i).y+nrOfInterval*normalList.get(i).y);
        }
        shapeRenderer.end();
    }
}

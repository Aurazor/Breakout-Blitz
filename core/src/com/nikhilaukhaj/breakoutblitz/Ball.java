package com.nikhilaukhaj.breakoutblitz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball extends GameObject{

    int size;
    int xSpeed;
    int ySpeed;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        super(x, y, size*2, size*2);
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public void update() {
        x += xSpeed;
        y += ySpeed;
        final int movingSize = size;

        if (x < movingSize  || x > Gdx.graphics.getWidth() - movingSize) {
            xSpeed = -xSpeed;
        }
        if (y < movingSize || y > Gdx.graphics.getHeight() - movingSize) {
            ySpeed = -ySpeed;
        }
    }
    public void draw(ShapeRenderer shape) {
        shape.circle(x, y, size);
    }
}

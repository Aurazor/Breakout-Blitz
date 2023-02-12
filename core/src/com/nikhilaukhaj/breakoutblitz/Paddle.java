package com.nikhilaukhaj.breakoutblitz;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x;
    int y;

    int width;
    int height;
    int xSpeed;
    public Paddle(int x, int y, int width, int height, int xSpeed){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.xSpeed = xSpeed;
    }

    public void update(int mouseX){
           if(x + width/2 > mouseX){
               x -= xSpeed;
           }else if(x + width/2 < mouseX){
               x += xSpeed;
           }
    }

    public void draw(ShapeRenderer shape){
        shape.rect(x,y,width,height);
    }



}

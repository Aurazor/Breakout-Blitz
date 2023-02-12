package com.nikhilaukhaj.breakoutblitz;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block extends GameObject{

    boolean destroyed;
    public Block(int x, int y, int width, int height) {
        super(x,y, width, height);
        this.width = width;
        this.height = height;
        this.destroyed = false;
    }
    public void draw(ShapeRenderer shape){
        shape.rect(x, y, width, height);
    }

    public boolean isDestroyed(){
        return destroyed;
    }
    public void destroy(){
        this.destroyed = true;
    }
}

package com.nikhilaukhaj.breakoutblitz;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class BreakoutBlitz extends ApplicationAdapter {
    ShapeRenderer shape;
    Ball ball;
    Paddle paddle;

    ArrayList<Block> blocks = new ArrayList<>();

    Random r = new Random();

    @Override
    public void create() {
        shape = new ShapeRenderer();
//        ball = new Ball(r.nextInt(Gdx.graphics.getWidth()),r.nextInt(Gdx.graphics.getHeight()),r.nextInt(100),r.nextInt(15),r.nextInt(15));
        ball = new Ball(20,20,10,4,4);
        paddle = new Paddle(10,10,90,10,10);

        int blockWidth = 63;
        int blockHeight = 20;
        for (int y = Gdx.graphics.getHeight()/2; y < Gdx.graphics.getHeight(); y += blockHeight + 10) {
            for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
                blocks.add(new Block(x, y, blockWidth, blockHeight));
            }
        }

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shape.begin(ShapeRenderer.ShapeType.Filled);

        ball.update();
        ball.draw(shape);

        int mouseX = Gdx.input.getX();

        Iterator<Block> it = blocks.iterator();
        while(it.hasNext()){
            Block block = (Block) it.next();

            if(!block.isDestroyed()){
                block.draw(shape);
            }
        }

        paddle.update(mouseX);
        paddle.draw(shape);
        checkBallAndBlockCollision(ball,blocks);

        checkCollision(ball, paddle,shape);

        shape.end();
    }


    public void checkBallAndBlockCollision(Ball ball, ArrayList<Block> blocks){
        for (Block block : blocks) {
            if(!block.isDestroyed()){
                if (checkCollision(ball, block)) {
                    block.destroy();
                    ball.ySpeed = -ball.ySpeed;
                }
            }

        }
    }

    public void checkCollision(Ball ball, Paddle paddle, ShapeRenderer shape){
        if(paddle.y + paddle.height > ball.y - ball.size){
            if(!(ball.x + ball.size < paddle.x || ball.x > paddle.x + paddle.width)){
                shape.setColor(Color.GREEN);
                ball.ySpeed = -ball.ySpeed;
            }else{
                shape.setColor(Color.RED);
            }
        }
    }

    public boolean checkCollision(GameObject object1, GameObject object2){
        return object1.x + object1.width > object2.x &&
                object1.x < object2.x + object2.width &&
                object1.y + object1.height > object2.y &&
                object1.y < object2.y + object2.height;
    }



}

package com.nikhilaukhaj.breakoutblitz;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class BreakoutBlitz extends ApplicationAdapter {
    ShapeRenderer shape;
    Ball ball;
    Paddle paddle;

    Random r = new Random();

    @Override
    public void create() {
        shape = new ShapeRenderer();
//        ball = new Ball(r.nextInt(Gdx.graphics.getWidth()),r.nextInt(Gdx.graphics.getHeight()),r.nextInt(100),r.nextInt(15),r.nextInt(15));
        ball = new Ball(100,100,10,1,1);
        paddle = new Paddle(10,10,90,10,10);

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shape.begin(ShapeRenderer.ShapeType.Filled);

        ball.update();
        ball.draw(shape);

        int mouseX = Gdx.input.getX();

        paddle.update(mouseX);
        paddle.draw(shape);

        checkCollision(ball, paddle,shape);

        shape.end();
    }

    public void checkCollision(Ball ball, Paddle paddle, ShapeRenderer shape){
        //TODO: check if ball if below paddle
        // if yes then check if it collides with paddle
        // else game over

        if(paddle.y + paddle.height > ball.y - ball.size){
            if(paddle.x + paddle.width > ball.x || paddle.x < ball.x + ball.size){
                shape.setColor(Color.GREEN);
            }else{
                shape.setColor(Color.RED);
            }
//            return true;
        }
//        return false;
    }
}

package com.bYonath.main.games;

import com.bYonath.main.Constants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Pong implements Screen {

    ShapeRenderer renderer;
    //SpriteBatch batch;

    Vector2 bluePaddlePos, redPaddlePos, ballPos;
    int paddleWidth;
    int paddleHeight;

    public Pong(){
        renderer = new ShapeRenderer();
        paddleWidth = 10;
        paddleHeight = 100;
        bluePaddlePos = new Vector2(0, (Constants.height/2)-(paddleHeight/2f));
        redPaddlePos = new Vector2(Constants.width-paddleWidth,(Constants.height/2)-(paddleHeight/2f));
        ballPos = new Vector2(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.15f,0.15f,0.15f,0.15f);

        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.setColor(Color.WHITE);
        renderer.circle(ballPos.x, ballPos.y, 15);
        renderer.setColor(Color.BLUE);
        renderer.rect(bluePaddlePos.x, bluePaddlePos.y, paddleWidth, paddleHeight);
        renderer.setColor(Color.RED);
        renderer.rect(redPaddlePos.x, redPaddlePos.y, paddleWidth, paddleHeight);

        update();
        processInput();

        renderer.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void processInput()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            if(!(bluePaddlePos.y > Constants.height-paddleHeight)) {
                bluePaddlePos.add(0, 4f);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S))
        {
            if(!(bluePaddlePos.y < 0)) {
                bluePaddlePos.add(0, -4f);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            if(!(redPaddlePos.y > Constants.height-paddleHeight)) {
                redPaddlePos.add(0, 4f);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            if(!(redPaddlePos.y < 0)) {
                redPaddlePos.add(0, -4f);
            }
        }
    }

    public void update()
    {
        ballPos.add(0.5f, 0f);
    }
}

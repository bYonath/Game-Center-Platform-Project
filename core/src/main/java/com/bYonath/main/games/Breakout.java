package com.bYonath.main.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Breakout implements Screen {

    private ShapeRenderer renderer;
    private Vector2 ballPos, padPos;

    public Breakout()
    {
        renderer = new ShapeRenderer();

        ballPos = new Vector2(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
        padPos = new Vector2(Gdx.graphics.getWidth()/2f, 20);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.15f,0.15f,0.15f,0.15f);

        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.circle(ballPos.x, ballPos.y, 15);
        renderer.rect(padPos.x, padPos.y, 100, 15);

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
}

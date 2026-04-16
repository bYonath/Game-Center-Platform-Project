package com.bYonath.main;

import com.bYonath.main.games.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {

    public Menu menu;
    public GuessNumber guessNumber;
    public SanKenBon rockPaperScissors;
    public Hangman hangman;
    public Pong pong;
    public Breakout breakout;

    @Override
    public void create() {
        menu = new Menu(this);
        guessNumber = new GuessNumber();
        rockPaperScissors = new SanKenBon();
        hangman = new Hangman();
        pong = new Pong();
        breakout = new Breakout();

        this.setScreen(menu);
        //System.out.println(Gdx.graphics.getWidth());
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f,0.15f,0.15f,0.15f);

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
        {
            this.setScreen(menu);
        }

        super.render();
    }

    @Override
    public void dispose() {

    }
}

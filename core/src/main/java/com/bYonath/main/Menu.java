package com.bYonath.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class Menu implements Screen {

    private Main game;

    private Stage stage;

    private Table table;
    private Table buttonTable;

    private Skin skin;

    // Title Label
    private Label label;

    private TextButton button1;
    private TextButton button2;
    private TextButton button3;
    private TextButton button4;
    private TextButton button5;

    public Menu(Main game)
    {
        this.game = game;

        skin = new Skin(Gdx.files.internal(Constants.UI_SKIN_PATH));

        stage = new Stage();

        //stage.setDebugAll(true);

        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.setFillParent(true);

        buttonTable = new Table();
        table.setSize(500,500);

        // Create Title Label
        label = new Label("Game Platform", skin);

        // create the buttons
        button1 = new TextButton("Number Guess", skin);
        button1.setSize(300,100);
        button1.pad(10);
        button1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.guessNumber);
            }
        });

        button2 = new TextButton("Hangman", skin);
        button2.setSize(500, 100);
        button2.pad(10);
        button2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.hangman);
            }
        });

        button3 = new TextButton("Rock Paper Scissors", skin);
        button3.setSize(500, 100);
        button3.pad(10);
        button3.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.rockPaperScissors);
            }
        });

        button4 = new TextButton("Pong", skin);
        button4.setSize(500, 100);
        button4.pad(10);
        button4.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.pong);
            }
        });

        button5 = new TextButton("Breakout", skin);
        button5.setSize(100, 100);
        button5.pad(10, 100, 10, 100);
        button5.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.breakout);
            }
        });

        table.add(label).spaceBottom(50);
        table.row();
        // Adding all the buttons
        buttonTable.add(button1);
        buttonTable.row();
        buttonTable.add(button2);
        buttonTable.row();
        buttonTable.add(button3);
        buttonTable.row();
        buttonTable.add(button4);
        buttonTable.row();
        buttonTable.add(button5);

        table.add(buttonTable);

        stage.addActor(table);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
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

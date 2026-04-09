package com.bYonath.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class Menu implements Screen {

    private Stage stage;
    private Table table;

    private Skin skin;
    private TextButton button1;
    private TextButton button2;
//    private TextButton button3;
//    private TextButton button4;
//    private TextButton button5;

    public Menu()
    {
        skin = new Skin(Gdx.files.internal(Constants.UI_SKIN_PATH));

        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.setFillParent(true);

        // create the buttons
        button1 = new TextButton("Number Guess", skin);
        button1.setSize(300,100);
//        button1.addListener(new ChangeListener() {
//            @Override
//            public void changed(ChangeEvent event, Actor actor) {
//                System.out.println("Button Clicked");
//            }
//        });

        button2 = new TextButton("Hangman", skin);
        button2.setSize(300, 100);

        table.add(button1);
        table.row();
        table.add(button2);

        stage.addActor(table);
    }

    @Override
    public void show() {

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

package com.bYonath.main.games;

import com.bYonath.main.Constants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import java.util.Random;

public class GuessNumber implements Screen {

    int number = (int) ((Math.random() * 100) + 1);
    int guess = 3;
    int thing = -1;

    Skin skin;

    Stage stage;

    Table table;

    Label title;
    Label attempts;

    TextField resp;

    TextButton ans;

    public GuessNumber()
    {
        stage = new Stage();
        table = new Table();
        table.setFillParent(true);

        skin = new Skin(Gdx.files.internal(Constants.UI_SKIN_PATH));

        title = new Label("Guess a number between 1-100", skin);
        attempts = new Label("You have " + guess + " tries", skin);
        resp = new TextField("", skin);
        ans = new TextButton("Guess", skin);
        ans.addListener(new ChangeListener() {
            // Most of the game logic will go here
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Literally the game logic
                thing = Integer.parseInt(resp.getText());

                if(thing == number)
                {
                    title.setText("Correct!");
                    attempts.setText("You found the number in " + guess + " tries!");
                    ans.setDisabled(true);
                }
                else
                {
                    title.setText("Incorrect, Please Try again");
                    guess--;
                    if(guess == 0)
                    {
                        attempts.setText("You Lose!");
                        ans.setDisabled(true);
                    }
                    else
                    {
                        attempts.setText("You have " + guess + " tries");
                    }
                }
            }
        });

        table.add(title);
        table.row();
        table.add(attempts).pad(25f,0f,25f,0f);
        table.row();
        table.add(resp);
        table.row();
        table.add(ans);

        stage.addActor(table);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        number = (int) ((Math.random() * 100) + 1);
        guess = 3;
        title.setText("Guess a number between 1-100");
        attempts.setText("You have " + guess + " tries");
        ans.setDisabled(false);

        System.out.println(number);
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

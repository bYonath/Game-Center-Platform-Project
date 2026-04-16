package com.bYonath.main.games;

import com.bYonath.main.Constants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class SanKenBon implements Screen {

    // Computer selection for rock paper scissors
    int number = (int) ((Math.random() * 2) + 1);

    String[] selection = {"Rock", "Paper", "Scissors"};

    String compChoice = selection[number-1];
    String userChoice = "";

    private Stage stage;

    private Table table;

    private Skin skin;

    private Label res;

    private TextButton rock;
    private TextButton paper;
    private TextButton scissors;

    private TextButton shoot;

    public SanKenBon()
    {
        stage = new Stage();

        table = new Table();
        table.setFillParent(true);

        skin = new Skin(Gdx.files.internal(Constants.UI_SKIN_PATH));

        res = new Label("Select Rock, Paper, Or Scissors", skin);

        rock = new TextButton("Rock", skin);
        rock.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                userChoice = rock.getText().toString();
                System.out.println(userChoice);
            }
        });
        paper = new TextButton("Paper", skin);
        paper.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                userChoice = paper.getText().toString();
                System.out.println(userChoice);
            }
        });

        scissors = new TextButton("Scissors", skin);
        scissors.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                userChoice = scissors.getText().toString();
                System.out.println(userChoice);
            }
        });

        shoot = new TextButton("Shoot", skin);
        shoot.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("User Chose: " + userChoice);
                System.out.println("Computer Chose: " + compChoice);

                if(userChoice.equals("Paper") && compChoice.equals("Scissors"))
                {
                    res.setText("Computer Wins");
                }
                if(userChoice.equals("Scissors") && compChoice.equals("Paper"))
                {
                    res.setText("Player Wins");
                }
                if(userChoice.equals("Rock") && compChoice.equals("Paper"))
                {
                    res.setText("Computer Wins");
                }
                if(userChoice.equals("Paper") && compChoice.equals("Rock"))
                {
                    res.setText("Player Wins");
                }
                if(userChoice.equals("Scissors") && compChoice.equals("Rock"))
                {
                    res.setText("Computer Wins");
                }
                if(userChoice.equals("Rock") && compChoice.equals("Scissors"))
                {
                    res.setText("Player Wins");
                }
                if(userChoice.equals(compChoice))
                {
                    res.setText("TIE!");
                }
            }
        });

        table.add(res).size(100f, 50f);
        table.row();
        table.add(rock).size(100f, 100f);
        table.row();
        table.add(paper).size(100f, 100f);
        table.row();
        table.add(scissors).size(100f, 100f);
        table.row();
        table.add(shoot).size(100f, 50f);

        stage.addActor(table);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        number = (int) ((Math.random() * 2) + 1);
        compChoice = selection[number-1];
        res.setText("Select Rock, Paper, Or Scissors");
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

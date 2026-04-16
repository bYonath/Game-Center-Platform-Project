package com.bYonath.main.games;

import com.bYonath.main.Constants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import sun.font.TextLabel;

import java.util.Arrays;
import java.util.Random;

public class Hangman implements Screen {

    String[] wordBank = {
        "apple", "river", "mountain", "cloud", "forest", "ocean", "tree", "stone", "light", "shadow",
        "dream", "storm", "field", "flower", "grass", "sky", "wind", "fire", "water", "earth",
        "sun", "moon", "star", "planet", "space", "time", "sound", "voice", "music", "song",
        "dance", "smile", "laugh", "cry", "hope", "peace", "love", "joy", "truth", "faith",
        "power", "energy", "force", "speed", "motion", "shape", "form", "color", "line", "pattern",
        "circle", "square", "triangle", "angle", "point", "number", "code", "logic", "system", "data",
        "input", "output", "value", "object", "class", "method", "array", "list", "map", "set",
        "loop", "break", "continue", "return", "build", "create", "design", "develop", "test", "debug",
        "deploy", "run", "execute", "compile", "learn", "teach", "read", "write", "think", "solve",
        "plan", "start", "finish", "open", "close", "begin", "end", "grow", "change", "adapt"
    };

    int number = (int) ((Math.random() * wordBank.length) + 1);
    int attempts = 6;

    String word = wordBank[number-1];

    String input = "";
    // This is the string which will be
    // displayed
    char[] guess = new char[word.length()];

    Stage stage;
    Skin skin;
    Table root;
    Table displ;
    Table spacer;

    Label current;
    Label triesLeft;
    TextField entry;

    // Using a button for now to save time
    TextButton guessButton;

    ShapeRenderer renderer;

    public Hangman()
    {
        Arrays.fill(guess, '_');

        stage = new Stage();
        //stage.setDebugAll(true);
        skin = new Skin(Gdx.files.internal(Constants.UI_SKIN_PATH));

        root = new Table();
        root.setFillParent(true);
        displ = new Table();
        //displ.setFillParent(true);
        displ.setSize(root.getWidth()/2, root.getHeight());
        spacer = new Table();

        current = new Label(new String(guess), skin);
        triesLeft = new Label("You have " + attempts + " tries left",skin);
        entry = new TextField("", skin);

        guessButton = new TextButton("Guess", skin);
        guessButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                boolean found = false;

                if(new String(guess).equals(word))
                {
                    triesLeft.setText("You Found the Word!");
                }

                for(int i = 0; i<entry.getText().length(); i++)
                {
                    char c = entry.getText().charAt(i);

                    found = false;

                    for(int j = 0; j<word.length(); j++)
                    {
                        if(word.charAt(j) == c)
                        {
                            found = true;
                            guess[j] = c;
                        }
                    }
                }

                if(!found)
                {
                    attempts--;
                    triesLeft.setText("You have " + attempts + " tries left");
                }

                if(attempts == 0)
                {
                    triesLeft.setText("You loose");
                    entry.setDisabled(true);
                }

                current.setText(new String(guess));
            }
        });

        stage.addActor(root);

        displ.defaults().size(150f, 50f)
            .padTop(10f).padBottom(10f).align(Align.right);
        displ.add(current);
        displ.row();
        displ.add(triesLeft);
        displ.row();
        displ.add(entry);
        displ.row();
        displ.add(guessButton);

        root.add(displ).padLeft(200f);

        renderer = new ShapeRenderer();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        entry.setDisabled(false);
        number = (int) ((Math.random() * wordBank.length) + 1);
        word = wordBank[number-1];
        attempts = 6;
        guess = new char[word.length()];
        Arrays.fill(guess, '_');
        System.out.println(word);
    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();

        renderer.begin(ShapeRenderer.ShapeType.Filled);

        switch (attempts)
        {
            case 5:
                renderer.circle((Gdx.graphics.getWidth()/2f)-20, Gdx.graphics.getHeight()/2f, 25);
                break;
            case 4:
                renderer.circle((Gdx.graphics.getWidth()/2f)-20, Gdx.graphics.getHeight()/2f, 25);
                renderer.rect((Gdx.graphics.getWidth()/2f)-30, Gdx.graphics.getHeight()/2f - 130, 10, 100);
                break;
            case 3:
                renderer.circle((Gdx.graphics.getWidth()/2f)-20, Gdx.graphics.getHeight()/2f, 25);
                renderer.rect((Gdx.graphics.getWidth()/2f)-30, Gdx.graphics.getHeight()/2f - 130, 10, 100);
                renderer.rect((Gdx.graphics.getWidth()/2f)-150/2f, Gdx.graphics.getHeight()/2f - 50, 100, 10);
                break;
            case 2:
                renderer.circle((Gdx.graphics.getWidth()/2f)-20, Gdx.graphics.getHeight()/2f, 25);
                renderer.rect((Gdx.graphics.getWidth()/2f)-30, Gdx.graphics.getHeight()/2f - 130, 10, 100);
                renderer.rect((Gdx.graphics.getWidth()/2f)-150/2f, Gdx.graphics.getHeight()/2f - 50, 100, 10);
                break;
            case 1:
                renderer.circle((Gdx.graphics.getWidth()/2f)-20, Gdx.graphics.getHeight()/2f, 25);
                renderer.rect((Gdx.graphics.getWidth()/2f)-30, Gdx.graphics.getHeight()/2f - 130, 10, 100);
                renderer.rect((Gdx.graphics.getWidth()/2f)-150/2f, Gdx.graphics.getHeight()/2f - 50, 100, 10);
                renderer.rect((Gdx.graphics.getWidth()/2f)-150/2f, Gdx.graphics.getHeight()/2f - 150, 100, 10);
                break;
        }

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

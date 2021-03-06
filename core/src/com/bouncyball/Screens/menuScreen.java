package com.bouncyball.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bouncyball.MainGame;
import com.bouncyball.Screens.Levels.LevelOne;

public class MenuScreen extends BaseScreen {

    private Stage stage;
    private Skin skin;
    private TextButton play, credits;

    public MenuScreen(final MainGame game) {
        super(game);

        stage = new Stage(new FitViewport(360, 640));
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        play = new TextButton("Play", skin);
        credits = new TextButton("Credits", skin);

        play.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // TODO
                game.setScreen(game.levelOne);
            }
        });

        credits.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // TODO
            }
        });

        play.setPosition(80, 350);
        credits.setPosition(80, 250);

        play.setSize(200, 80);
        credits.setSize(200, 80);

        stage.addActor(play);
        stage.addActor(credits);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }
}

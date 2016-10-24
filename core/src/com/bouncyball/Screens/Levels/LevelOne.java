package com.bouncyball.Screens.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bouncyball.Entities.EntityFactory;
import com.bouncyball.Entities.PlayerEntity;
import com.bouncyball.MainGame;
import com.bouncyball.Screens.BaseScreen;

public class LevelOne extends BaseScreen {

    private Stage stage;
    private World world;
    private PlayerEntity player;
    private Vector3 position;

    public LevelOne(MainGame game) {
        super(game);

        stage = new Stage(new FitViewport(360, 640));
        position = new Vector3(stage.getCamera().position);

        world = new World(new Vector2(0, 0), true);
        world.setContactListener(new GameContactListener());

        // Here will be the sounds and other stuff, too
    }

    @Override
    public void show() {
        EntityFactory factory = new EntityFactory(game.getManager());

        player = factory.createPlayer(world, new Vector2(1.5f, 1.5f));

        stage.addActor(player);
        stage.getCamera().position.set(position);
        stage.getCamera().update();
    }

    @Override
    public void hide() {
        stage.clear();
        player.detach();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();

        world.step(delta, 6, 2);

        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        world.dispose();
    }
}

package com.bouncyball.Screens.Levels;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
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

        world = new World(new Vector2(0, -10), true);
        world.setContactListener(new GameContactListener());

        // Here will be the sounds and other stuff, too
    }

    @Override
    public void show() {
        super.show();
    }
}

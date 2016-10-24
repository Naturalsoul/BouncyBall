package com.bouncyball.Entities;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class EntityFactory {

    private AssetManager manager;

    public EntityFactory(AssetManager manager) {
        this.manager = manager;
    }

    public PlayerEntity createPlayer (World world, Vector2 position) {
        Texture playerTexture = manager.get("player.png");
        return new PlayerEntity(world, playerTexture, position);
    }
}

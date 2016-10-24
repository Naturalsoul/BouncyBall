package com.bouncyball.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.bouncyball.Constants;

public class PlayerEntity extends Actor {

    private Texture texture;
    private World world;
    private Body body;
    private Fixture fixture;
    private boolean isAlive = true;

    public PlayerEntity (World world, Texture texture, Vector2 position) {
        this.world = world;
        this.texture = texture;

        // Body creation
        BodyDef def = new BodyDef();
        def.position.set(position);
        def.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(def);

        // Shape creation
        PolygonShape box = new PolygonShape();
        box.setAsBox(1.5f, 0.5f);
        fixture = body.createFixture(box , 3);
        fixture.setUserData("player");
        box.dispose();

        // Size in meters
        setSize(Constants.PIXELS_IN_METERS, Constants.PIXELS_IN_METERS / 2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x * Constants.PIXELS_IN_METERS, (body.getPosition().y - 0.5f) * Constants.PIXELS_IN_METERS);
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {
        if (Gdx.input.justTouched()) {
            move();
        }
    }

    private void move() {
        setPosition(Gdx.input.getX(), body.getPosition().y);
    }

    private void detach() {
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}

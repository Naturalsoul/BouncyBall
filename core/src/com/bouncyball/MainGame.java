package com.bouncyball;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.bouncyball.Screens.BaseScreen;
import com.bouncyball.Screens.Levels.LevelOne;
import com.bouncyball.Screens.LoadingScreen;
import com.bouncyball.Screens.MenuScreen;

public class MainGame extends Game {

    private AssetManager manager;

    public BaseScreen loadingScreen, menuScreen;
    public BaseScreen levelOne;

    @Override
    public void create() {
        manager = new AssetManager();

        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);
    }

    public void finishLoading() {
        menuScreen = new MenuScreen(this);
        levelOne = new LevelOne(this);
        setScreen(menuScreen);
    }

    public AssetManager getManager() {
        return manager;
    }
}

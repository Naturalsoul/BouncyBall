package com.bouncyball;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.bouncyball.Screens.BaseScreen;
import com.bouncyball.Screens.LoadingScreen;
import com.bouncyball.Screens.MenuScreen;

public class MainGame extends Game {

    private AssetManager manager;

    public BaseScreen loadingScreen, menuScreen;

    @Override
    public void create() {
        manager = new AssetManager();

        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);
    }

    public void finishLoading() {
        menuScreen = new MenuScreen(this);
        setScreen(menuScreen);
    }

    public AssetManager getManager() {
        return manager;
    }
}

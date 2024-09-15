package org.example.utils;

import org.example.scene.BaseScene;

public class GameSceneManager {
    public static final GameSceneManager instance = new GameSceneManager();
    private BaseScene baseScene;

    private GameSceneManager() {}

    public BaseScene getBaseScene() {
        return baseScene;
    }

    public void setBaseScene(BaseScene baseScene) {
        this.baseScene = baseScene;
        baseScene.frame.addKeyListener(baseScene);
    }
}

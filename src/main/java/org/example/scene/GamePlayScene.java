package org.example.scene;

import org.example.controller.BackgroundController;
import org.example.controller.BaseController;
import org.example.controller.PlaneController;
import org.example.controller.PlaneEnemiesController;
import org.example.model.BackgroundModel;
import org.example.model.PlaneEnemiesModel;
import org.example.model.PlaneModel;
import org.example.utils.CollisionsManager;
import org.example.utils.Constant;
import org.example.utils.ControllersManager;
import org.example.utils.InputManager;
import org.example.view.BackgroundView;
import org.example.view.PlaneEnemiesView;
import org.example.view.PlaneView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlayScene extends BaseScene implements KeyListener {
    private PlaneController planeController;
    private final InputManager inputManager = new InputManager();

    public GamePlayScene(Graphics backbufferGraphics, Frame frame) {
        initBaseController(backbufferGraphics);
        this.frame = frame;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                inputManager.setUpPressed(true);
                break;
            case KeyEvent.VK_DOWN:
                inputManager.setDownPressed(true);
                break;
            case KeyEvent.VK_LEFT:
                inputManager.setLeftPressed(true);
                break;
            case KeyEvent.VK_RIGHT:
                inputManager.setRightPressed(true);
                break;
            case KeyEvent.VK_SPACE:
                inputManager.setSpacePressed(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                inputManager.setUpPressed(false);
                break;
            case KeyEvent.VK_DOWN:
                inputManager.setDownPressed(false);
                break;
            case KeyEvent.VK_LEFT:
                inputManager.setLeftPressed(false);
                break;
            case KeyEvent.VK_RIGHT:
                inputManager.setRightPressed(false);
                break;
            case KeyEvent.VK_SPACE:
                inputManager.setSpacePressed(false);
                break;
        }
    }

    @Override
    public void initScene() {

    }

    @Override
    public void updateScene() {
        CollisionsManager.instance.runCheckingCollisions();
        planeController.processInput(
                inputManager.isUpPressed(),
                inputManager.isDownPressed(),
                inputManager.isLeftPressed(),
                inputManager.isRightPressed(),
                inputManager.isSpacePressed());
    }

    @Override
    public void repaint() {
        executeControllers();
    }


    void initBaseController(Graphics graphics) {
        ControllersManager.instance.addController(createBackgroundController(graphics, -Constant.heightScreen * 2, 0,"res/background1.png"));
        ControllersManager.instance.addController(createBackgroundController(graphics, 0, Constant.heightScreen * 2,"res/background2.png"));

        this.planeController = createPlaneController(graphics, 0, 0,"res/plane2.png", 0);
        PlaneEnemiesController planeEnemiesController = createPlaneEnemiesController(graphics, 0, 0, "res/enemy_plane_white_1.png", 0);

        ControllersManager.instance.addController(planeEnemiesController);
        ControllersManager.instance.addController(planeController);
    }

    void executeControllers() {
        for (int i = 0; i < ControllersManager.instance.getBaseControllerList().size(); i++) {
            ControllersManager.instance.getBaseControllerList().get(i).onMove(1);
        }

        for (int i = 0; i < ControllersManager.instance.getBaseControllerList().size(); i++) {
            ControllersManager.instance.getBaseControllerList().get(i).onDraw();
        }
    }

    BaseController createBackgroundController(Graphics graphics, int defaultOffSetY, int maxOffSet, String imagePath) {
        BackgroundModel backgroundModel = new BackgroundModel(0, defaultOffSetY, Constant.widthScreen, Constant.heightScreen * 2, imagePath, defaultOffSetY, maxOffSet);
        BackgroundView backgroundView = new BackgroundView(backgroundModel, graphics);
        return new BackgroundController(backgroundModel, backgroundView);
    }

    PlaneController createPlaneController(Graphics graphics , int defaultOffsetY , int maxOffset , String imagePath , int maxOffSetx) {
        PlaneModel planeModel = new PlaneModel ( 300, 400,32 , 32 ,imagePath , defaultOffsetY , maxOffset,maxOffSetx);
        PlaneView planeView = new PlaneView(planeModel , graphics);
        return new PlaneController(planeModel , planeView);
    }

    PlaneEnemiesController createPlaneEnemiesController(Graphics graphics, int defaultOffsetY, int maxOffset, String imagePath, int maxOffsetx) {
        PlaneEnemiesModel planeEnemiesModel = new PlaneEnemiesModel(20, 80, 32, 32, imagePath, defaultOffsetY, maxOffset, maxOffsetx);
        PlaneEnemiesView planeEnemiesView = new PlaneEnemiesView(planeEnemiesModel, graphics);
        return new PlaneEnemiesController(planeEnemiesModel, planeEnemiesView);
    }
}

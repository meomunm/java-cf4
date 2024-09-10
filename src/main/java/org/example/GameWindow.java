package org.example;

import org.example.controller.*;
import org.example.model.BackgroundModel;
import org.example.model.PlaneBulletModel;
import org.example.model.PlaneEnemiesModel;
import org.example.model.PlaneModel;
import org.example.utils.Constant;
import org.example.utils.ControllersManager;
import org.example.utils.InputManager;
import org.example.view.BackgroundView;
import org.example.view.PlaneBulletView;
import org.example.view.PlaneEnemiesView;
import org.example.view.PlaneView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADMIN on 5/1/2017.
 */
public class GameWindow extends Frame implements WindowListener, KeyListener {
    private BufferedImage bufferedImage;
    private Graphics backbufferGraphics;
    private PlaneController planeController;
    private PlaneEnemiesController planeEnemiesController;
    private PlaneBulletController planeBulletController;
    
    private final InputManager inputManager = new InputManager();

    public GameWindow() {
        initWindow();
        addWindowListener(this);
        addKeyListener(this);
        initBaseController(backbufferGraphics);

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    repaint();
                    planeController.processInput(
                            inputManager.isUpPressed(),
                            inputManager.isDownPressed(),
                            inputManager.isLeftPressed(),
                            inputManager.isRightPressed(),
                            inputManager.isSpacePressed());
                    Thread.sleep(17);
                } catch (InterruptedException ignored) {}
            }
        });

        thread.start();
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
        executeControllers();
        g.drawImage(bufferedImage,0, 0, 600, 1600,null);
    }

    void executeControllers() {
        for (BaseController baseController : ControllersManager.instance.getBaseControllerList()) {
            baseController.onMove(1);
            baseController.onDraw();
        }
    }

    void initWindow() {
        setTitle("Game 1945");
        setVisible(true);
        setSize(600, 800);

        bufferedImage = new BufferedImage(600, 1600, BufferedImage.TYPE_INT_ARGB);
        backbufferGraphics = bufferedImage.getGraphics();
    }

    void initBaseController(Graphics graphics) {
        ControllersManager.instance.addController(createBackgroundController(graphics, -Constant.heightScreen * 2, 0,"res/background1.png"));
        ControllersManager.instance.addController(createBackgroundController(graphics, 0, Constant.heightScreen * 2,"res/background2.png"));
        this.planeController = createPlaneController(graphics, 0, 0,"res/plane2.png", 0);
        this.planeEnemiesController = createPlaneEnemiesController(graphics , 0,0,"res/enemy_plane_white_1.png", 0);

        ControllersManager.instance.addController(planeEnemiesController);
        ControllersManager.instance.addController(planeController);
    }

    BaseController createBackgroundController(Graphics graphics, int defaultOffSetY, int maxOffSet, String imagePath) {
        BackgroundModel backgroundModel = new BackgroundModel(0, defaultOffSetY, Constant.widthScreen, Constant.heightScreen * 2, imagePath, defaultOffSetY, maxOffSet);
        BackgroundView backgroundView = new BackgroundView(backgroundModel, graphics);
        return new BackgroundController(backgroundModel, backgroundView);
    }

    PlaneController createPlaneController(Graphics graphics , int defaultOffsetY , int maxOffset , String imagePath , int maxOffSetx){
        PlaneModel planeModel = new PlaneModel ( 300, 400,32 , 32 ,imagePath , defaultOffsetY , maxOffset,maxOffSetx);
        PlaneView planeView = new PlaneView(planeModel , graphics);
        return new PlaneController(planeModel , planeView);
    }

    PlaneEnemiesController createPlaneEnemiesController(Graphics graphics, int defaultOffsetY, int maxOffset, String imagePath, int maxOffsetx) {
        PlaneEnemiesModel planeEnemiesModel = new PlaneEnemiesModel(20, 80, 32, 32, imagePath, defaultOffsetY, maxOffset, maxOffsetx);
        PlaneEnemiesView planeEnemiesView = new PlaneEnemiesView(planeEnemiesModel, graphics);
        return new PlaneEnemiesController(planeEnemiesModel, planeEnemiesView);
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
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("window closing");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

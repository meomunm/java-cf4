package org.example.scene;

import org.example.utils.GameSceneManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class GameMenuScene extends BaseScene {
    private Graphics backbufferGraphics;

    public GameMenuScene(Graphics backbufferGraphics, Frame frame) {
        this.backbufferGraphics = backbufferGraphics;
        this.frame = frame;
        initScene();
    }

    @Override
    public void initScene() {
        drawGameMenu(backbufferGraphics);
        drawButton(backbufferGraphics);
    }

    @Override
    public void updateScene() {

    }

    @Override
    public void repaint() {

    }

    void drawGameMenu(Graphics graphics) {
        try {
            final Image gameMenuImg = ImageIO.read(new File("res/gamemenu.png"));
            graphics.drawImage(gameMenuImg, 0, 0, 600, 800, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void drawButton(Graphics graphics) {
        try {
            final Image gameMenuImg = ImageIO.read(new File("res/button.png"));

            /// Button 1 - 550
            /// Button 2 - 600
            /// Button 2 - 650

            graphics.drawImage(gameMenuImg, 100, 550, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.frame.removeKeyListener(this);
            GameSceneManager.instance.setBaseScene(new GamePlayScene(backbufferGraphics, frame));
        }
    }
}

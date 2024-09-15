package org.example;

import org.example.scene.BaseScene;
import org.example.scene.GameMenuScene;
import org.example.scene.GamePlayScene;
import org.example.utils.GameSceneManager;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

/**
 * Created by ADMIN on 5/1/2017.
 */
public class GameWindow extends Frame {
    private BufferedImage bufferedImage;

    public GameWindow() {
        initWindow();
        addWindowListener(new WindowListener() {
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
        });

        addKeyListener(GameSceneManager.instance.getBaseScene());

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    repaint();
                    GameSceneManager.instance.getBaseScene().updateScene();
                    Thread.sleep(17);
                } catch (InterruptedException ignored) {}
            }
        });

        thread.start();
    }

    void initWindow() {
        setTitle("Game 1945");
        setVisible(true);
        setSize(600, 800);

        bufferedImage = new BufferedImage(600, 1600, BufferedImage.TYPE_INT_ARGB);
        GameSceneManager.instance.setBaseScene(new GameMenuScene(bufferedImage.getGraphics(), this));
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
        GameSceneManager.instance.getBaseScene().repaint();
        g.drawImage(bufferedImage,0, 0, 600, 1600,null);
    }
}

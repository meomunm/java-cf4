package org.example;

import org.example.controller.BackgroundController;
import org.example.controller.BaseController;
import org.example.model.BackgroundModel;
import org.example.utils.Constant;
import org.example.view.BackgroundView;

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
    private List<BaseController> baseControllers;


    public GameWindow() {
        initWindow();
        addWindowListener(this);
        addKeyListener(this);
        initBaseController(backbufferGraphics);

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    repaint();
                    Thread.sleep(17);
                } catch (InterruptedException ignored) {}
            }
        });

        thread.start();
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
        executeControllers(backbufferGraphics);
        g.drawImage(bufferedImage,0, 0, 600, 1600,null);
    }

    void executeControllers(Graphics backbufferGraphics) {
        for (BaseController baseController : baseControllers) {
            baseController.onMove(Constant.SPEED);
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
        BackgroundModel backgroundModel = new BackgroundModel(0,  0, 600, 1600, "res/background1.png");
        BackgroundView backgroundView = new BackgroundView(backgroundModel, graphics);
        BackgroundController backgroundController = new BackgroundController(backgroundModel, backgroundView);

        this.baseControllers = new ArrayList<>();
        this.baseControllers.add(backgroundController);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

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

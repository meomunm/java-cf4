package org.example.scene;

import java.awt.*;
import java.awt.event.KeyListener;

public abstract class BaseScene implements KeyListener {
    public Frame frame;
    public abstract void initScene();
    public abstract void updateScene();
    public abstract void repaint();
}

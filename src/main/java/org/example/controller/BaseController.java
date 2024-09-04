package org.example.controller;

import org.example.model.BaseModel;
import org.example.view.BaseView;

public abstract class BaseController {
    public BaseModel model;
    public BaseView view;

    public abstract void onMove(int speed);
    public abstract void onDraw();
}

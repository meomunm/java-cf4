package org.example.controller;

import org.example.model.BackgroundModel;
import org.example.model.PlaneModel;
import org.example.utils.Constant;
import org.example.view.BackgroundView;
import org.example.view.PlaneView;

public class PlaneController extends BaseController {
    public PlaneController(PlaneModel planeModel, PlaneView planeView) {
        this.model = planeModel;
        this.view = planeView;
    }

    @Override
    public void onMove(int speed) {

    }

    public void processInput(boolean isUpPressed, boolean isDownPressed, boolean isLeftPressed, boolean isRightPressed) {
        if (isUpPressed) {
            this.model.y -= Constant.SPEED;
        }
        if (isDownPressed) {
            this.model.y += Constant.SPEED;
        }
        if (isLeftPressed) {
            this.model.x -= Constant.SPEED;
        }
        if (isRightPressed) {
            this.model.x += Constant.SPEED;
        }
    }

    @Override
    public void onDraw() {
        try {
            view.onDraw();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

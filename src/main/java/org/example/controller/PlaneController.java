package org.example.controller;

import org.example.model.BackgroundModel;
import org.example.model.PlaneModel;
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

    public void onMove(int speedX, int speedY) {
        this.model.x = this.model.x + speedX;
        this.model.y = this.model.y + speedY;
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

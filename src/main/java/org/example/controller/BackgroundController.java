package org.example.controller;

import org.example.model.BackgroundModel;
import org.example.view.BackgroundView;

public class BackgroundController extends BaseController {
    public BackgroundController(BackgroundModel baseModel, BackgroundView baseView) {
        this.model = baseModel;
        this.view = baseView;
    }

    @Override
    public void onMove(int speed) {
       model.y = model.y + speed;

        System.out.println(model.y);
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

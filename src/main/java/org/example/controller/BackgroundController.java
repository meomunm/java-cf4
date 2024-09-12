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

        if (model.y > ((BackgroundModel) model).maxOffSetY) {
            model.y = ((BackgroundModel) model).defaultOffSetY;
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

    @Override
    public void onCollision(Collider otherCollider) {

    }
}

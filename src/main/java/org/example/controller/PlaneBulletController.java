package org.example.controller;

import org.example.model.PlaneBulletModel;
import org.example.utils.Constant;
import org.example.view.PlaneBulletView;

public class PlaneBulletController extends BaseController {
    public PlaneBulletController(PlaneBulletModel planeBulletModel , PlaneBulletView planeBulletView) {
        this.model = planeBulletModel;
        this.view = planeBulletView;
    }

    @Override
    public void onMove(int speed) {
        this.model.y -= Constant.SPEED;
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

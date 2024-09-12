package org.example.controller;

import org.example.model.PlaneBulletModel;
import org.example.utils.CollisionsManager;
import org.example.utils.Constant;
import org.example.utils.ControllersManager;
import org.example.view.PlaneBulletView;

public class PlaneBulletController extends BaseController implements Collider {
    public PlaneBulletController(PlaneBulletModel planeBulletModel , PlaneBulletView planeBulletView) {
        this.model = planeBulletModel;
        this.view = planeBulletView;

        CollisionsManager.instance.addController(this);
    }

    @Override
    public void onMove(int speed) {
        this.model.y -= Constant.SPEED;

        if (this.model.y <= 0) {
            ControllersManager.instance.removeController(this);
            CollisionsManager.instance.removeController(this);
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
        if (otherCollider instanceof PlaneEnemiesController) {
            ControllersManager.instance.removeController(this);
            CollisionsManager.instance.removeController(this);
        }
    }
}

package org.example.controller;

import org.example.model.PlaneEnemiesModel;
import org.example.utils.CollisionsManager;
import org.example.utils.ControllersManager;
import org.example.view.PlaneEnemiesView;

public class PlaneEnemiesController extends BaseController implements Collider {
    public PlaneEnemiesController(PlaneEnemiesModel planeEnemiesModel , PlaneEnemiesView planeEnemiesView) {
        this.model = planeEnemiesModel;
        this.view = planeEnemiesView;

        CollisionsManager.instance.addController(this);
    }

    @Override
    public void onMove(int speed) {

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
        if (otherCollider instanceof PlaneBulletController) {
            ControllersManager.instance.removeController(this);
            CollisionsManager.instance.removeController(this);
        }
    }
}

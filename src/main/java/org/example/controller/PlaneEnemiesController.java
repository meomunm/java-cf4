package org.example.controller;

import org.example.model.PlaneEnemiesModel;
import org.example.view.PlaneEnemiesView;

public class PlaneEnemiesController extends BaseController {
    public PlaneEnemiesController(PlaneEnemiesModel planeEnemiesModel , PlaneEnemiesView planeEnemiesView) {
        this.model = planeEnemiesModel;
        this.view = planeEnemiesView;
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
}

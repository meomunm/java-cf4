package org.example.controller;

import org.example.model.BackgroundModel;
import org.example.model.PlaneBulletModel;
import org.example.model.PlaneModel;
import org.example.utils.Constant;
import org.example.utils.ControllersManager;
import org.example.view.BackgroundView;
import org.example.view.PlaneBulletView;
import org.example.view.PlaneView;

import java.awt.*;

public class PlaneController extends BaseController {
    public PlaneController(PlaneModel planeModel, PlaneView planeView) {
        this.model = planeModel;
        this.view = planeView;
    }

    @Override
    public void onMove(int speed) {

    }

    public void processInput(boolean isUpPressed, boolean isDownPressed, boolean isLeftPressed, boolean isRightPressed, boolean isSpacePressed) {
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
        if (isSpacePressed && view instanceof PlaneView) {
            //Mark: Bắn ra đạn nếu nhấn phím space
            final Graphics graphics = ((PlaneView) view).graphics;

            PlaneBulletController bulletController = createPlaneBulletController(graphics,"res/bullet-single.png");
            ControllersManager.instance.addController(bulletController);
        }
    }

    private PlaneBulletController createPlaneBulletController(Graphics graphics, String imagePath) {
        final int offsetX = this.model.x + 12;
        final int offsetY = this.model.y;

        PlaneBulletModel planeBulletModel = new PlaneBulletModel(offsetX, offsetY, 9, 20, imagePath);
        PlaneBulletView planeBulletView = new PlaneBulletView(planeBulletModel, graphics);
        return new PlaneBulletController(planeBulletModel, planeBulletView);
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

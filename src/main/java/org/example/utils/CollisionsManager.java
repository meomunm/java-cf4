package org.example.utils;

import org.example.controller.BaseController;
import org.example.controller.Collider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CollisionsManager {
    private final List<Collider> colliders;

    public static final CollisionsManager instance = new CollisionsManager();

    private CollisionsManager() {
        colliders = new ArrayList<>();
    }

    public void runCheckingCollisions() {
        for (int colliderIndex = 0; colliderIndex < colliders.size() - 1; colliderIndex++) {
            for (int colliderOtherIndex = 1; colliderOtherIndex < colliders.size(); colliderOtherIndex++) {
                System.out.println("Collision Starting detected");
                final Collider collider = colliders.get(colliderIndex);
                final Collider otherCollider = colliders.get(colliderOtherIndex);
                final BaseController baseController = (BaseController) collider;
                final BaseController otherBaseController = (BaseController) otherCollider;

                Rectangle rectangle = new Rectangle(baseController.model.x, baseController.model.y, baseController.model.width, baseController.model.height);
                Rectangle otherRectangle = new Rectangle(otherBaseController.model.x, otherBaseController.model.y, otherBaseController.model.width, otherBaseController.model.height);

                if (rectangle.intersects(otherRectangle)) {
                    System.out.println("Collision Detected");
                    collider.onCollision(otherCollider);
                    otherCollider.onCollision(collider);
                }
            }
        }
    }

    public void addController(Collider controller) {
        System.out.println("Adding collider " + controller);
        colliders.add(controller);
    }

    public void removeController(Collider controller) {
        colliders.remove(controller);
    }
}
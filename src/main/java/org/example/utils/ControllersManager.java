package org.example.utils;

import org.example.controller.BaseController;

import java.util.ArrayList;
import java.util.List;

public class ControllersManager {
    private final List<BaseController> baseControllerList;

    public static final ControllersManager instance = new ControllersManager();

    private ControllersManager() {
        baseControllerList = new ArrayList<>();
    }

    public List<BaseController> getBaseControllerList() {
        return baseControllerList;
    }

    public void addController(BaseController controller) {
        baseControllerList.add(controller);
    }

    public void removeController(BaseController controller) {
        baseControllerList.remove(controller);
    }
}

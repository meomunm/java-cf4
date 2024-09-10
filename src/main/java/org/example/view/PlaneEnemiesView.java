package org.example.view;

import org.example.controller.PlaneEnemiesController;
import org.example.model.PlaneEnemiesModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PlaneEnemiesView extends BaseView{
    public Graphics graphics;
    public PlaneEnemiesView(PlaneEnemiesModel baseModel , Graphics graphics) {
        this.baseModel = baseModel;
        this.graphics = graphics;
    }

    @Override
    public void onDraw() throws IOException {
        Image img = ImageIO.read(new File(this.baseModel.imagePath));

        int x = this.baseModel.x;
        int y = this.baseModel.y ;
        int width = this.baseModel.width;
        int height = this.baseModel.height;

        graphics.drawImage(img, x, y, width, height,null);
    }
}

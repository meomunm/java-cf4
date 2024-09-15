package org.example.view;

import org.example.controller.PlaneEnemiesController;
import org.example.model.PlaneEnemiesModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PlaneEnemiesView extends BaseView{
    public Graphics graphics;
    ArrayList<String> imgAnimation = new ArrayList<String>();
    int indexDraw = 0;

    public PlaneEnemiesView(PlaneEnemiesModel baseModel , Graphics graphics) {
        this.baseModel = baseModel;
        this.graphics = graphics;

        imgAnimation.add("res/enemy_plane_white_1.png");
        imgAnimation.add("res/enemy_plane_white_2.png");
        imgAnimation.add("res/enemy_plane_white_3.png");
    }

    @Override
    public void onDraw() throws IOException {
        Image img = ImageIO.read(new File(imgAnimation.get(indexDraw)));

        int x = this.baseModel.x;
        int y = this.baseModel.y ;
        int width = this.baseModel.width;
        int height = this.baseModel.height;

        graphics.drawImage(img, x, y, width, height,null);
        indexDraw++;

        if (indexDraw == 2) {
            indexDraw = 0;
        }
    }
}

package org.example.model;

public class BackgroundModel extends BaseModel{
    public BackgroundModel(int x, int y, int width, int height, String imagePath, int defaultOffSetY, int maxOffSetY) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.imagePath = imagePath;
        this.defaultOffSetY = defaultOffSetY;
        this.maxOffSetY = maxOffSetY;
    }

    public int defaultOffSetY;
    public int maxOffSetY;
}

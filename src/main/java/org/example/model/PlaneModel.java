package org.example.model;

public class PlaneModel extends BaseModel{
    public PlaneModel(int x, int y, int width, int height, String imagePath, int defaultOffSetY, int maxOffSetY, int maxOffSetX) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.imagePath = imagePath;
        this.defaultOffSetY = defaultOffSetY;
        this.maxOffSetY = maxOffSetY;
        this.maxOffSetX = maxOffSetX;
    }

    public int defaultOffSetY;
    public int maxOffSetY;
    public int maxOffSetX;
}

package com.smallert.gamebody;

import java.awt.*;

public abstract class GameObject {
    /**
     * 物体的位置
     */
    protected int positionX;
    protected int positionY;
    protected int width;
    protected int height;
    protected Rectangle rectangle;
    protected boolean isLiving;
    protected GameModule gm = GameModule.getInstance();

    public GameObject(int positionX, int positionY, int width, int height, boolean isLiving) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.width = width;
        this.height = height;
        this.isLiving = isLiving;
        this.rectangle = new Rectangle(positionX,positionY,width,height);
    }

    public abstract void pain(Graphics g);
}

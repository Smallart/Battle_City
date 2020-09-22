package com.smallert.gamebody;

import lombok.Data;

import java.awt.*;
@Data
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

    public GameObject(int positionX, int positionY, boolean isLiving) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.isLiving = isLiving;
    }

    public abstract void paint(Graphics g);

    public abstract void destroy();

}

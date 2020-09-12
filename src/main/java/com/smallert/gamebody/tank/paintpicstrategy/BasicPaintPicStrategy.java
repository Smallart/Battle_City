package com.smallert.gamebody.tank.paintpicstrategy;

import com.smallert.gamebody.tank.TankObject;

import java.awt.*;

/**
 * 为不同的坦克绘制不同的图片
 */
public interface BasicPaintPicStrategy {
    void paintTankPic(Graphics g, TankObject tankObject);
}

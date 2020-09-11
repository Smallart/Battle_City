package com.smallert.gamebody.tank;

import com.smallert.commond.Direction;
import com.smallert.commond.Group;

import java.awt.*;

/**
 * 敌方坦克
 */
public class EnemyTank extends TankObject{

    public EnemyTank(int positionX, int positionY, int width, int height, int speed, Group group, boolean isLiving, Direction dir) {
        super(positionX, positionY, width, height, speed, group, isLiving, dir);
    }

    @Override
    public void pain(Graphics p) {

    }
}

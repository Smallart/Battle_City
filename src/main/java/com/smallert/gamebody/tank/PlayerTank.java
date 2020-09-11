package com.smallert.gamebody.tank;

import com.smallert.commond.Direction;
import com.smallert.commond.Group;
import com.smallert.gamebody.GameModule;
import com.smallert.utils.ImgLoadUtil;

import java.awt.*;

/**
 * 玩家坦克
 */
public class PlayerTank extends TankObject{

    public PlayerTank(int positionX, int positionY, int width, int height, int speed, Group group, boolean isLiving, Direction dir) {
        super(positionX, positionY, width, height, speed, group, isLiving, dir);
        GameModule.getInstance().getPlayerTanks().add(this);
    }

    @Override
    public void pain(Graphics g) {
        if (!isLiving) return;
        move();
        switch (dir){
            case UP:
                g.drawImage(ImgLoadUtil.Player1TankU,positionX,positionY,null);
                break;
            case LEFT:
                g.drawImage(ImgLoadUtil.Player1TankL,positionX,positionY,null);
                break;
            case RIGHT:
                g.drawImage(ImgLoadUtil.Player1TankR,positionX,positionY,null);
                break;
            case DOWN:
                g.drawImage(ImgLoadUtil.Player1TankD,positionX,positionY,null);
                break;
        }
    }
}

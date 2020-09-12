package com.smallert.gamebody.tank;

import com.smallert.common.Direction;
import com.smallert.common.Group;
import com.smallert.gamebody.explosion.Explosion;
import com.smallert.utils.ImgLoadUtil;

import java.awt.*;

/**
 * 玩家坦克
 */
public class PlayerTank extends TankObject{

    public PlayerTank(int positionX, int positionY, int width, int height, int speed, Group group, boolean isLiving, Direction dir,boolean isGift) {
        super(positionX, positionY, width, height, speed, group, isLiving, dir,isGift);
        gm.getPlayerTanks().add(this);
    }

    @Override
    public void paint(Graphics g) {
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

    @Override
    public void destroy() {
        if (Integer.parseInt(gm.getLifeNum())<0){
            this.isLiving=false;
            gm.getPlayerTanks().remove(this);
        }
        gm.getGameBodyList().remove(this);
        //添加爆炸
        gm.getGameBodyList().add(new Explosion(positionX,positionY,0,0,true));
    }
}

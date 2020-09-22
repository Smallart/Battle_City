package com.smallert.gamebody.tank;

import com.smallert.common.Direction;
import com.smallert.common.GameObjectType;
import com.smallert.common.Group;
import com.smallert.gamebody.Audio;
import com.smallert.gamebody.GameObjectSimpleFactory;
import com.smallert.gamebody.otherobject.Explosion;
import com.smallert.utils.AudioUtil;
import com.smallert.utils.ImgLoadUtil;

import java.awt.*;

/**
 * 玩家坦克
 */
public class PlayerTank extends TankObject{

    public PlayerTank(int positionX, int positionY, int speed, Group group, boolean isLiving, Direction dir,boolean isGift) {
        super(positionX, positionY, speed, group, isLiving, dir,isGift);
        this.width = ImgLoadUtil.Player1TankD.getWidth();
        this.height = ImgLoadUtil.Player1TankD.getHeight();
        this.rectangle = new Rectangle(positionX,positionY,width,height);
        gm.getPlayerTanks().add(this);
        gm.getGameBodyList().add(this);
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
        gm.getGameBodyList().add(GameObjectSimpleFactory.createExplosion(positionX,positionY,false, GameObjectType.Tank));
        AudioUtil.ExplosionAudio();
    }
}

package com.smallert.gamebody.tank;

import com.smallert.common.Direction;
import com.smallert.common.EnemyTankType;
import com.smallert.common.Group;
import com.smallert.gamebody.explosion.Explosion;
import com.smallert.gamebody.gift.Gift;
import com.smallert.gamebody.tank.paintpicstrategy.BasicPaintPicStrategy;
import com.smallert.gamebody.tank.paintpicstrategy.impl.PaintEnemySpeedTank;
import com.smallert.utils.ImgLoadUtil;

import java.awt.*;

/**
 * 敌方坦克
 */
public class EnemyTank extends TankObject{
    /**
     * 坦克类型
     */
    private EnemyTankType tankType;

    public EnemyTank(int positionX, int positionY, int width, int height, int speed, Group group, boolean isLiving, Direction dir,EnemyTankType tankType,boolean isGift) {
        super(positionX, positionY, width, height, speed, group, isLiving, dir,isGift);
        this.tankType = tankType;
        //能力提升
        powerUp();
        gm.getGameBodyList().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (!isLiving) return;
        move();
        /**
         * todo 这里可以用反射去掉switch
         */
        BasicPaintPicStrategy paintPicStrategy=null;
        switch (tankType){
            case COMMON:
                break;
            case SPEEDTYPE:
                paintPicStrategy = new PaintEnemySpeedTank();
                break;
            case DEFENSIVE:
                break;
        }
        paintPicStrategy.paintTankPic(g,this);
    }

    @Override
    public void destroy() {
        this.isLiving=false;
        gm.getGameBodyList().remove(this);
        //添加爆炸
        gm.getGameBodyList().add(new Explosion(positionX,positionY,0,0,true));
        //如果是奖励坦克掉落奖励
        if (isGift){
            /**
             * todo 之后修改为随机出现
             */
            new Gift(positionX,positionY, ImgLoadUtil.GameObjectTypes[0].getWidth(),ImgLoadUtil.GameObjectTypes[0].getHeight(),true,200);
        }
    }

    /**
     * 对于不同的敌方坦克进行相对应的能力提升
     */
    private void powerUp(){
        switch (tankType){
            case SPEEDTYPE:
                speed+=4;
                break;
            case DEFENSIVE:
                armorGrade+=3;
                break;
        }
    }
}

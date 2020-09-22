package com.smallert.gamebody.tank;

import com.smallert.common.Direction;
import com.smallert.common.EnemyTankType;
import com.smallert.common.GameObjectType;
import com.smallert.common.Group;
import com.smallert.gamebody.GameObjectSimpleFactory;
import com.smallert.gamebody.gift.Gift;
import com.smallert.gamebody.tank.paintpicstrategy.BasicPaintPicStrategy;
import com.smallert.gamebody.tank.paintpicstrategy.impl.PaintEnemyArmorTank;
import com.smallert.gamebody.tank.paintpicstrategy.impl.PaintEnemySpeedTank;
import com.smallert.utils.AudioUtil;
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

    public EnemyTank(int positionX, int positionY, int speed, Group group, boolean isLiving, Direction dir,EnemyTankType tankType,boolean isGift) {
        super(positionX, positionY, speed, group, isLiving, dir,isGift);
        this.tankType = tankType;
        setWidthAndHeight();
        this.rectangle = new Rectangle(positionX,positionY,width,height);
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
                paintPicStrategy = new PaintEnemyArmorTank();
                break;
        }
        paintPicStrategy.paintTankPic(g,this);
    }

    @Override
    public void destroy() {
        if (armorGrade<0){
            this.isLiving=false;
            gm.getGameBodyList().remove(this);
            //添加爆炸
            gm.getGameBodyList().add(GameObjectSimpleFactory.createExplosion(positionX,positionY,false, GameObjectType.Tank));
            //如果是奖励坦克掉落奖励
            AudioUtil.ExplosionAudio();
        }
        if (isGift){
            /**
             * todo 之后修改为随机出现
             */
            new Gift(positionX,positionY,true,200);
            this.isGift = false;
        }
    }

    /**
     * 对于不同的敌方坦克进行相对应的能力提升
     */
    private void powerUp(){
        switch (tankType){
            case SPEEDTYPE:
                speed+=4;
                preSpeed=speed;
                break;
            case DEFENSIVE:
                armorGrade+=2;
                break;
        }
    }

    /**
     * 设置坦克的宽和高
     */
    private void setWidthAndHeight(){
        switch (tankType){
            case COMMON:
                this.width = ImgLoadUtil.EnemyTank_Common_Pic[0].getWidth();
                this.height = ImgLoadUtil.EnemyTank_Common_Pic[0].getHeight();
                break;
            case SPEEDTYPE:
                this.width = ImgLoadUtil.EnemyTank_Speed_Pic[0].getWidth();
                this.height = ImgLoadUtil.EnemyTank_Speed_Pic[0].getHeight();
                break;
            case DEFENSIVE:
                this.width = ImgLoadUtil.EnemyTank_Armor_Pic[0].getWidth();
                this.height = ImgLoadUtil.EnemyTank_Armor_Pic[0].getHeight();
                break;
        }
    }

    public static int getPicWidth(EnemyTankType enemyTankType){
        int width = 0;
        switch (enemyTankType){
            case COMMON:
                width = ImgLoadUtil.EnemyTank_Common_Pic[0].getWidth();
                break;
            case SPEEDTYPE:
                width = ImgLoadUtil.EnemyTank_Speed_Pic[0].getWidth();
                break;
            case DEFENSIVE:
                width = ImgLoadUtil.EnemyTank_Armor_Pic[0].getWidth();
                break;
        }
        return width;
    }

    public static int getPicHeight(EnemyTankType enemyTankType){
        int height = 0;
        switch (enemyTankType){
            case COMMON:
                height = ImgLoadUtil.EnemyTank_Common_Pic[0].getHeight();
                break;
            case SPEEDTYPE:
                height = ImgLoadUtil.EnemyTank_Speed_Pic[0].getHeight();
                break;
            case DEFENSIVE:
                height = ImgLoadUtil.EnemyTank_Armor_Pic[0].getHeight();
                break;
        }
        return height;
    }
}

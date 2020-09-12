package com.smallert.gamebody.tank.paintpicstrategy.impl;

import com.smallert.gamebody.tank.TankObject;
import com.smallert.gamebody.tank.paintpicstrategy.BasicPaintPicStrategy;
import com.smallert.utils.ImgLoadUtil;

import java.awt.*;

/**
 * 绘制突进
 */
public class PaintEnemySpeedTank implements BasicPaintPicStrategy {
    @Override
    public void paintTankPic(Graphics g, TankObject tankObject) {
        /**
         * 判断是不是奖励坦克是的话进行闪烁
         */
        if (tankObject.isGift()){
            if (Math.random()>0.5){
                g.drawImage(ImgLoadUtil.EnemyTank_Speed_Pic[tankObject.getDir().ordinal()],tankObject.getPositionX(),tankObject.getPositionY(),null);
            }else {
                g.drawImage(ImgLoadUtil.EnemyTank_Gift_Speed_Pic[tankObject.getDir().ordinal()],tankObject.getPositionX(),tankObject.getPositionY(),null);
            }
        }else{
            g.drawImage(ImgLoadUtil.EnemyTank_Speed_Pic[tankObject.getDir().ordinal()],tankObject.getPositionX(),tankObject.getPositionY(),null);
        }
    }
}

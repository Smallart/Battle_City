package com.smallert.gamebody.tank.paintpicstrategy.impl;

import com.smallert.gamebody.tank.TankObject;
import com.smallert.gamebody.tank.paintpicstrategy.BasicPaintPicStrategy;
import com.smallert.utils.ImgLoadUtil;

import java.awt.*;

/**
 * 护甲型坦克图片绘制
 */
public class PaintEnemyArmorTank implements BasicPaintPicStrategy {
    @Override
    public void paintTankPic(Graphics g, TankObject tankObject) {

        if (tankObject.isGift()){
            if (Math.random()>0.5){
                g.drawImage(ImgLoadUtil.EnemyTank_Gift_Armor_Red_Pic[tankObject.getDir().ordinal()],tankObject.getPositionX(),tankObject.getPositionY(),null);
            }else {
                paintDetail(g,tankObject);
            }
        }else {
            paintDetail(g,tankObject);
        }
    }
    //根据不同护甲显示不同的颜色
    private void paintDetail(Graphics g,TankObject tankObject){
        switch (tankObject.getArmorGrade()){
            case 0:
                g.drawImage(ImgLoadUtil.EnemyTank_Armor_Pic[tankObject.getDir().ordinal()],tankObject.getPositionX(),tankObject.getPositionY(),null);
                break;
            case 1:
                g.drawImage(ImgLoadUtil.EnemyTank_Gift_Armor_Yellow_Pic[tankObject.getDir().ordinal()],tankObject.getPositionX(),tankObject.getPositionY(),null);
                break;
            case 2:
                g.drawImage(ImgLoadUtil.EnemyTank_Gift_Armor_Green_Pic[tankObject.getDir().ordinal()],tankObject.getPositionX(),tankObject.getPositionY(),null);
                break;
        }
    }
}

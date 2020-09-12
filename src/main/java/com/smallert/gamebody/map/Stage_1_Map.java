package com.smallert.gamebody.map;

import com.smallert.common.Direction;
import com.smallert.common.EnemyTankType;
import com.smallert.common.Group;
import com.smallert.gamebody.tank.EnemyTank;
import com.smallert.utils.ImgLoadUtil;
import com.smallert.utils.PropertyUtil;

import java.awt.*;

public class Stage_1_Map extends StageGameMap {

    /**
     * 使用地图构造函数来初始化一些物体
     */
    public Stage_1_Map(){
        new EnemyTank(Integer.parseInt((String) PropertyUtil.get("enemyBirth2X")),Integer.parseInt((String) PropertyUtil.get("enemyBirthY")),
                ImgLoadUtil.EnemyTank_Speed_Pic[0].getWidth(),ImgLoadUtil.EnemyTank_Speed_Pic[0].getHeight(),8, Group.RED,true, Direction.DOWN, EnemyTankType.SPEEDTYPE,true);
    }

    @Override
    public void paintStage(Graphics g) {

    }
}

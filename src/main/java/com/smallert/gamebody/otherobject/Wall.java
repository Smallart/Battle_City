package com.smallert.gamebody.otherobject;

import com.smallert.common.GameObjectType;
import com.smallert.gamebody.GameObject;
import com.smallert.utils.ImgLoadUtil;
import lombok.Data;

import java.awt.*;

/**
 * 游戏中的墙体
 */
@Data
public class Wall extends GameObject {

    private GameObjectType wallType;
    private int armorGrade;

    public Wall(int positionX, int positionY, int width, int height, boolean isLiving,GameObjectType wallType,int armorGrade) {
        super(positionX, positionY, width, height, isLiving);
        this.wallType = wallType;
        this.armorGrade = armorGrade;
        gm.getGameBodyList().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (!isLiving) return;
        switch (wallType){
            case BrickWall:
                g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.BrickWall.ordinal()],positionX,positionY,null);
                break;
            case VerticalBrickWall:
                g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.VerticalBrickWall.ordinal()],positionX,positionY,null);
                break;
            case SpotBrickWall:
                g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.SpotBrickWall.ordinal()],positionX,positionY,null);
                break;
            case IronWall:
                g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.IronWall.ordinal()],positionX,positionY,null);
                break;
            case VerticalIronWall:
                g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.VerticalIronWall.ordinal()],positionX,positionY,null);
                break;
            case TransverseIronWall:
                g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.TransverseIronWall.ordinal()],positionX,positionY,null);
                break;
        }
    }

    @Override
    public void destroy() {
        isLiving =false;
        gm.getGameBodyList().remove(this);
    }
}

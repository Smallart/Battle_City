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

    public Wall(int positionX, int positionY, boolean isLiving,GameObjectType wallType,int armorGrade) {
        super(positionX, positionY, isLiving);
        this.wallType = wallType;
        this.armorGrade = armorGrade;
        initWidthAndHeight();
        this.rectangle = new Rectangle(positionX,positionY,width,height);
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

    private void initWidthAndHeight(){
        switch (wallType){
            case BrickWall:
                width = ImgLoadUtil.GameObjectTypes[GameObjectType.BrickWall.ordinal()].getWidth();
                height = ImgLoadUtil.GameObjectTypes[GameObjectType.BrickWall.ordinal()].getHeight();
                break;
            case VerticalBrickWall:
                width = ImgLoadUtil.GameObjectTypes[GameObjectType.VerticalBrickWall.ordinal()].getWidth();
                height = ImgLoadUtil.GameObjectTypes[GameObjectType.VerticalBrickWall.ordinal()].getHeight();
                break;
            case SpotBrickWall:
                width = ImgLoadUtil.GameObjectTypes[GameObjectType.SpotBrickWall.ordinal()].getWidth();
                height = ImgLoadUtil.GameObjectTypes[GameObjectType.SpotBrickWall.ordinal()].getHeight();
                break;
            case IronWall:
                width = ImgLoadUtil.GameObjectTypes[GameObjectType.IronWall.ordinal()].getWidth();
                height = ImgLoadUtil.GameObjectTypes[GameObjectType.IronWall.ordinal()].getHeight();
                break;
            case VerticalIronWall:
                width = ImgLoadUtil.GameObjectTypes[GameObjectType.VerticalIronWall.ordinal()].getWidth();
                height = ImgLoadUtil.GameObjectTypes[GameObjectType.VerticalIronWall.ordinal()].getHeight();
                break;
            case TransverseIronWall:
                width = ImgLoadUtil.GameObjectTypes[GameObjectType.TransverseIronWall.ordinal()].getWidth();
                height = ImgLoadUtil.GameObjectTypes[GameObjectType.TransverseIronWall.ordinal()].getHeight();
                break;
        }
    }
    public static int getPicWidth(GameObjectType wallType){
        int width = 0;
        switch (wallType){
            case BrickWall:
                width = ImgLoadUtil.GameObjectTypes[GameObjectType.BrickWall.ordinal()].getWidth();
                break;
            case VerticalBrickWall:
                width = ImgLoadUtil.GameObjectTypes[GameObjectType.VerticalBrickWall.ordinal()].getWidth();
                break;
            case SpotBrickWall:
                width = ImgLoadUtil.GameObjectTypes[GameObjectType.SpotBrickWall.ordinal()].getWidth();
                break;
            case IronWall:
                width = ImgLoadUtil.GameObjectTypes[GameObjectType.IronWall.ordinal()].getWidth();
                break;
            case VerticalIronWall:
                width = ImgLoadUtil.GameObjectTypes[GameObjectType.VerticalIronWall.ordinal()].getWidth();
                break;
            case TransverseIronWall:
                width = ImgLoadUtil.GameObjectTypes[GameObjectType.TransverseIronWall.ordinal()].getWidth();
                break;
        }
        return width;
    }

    public static int getPicHeight(GameObjectType wallType){
        int height = 0;
        switch (wallType){
            case BrickWall:
                height = ImgLoadUtil.GameObjectTypes[GameObjectType.BrickWall.ordinal()].getHeight();
                break;
            case VerticalBrickWall:
                height = ImgLoadUtil.GameObjectTypes[GameObjectType.VerticalBrickWall.ordinal()].getHeight();
                break;
            case SpotBrickWall:
                height = ImgLoadUtil.GameObjectTypes[GameObjectType.SpotBrickWall.ordinal()].getHeight();
                break;
            case IronWall:
                height = ImgLoadUtil.GameObjectTypes[GameObjectType.IronWall.ordinal()].getHeight();
                break;
            case VerticalIronWall:
                height = ImgLoadUtil.GameObjectTypes[GameObjectType.VerticalIronWall.ordinal()].getHeight();
                break;
            case TransverseIronWall:
                height = ImgLoadUtil.GameObjectTypes[GameObjectType.TransverseIronWall.ordinal()].getHeight();
                break;
        }
        return height;
    }
}

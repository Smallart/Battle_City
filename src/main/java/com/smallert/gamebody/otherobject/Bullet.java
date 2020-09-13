package com.smallert.gamebody.otherobject;

import com.smallert.common.Direction;
import com.smallert.common.Group;
import com.smallert.gamebody.GameModule;
import com.smallert.gamebody.GameObject;
import com.smallert.gui.GameFrame;
import com.smallert.utils.ImgLoadUtil;
import lombok.Data;

import java.awt.*;

/**
 * 子弹类
 */
@Data
public class Bullet extends GameObject {

    private Direction dir;
    private int speed;
    private Group group;

    public Bullet(int positionX, int positionY, int width, int height, boolean isLiving,Direction dir,int speed,Group group) {
        super(positionX, positionY, width, height, isLiving);
        this.dir = dir;
        this.speed = speed;
        this.group = group;
        gm.getGameBodyList().add(this);
    }

    @Override
    public void paint(Graphics g) {
        move();
        if (!isLiving){
            GameModule.getInstance().getGameBodyList().remove(this);
            return;
        }
        switch (dir){
            case UP:
                g.drawImage(ImgLoadUtil.BulletU,positionX,positionY,null);
                break;
            case LEFT:
                g.drawImage(ImgLoadUtil.BulletL,positionX,positionY,null);
                break;
            case RIGHT:
                g.drawImage(ImgLoadUtil.BulletR,positionX,positionY,null);
                break;
            case DOWN:
                g.drawImage(ImgLoadUtil.BulletD,positionX,positionY,null);
                break;
        }
    }

    @Override
    public void destroy() {
        this.isLiving=false;
        gm.getGameBodyList().remove(this);
    }

    private void move(){
        switch (dir){
            case RIGHT:
                positionX+=speed;
                break;
            case UP:
                positionY-=speed;
                break;
            case LEFT:
                positionX-=speed;
                break;
            case DOWN:
                positionY+=speed;
                break;
        }
        updateRectangle();
        if (checkIfCrossTheBorder()){
            this.isLiving = false;
        }
    }

    /**
     * 检测是否越界
     */
    private boolean checkIfCrossTheBorder(){
        boolean flag =false;
        switch (dir){
            case DOWN:
                if(positionY+height> GameFrame.ACTUAL_GAME_BOUNDARY_D){
                    flag = true;
                }
                break;
            case LEFT:
                if(positionX< GameFrame.ACTUAL_GAME_BOUNDARY_L){
                    flag = true;
                }
                break;
            case UP:
                if (positionY< GameFrame.ACTUAL_GAME_BOUNDARY_U){
                    flag = true;
                }
                break;
            case RIGHT:
                if (positionX+height>GameFrame.ACTUAL_GAME_BOUNDARY_R){
                    flag = true;
                }
                break;
        }
        return flag;
    }

    private void updateRectangle(){
        rectangle.x = positionX;
        rectangle.y = positionY;
    }
}

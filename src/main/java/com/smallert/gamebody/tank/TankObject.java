package com.smallert.gamebody.tank;

import com.smallert.commond.Direction;
import com.smallert.commond.Group;
import com.smallert.gamebody.GameModule;
import com.smallert.gamebody.GameObject;
import com.smallert.gamebody.bullet.Bullet;
import com.smallert.gui.GameFrame;
import com.smallert.utils.ImgLoadUtil;
import lombok.Data;

@Data
public abstract class TankObject extends GameObject {
    protected int speed;
    protected Direction dir;
    protected boolean isMoving=false;
    protected Group group;
    public boolean dirDown,dirUp,dirLeft,dirRight;

    public TankObject(int positionX, int positionY, int width, int height,int speed,Group group,boolean isLiving,Direction dir) {
        super(positionX, positionY, width, height,isLiving);
        this.speed = speed;
        this.group = group;
        this.dir = dir;
    }

    public void move(){
        if (!isMoving) return;
        changeDir();
        if (ifCrossTheBorder()) return;
        switch (dir){
            case UP:
                positionY-=speed;
                break;
            case RIGHT:
                positionX+=speed;
                break;
            case DOWN:
                positionY+=speed;
                break;
            case LEFT:
                positionX-=speed;
                break;
        }
    }

    public void changeDir(){
        if (dirUp) dir = Direction.UP;
        if (dirLeft) dir = Direction.LEFT;
        if (dirDown) dir = Direction.DOWN;
        if (dirRight) dir =Direction.RIGHT;
    }

    public boolean ifCrossTheBorder(){
        boolean flag = false;
        switch (dir){
            case DOWN:
                if(positionY+width+speed> GameFrame.ACTUAL_GAME_BOUNDARY_D){
                    flag = true;
                }
                break;
            case LEFT:
                if(positionX - speed < GameFrame.ACTUAL_GAME_BOUNDARY_L){
                    flag = true;
                }
                break;
            case UP:
                if (positionY - speed< GameFrame.ACTUAL_GAME_BOUNDARY_U){
                    flag = true;
                }
                break;
            case RIGHT:
                if (positionX+speed+width>GameFrame.ACTUAL_GAME_BOUNDARY_R){
                    flag = true;
                }
                break;
        }
        return flag;
    }

    public void fire(){
        int x = 0;
        int y = 0;
        switch (dir){
            case UP:
                x = positionX+(width-ImgLoadUtil.BulletD.getWidth())/2;
                y = positionY-ImgLoadUtil.BulletD.getHeight();
                break;
            case LEFT:
                x = positionX;
                y = positionY+(width-ImgLoadUtil.BulletD.getWidth())/2;
                break;
            case DOWN:
                x = positionX+(width-ImgLoadUtil.BulletD.getWidth())/2;
                y = positionY+height;
                break;
            case RIGHT:
                x = positionX + height;
                y = positionY+(width-ImgLoadUtil.BulletD.getWidth())/2;
                break;
        }
        new Bullet(x,y,ImgLoadUtil.BulletD.getWidth(),ImgLoadUtil.BulletU.getHeight(),true,dir,10);
    }

}

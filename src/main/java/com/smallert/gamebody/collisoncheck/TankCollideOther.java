package com.smallert.gamebody.collisoncheck;

import com.smallert.gamebody.GameObject;
import com.smallert.gamebody.tank.TankObject;

public class TankCollideOther implements BasicCollisionInter {
    @Override
    public boolean collide(GameObject gameOne, GameObject gameTwo) {
        if (gameOne instanceof TankObject){
            TankObject tankObject = (TankObject) gameOne;
            if (gameOne.getRectangle().contains(gameTwo.getRectangle())){
                tankObject.setMoving(false);
            }else if (!(gameOne instanceof TankObject)&&(gameTwo instanceof TankObject)){
                collide(gameTwo,gameOne);
            }
            return true;
        }
        return false;
    }
}

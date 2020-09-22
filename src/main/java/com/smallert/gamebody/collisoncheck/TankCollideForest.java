package com.smallert.gamebody.collisoncheck;

import com.smallert.gamebody.GameObject;
import com.smallert.gamebody.otherobject.Forest;
import com.smallert.gamebody.tank.TankObject;

public class TankCollideForest implements BasicCollisionInter{

    @Override
    public boolean collide(GameObject gameOne, GameObject gameTwo) {
        if (gameOne instanceof TankObject && gameTwo instanceof Forest){
            return false;
        }else if (gameTwo instanceof TankObject && gameOne instanceof Forest){
            collide(gameTwo,gameOne);
        }
        return true;
    }
}

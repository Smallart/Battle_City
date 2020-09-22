package com.smallert.gamebody.collisoncheck;

import com.smallert.common.Group;
import com.smallert.gamebody.GameObject;
import com.smallert.gamebody.gift.Gift;
import com.smallert.gamebody.tank.TankObject;
import com.smallert.utils.AudioUtil;

public class TankCollideGift implements BasicCollisionInter{
    @Override
    public boolean collide(GameObject gameOne, GameObject gameTwo) {
        if (gameOne instanceof TankObject && gameTwo instanceof Gift){
          TankObject tankObject = (TankObject)gameOne;
          Gift gift = (Gift)gameTwo;
            if (tankObject.getGroup()== Group.BLUE&&tankObject.getRectangle().intersects(gift.getRectangle())){
                gift.destroy();
                AudioUtil.powerUpPick();
            }
            return false;
        }else if (gameTwo instanceof TankObject && gameOne instanceof Gift){
            collide(gameTwo,gameOne);
        }
        return true;
    }
}

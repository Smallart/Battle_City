package com.smallert.gamebody.otherobject;

import com.smallert.gamebody.GameObject;
import com.smallert.utils.ImgLoadUtil;

import java.awt.*;

public class Explosion extends GameObject {

    public Explosion(int positionX, int positionY, int width, int height, boolean isLiving) {
        super(positionX, positionY, width, height, isLiving);
        gm.getGameBodyList().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (!isLiving) destroy();
        int tankCenterX=positionX+ImgLoadUtil.EnemyTank_Common_Pic[0].getWidth()/2;
        int tankCenterY=positionY+ImgLoadUtil.EnemyTank_Common_Pic[0].getHeight()/2;
        for (int i = 0; i < ImgLoadUtil.Explosions.length; i++) {
            if (i>2&&i<=4||i>8){
                for (int j = 0; j <1 ; j++) {
                    g.drawImage(ImgLoadUtil.Explosions[i],tankCenterX-ImgLoadUtil.Explosions[i].getWidth()/2,tankCenterY-ImgLoadUtil.Explosions[i].getHeight()/2,null);
                }
            }
            if (i>4&&i<=8){
                for (int j = 0; j <2 ; j++) {
                    g.drawImage(ImgLoadUtil.Explosions[i],tankCenterX-ImgLoadUtil.Explosions[i].getWidth()/2,tankCenterY-ImgLoadUtil.Explosions[i].getHeight()/2,null);
                }
            }
            g.drawImage(ImgLoadUtil.Explosions[i],tankCenterX-ImgLoadUtil.Explosions[i].getWidth()/2,tankCenterY-ImgLoadUtil.Explosions[i].getHeight()/2,null);
        }
        isLiving = false;
    }

    @Override
    public void destroy() {
        gm.getGameBodyList().remove(this);
    }
}

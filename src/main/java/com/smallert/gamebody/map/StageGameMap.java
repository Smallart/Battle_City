package com.smallert.gamebody.map;

import com.smallert.common.GameObjectType;
import com.smallert.gamebody.GameModule;
import com.smallert.gamebody.GameObject;
import com.smallert.gui.GameFrame;
import com.smallert.utils.ImgLoadUtil;
import com.smallert.utils.PropertyUtil;

import java.awt.*;

public abstract class StageGameMap extends GameMap{

    private static int Bg_Gray_width = 80;
    private static int Bg_Gray_height = 60;
    private static int EnemyCount =Integer.parseInt((String)PropertyUtil.get("enemyCount"));
    private int EnemyTankIcoPositionY = 70;
    private int EnemyTankIcoPositionX = GameFrame.GAME_WIDTH-EnemyTankIcoPositionY;




    /**
     * 地图中相同的部分
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.gray);
        g.fillRect(0,0, GameFrame.GAME_WIDTH,Bg_Gray_height);
        g.fillRect(0,0, Bg_Gray_width,GameFrame.GAME_HEIGHT);
        g.fillRect(0,GameFrame.GAME_HEIGHT-Bg_Gray_height, GameFrame.GAME_WIDTH,Bg_Gray_height);
        g.fillRect(GameFrame.GAME_WIDTH-Bg_Gray_width,0, Bg_Gray_width,GameFrame.GAME_HEIGHT);
        g.setColor(color);
        int EnemyTankIcoX = EnemyTankIcoPositionX;
        int EnemyTankIcoY = EnemyTankIcoPositionY;
        for (int i = 0; i <EnemyCount/2; i++) {
            g.drawImage(ImgLoadUtil.EnemyTankCountIco,EnemyTankIcoX,EnemyTankIcoY,null);
            EnemyTankIcoX+=ImgLoadUtil.EnemyTankCountIco.getWidth()+2;
            g.drawImage(ImgLoadUtil.EnemyTankCountIco,EnemyTankIcoX,EnemyTankIcoY,null);
            EnemyTankIcoY+=ImgLoadUtil.EnemyTankCountIco.getHeight()+2;
            EnemyTankIcoX-=ImgLoadUtil.EnemyTankCountIco.getWidth()+2;
        }
        //属性
        g.drawImage(ImgLoadUtil.PlayerOneIco,GameFrame.GAME_WIDTH-Bg_Gray_height,GameFrame.GAME_HEIGHT/2+20,null);
        g.drawImage(ImgLoadUtil.PlayerTankCountIco,GameFrame.GAME_WIDTH-Bg_Gray_height-10,GameFrame.GAME_HEIGHT/2+30+ImgLoadUtil.PlayerOneIco.getHeight(),null);
        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        g.drawString(GameModule.getLifeNum(),GameFrame.GAME_WIDTH-Bg_Gray_height+ImgLoadUtil.PlayerTankCountIco.getWidth(),GameFrame.GAME_HEIGHT/2+50+ImgLoadUtil.PlayerOneIco.getHeight());
        //基地与围墙

        g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.Home.ordinal()],(GameFrame.GAME_WIDTH-ImgLoadUtil.Home.getWidth())/2,GameFrame.GAME_HEIGHT-ImgLoadUtil.Home.getHeight()-Bg_Gray_height,null);


        int width = (GameFrame.GAME_WIDTH-ImgLoadUtil.Home.getWidth())/2-ImgLoadUtil.BrickWallSmall.getWidth();
        for (int i = 0; i <4 ; i++) {
            g.drawImage(ImgLoadUtil.BrickWallSmall,width,GameFrame.GAME_HEIGHT-ImgLoadUtil.Home.getHeight()-Bg_Gray_height-ImgLoadUtil.BrickWallSmall.getHeight(),null);
            width+=ImgLoadUtil.BrickWallSmall.getWidth();
        }

        g.drawImage(ImgLoadUtil.BrickWallSmall,(GameFrame.GAME_WIDTH+ImgLoadUtil.Home.getWidth())/2,GameFrame.GAME_HEIGHT-ImgLoadUtil.Home.getHeight()-Bg_Gray_height,null);
        g.drawImage(ImgLoadUtil.BrickWallSmall,(GameFrame.GAME_WIDTH+ImgLoadUtil.Home.getWidth())/2,GameFrame.GAME_HEIGHT-ImgLoadUtil.Home.getHeight()-Bg_Gray_height+ImgLoadUtil.BrickWallSmall.getHeight(),null);

        paintStage(g);

    }

    /**
     * 子类地图自己编写对应的地图部分
     * @param g
     */
    public abstract void paintStage(Graphics g);
}

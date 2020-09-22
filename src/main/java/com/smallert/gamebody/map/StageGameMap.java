package com.smallert.gamebody.map;

import com.smallert.common.GameObjectType;
import com.smallert.gamebody.GameModule;
import com.smallert.gamebody.GameObjectSimpleFactory;
import com.smallert.gamebody.otherobject.Home;
import com.smallert.gamebody.otherobject.Wall;
import com.smallert.gui.EditMapFrame;
import com.smallert.gui.GameFrame;
import com.smallert.utils.ImgLoadUtil;
import com.smallert.utils.MapUtil;
import com.smallert.utils.PropertyUtil;

import java.awt.*;
import java.util.List;

public class StageGameMap extends GameMap{
    //看是否新添加了地图
    public static boolean changed;
    //加载地图中物体
    public static boolean loadingRead;
    //当前地图
    public static int currentMap = 0;

    private static int Bg_Gray_width;
    private static int Bg_Gray_height;
    private static int EnemyCount;
    private static List<String> mapNameString;

    static {
        Bg_Gray_width = 88;
        Bg_Gray_height = 60;
        EnemyCount =Integer.parseInt((String)PropertyUtil.get("enemyCount"));
        mapNameString = MapUtil.getMapNames();
    }

    private int EnemyTankIcoPositionY = 70;
    private int EnemyTankIcoPositionX = GameFrame.GAME_WIDTH-EnemyTankIcoPositionY;



    /**
     * 初始化基地部分
     */
    public StageGameMap(){
        init();
    }

    /**
     * 地图中相同的部分
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        if (!loadingRead){
            loadingRead = true;
            loadingGameObject();
        }
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
    }

    /**
     * 初始化地图类共同资源
     */
    public void init(){
        Home home = GameObjectSimpleFactory.createHome((GameFrame.GAME_WIDTH - Home.getPicWidth()) / 2, GameFrame.GAME_HEIGHT - Home.getPicHeight() - Bg_Gray_height, true);
        GameObjectSimpleFactory.createWall(home.getPositionX()- Wall.getPicWidth(GameObjectType.VerticalBrickWall),GameFrame.GAME_HEIGHT-Wall.getPicHeight(GameObjectType.VerticalBrickWall)-Bg_Gray_height,true,GameObjectType.VerticalBrickWall,0);
        GameObjectSimpleFactory.createWall(home.getPositionX()- 2*Wall.getPicWidth(GameObjectType.VerticalBrickWall),GameFrame.GAME_HEIGHT-Wall.getPicHeight(GameObjectType.VerticalBrickWall)-Bg_Gray_height,true,GameObjectType.VerticalBrickWall,0);
        int count = (4*Wall.getPicWidth(GameObjectType.VerticalBrickWall)+home.getWidth())/Wall.getPicWidth(GameObjectType.SpotBrickWall);
        int topBrickWallWidth = home.getPositionX()- 2*Wall.getPicWidth(GameObjectType.VerticalBrickWall);
        for (int i = 0; i <=count ; i++) {
            GameObjectSimpleFactory.createWall(topBrickWallWidth,home.getPositionY()-Wall.getPicHeight(GameObjectType.SpotBrickWall),true,GameObjectType.SpotBrickWall,0);
            topBrickWallWidth +=Wall.getPicWidth(GameObjectType.SpotBrickWall);
        }
        GameObjectSimpleFactory.createWall(home.getPositionX()+Home.getPicWidth()+2,GameFrame.GAME_HEIGHT-Wall.getPicHeight(GameObjectType.VerticalBrickWall)-Bg_Gray_height,true,GameObjectType.VerticalBrickWall,0);
        GameObjectSimpleFactory.createWall(home.getPositionX()+Home.getPicWidth()+Wall.getPicWidth(GameObjectType.VerticalBrickWall)+2,GameFrame.GAME_HEIGHT-Wall.getPicHeight(GameObjectType.VerticalBrickWall)-Bg_Gray_height,true,GameObjectType.VerticalBrickWall,0);
    }

    /**
     * 加载游戏物体
     */
    private void loadingGameObject(){
        int[][] gameObjectArr = MapUtil.readMap("maps/" + mapNameString.get(currentMap) + ".map");
        for (int i = 0; i < gameObjectArr.length; i++) {
            int height =EditMapFrame.margin_height+i*EditMapFrame.pictureWidth;
            for (int j = 0; j < gameObjectArr[i].length; j++) {
                if (gameObjectArr[i][j]==0) continue;
                GameObjectSimpleFactory.create(GameObjectType.getGameObject(gameObjectArr[i][j]), EditMapFrame.margin_width+j*EditMapFrame.pictureWidth,height);
            }
        }
    }
}

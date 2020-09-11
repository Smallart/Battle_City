package com.smallert.gamebody;

import com.smallert.commond.GameStatus;
import com.smallert.commond.MapEnum;
import com.smallert.gamebody.map.MenuMap;
import com.smallert.gamebody.map.StageGameMap;
import com.smallert.gamebody.map.Stage_1_Map;
import com.smallert.gamebody.tank.PlayerTank;
import com.smallert.utils.PropertyUtil;
import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 中介,单例模式避免被多次实例化导致绘画异常
 * 所有地图中对象交给它处理
 */
@Data
public class GameModule {
    public static MapEnum currentMap = MapEnum.MENU;

    private static final GameModule INSTANCE = new GameModule();

    private GameModule(){
        gameStatus = GameStatus.PREPARING;
    }

    public static GameModule getInstance(){
        return INSTANCE;
    }

    private StageGameMap gameMap;

    private static String LifeNum = (String) PropertyUtil.get("LifeNum");
    /**
     * 游戏状态
     */
    private GameStatus gameStatus;
    /**
     * 游戏中大部分物体
     */
    private List<GameObject> gameBodyList = new LinkedList<>();
    /**
     * 玩家坦克
     */
    private List<PlayerTank> playerTanks = new ArrayList<>();

    public void paint(Graphics g) {
        switch (currentMap){
            case MENU:
                MenuMap.getInstance().paint(g);
                break;
            case STAGE_1:
                if (gameMap==null&&currentMap==MapEnum.STAGE_1){
                    gameMap = new Stage_1_Map();
                }
                gameMap.paint(g);
                break;
            case GAME_OVER:
                break;
        }
        Color color = g.getColor();
        g.setColor(Color.red);
        g.drawString("物体数量："+gameBodyList.size(),20,50);
        g.setColor(color);
        for (PlayerTank playerTank : playerTanks) {
            playerTank.pain(g);
        }
        for (int i = 0; i < gameBodyList.size(); i++) {
            gameBodyList.get(i).pain(g);
        }
    }

    public static String getLifeNum() {
        return LifeNum;
    }

    public boolean gameStarting(){
        if (this.gameStatus==GameStatus.START) return true;
        return false;
    }
}

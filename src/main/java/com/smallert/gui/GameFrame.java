package com.smallert.gui;

import com.smallert.gamebody.GameModule;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 游戏绘画界面
 */
public class GameFrame extends Frame {
    public static final int GAME_WIDTH=800,GAME_HEIGHT=600;
    private Image offScreenImage=null;
    public static final GameFrame INSTANCE=new GameFrame();
    private static GameModule gameModule = GameModule.getInstance();
    private GameFrame(){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("Battle City");
        /**
         * 设置 窗口监听事件
         * todo 使用1.8中lameda表达式
         */
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public static GameFrame getInstance(){
        return INSTANCE;
    }

    /**
     * 用来绘画
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        gameModule.paint(g);
    }

    /**
     * 双缓冲 解决闪烁问题
     * @param g
     */
    @Override
    public void update(Graphics g) {
        if (offScreenImage==null){
            offScreenImage=this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics graphics = offScreenImage.getGraphics();
        Color color = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        graphics.setColor(color);
        paint(graphics);
        g.drawImage(offScreenImage,0,0,null);
    }

}

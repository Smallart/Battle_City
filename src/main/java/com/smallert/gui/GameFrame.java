package com.smallert.gui;

import com.smallert.gamebody.GameModule;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 游戏绘画界面
 */
public class GameFrame extends Frame {
    public static final int GAME_WIDTH=800,GAME_HEIGHT=600;
    public static final int ACTUAL_GAME_BOUNDARY_L=80,ACTUAL_GAME_BOUNDARY_R=720,
            ACTUAL_GAME_BOUNDARY_U=60,ACTUAL_GAME_BOUNDARY_D=540;
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

        addKeyListener(new KeyControl());

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

    /**
     * 实现键盘监听类
     */
    class KeyControl extends KeyAdapter{
        /**
         * 按键压下去
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_W:
                    gameModule.getPlayerTanks().get(0).dirUp=true;
                    break;
                case KeyEvent.VK_A:
                    gameModule.getPlayerTanks().get(0).dirLeft=true;
                    break;
                case KeyEvent.VK_S:
                    gameModule.getPlayerTanks().get(0).dirDown=true;
                    break;
                case KeyEvent.VK_D:
                    gameModule.getPlayerTanks().get(0).dirRight = true;
                    break;
            }
            if (gameModule.getPlayerTanks().get(0).dirUp|| gameModule.getPlayerTanks().get(0).dirRight||
                    gameModule.getPlayerTanks().get(0).dirDown||gameModule.getPlayerTanks().get(0).dirLeft){
                gameModule.getPlayerTanks().get(0).setMoving(true);
            }
        }

        /**
         * 按键松开
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_W:
                    gameModule.getPlayerTanks().get(0).dirUp=false;
                    break;
                case KeyEvent.VK_A:
                    gameModule.getPlayerTanks().get(0).dirLeft=false;
                    break;
                case KeyEvent.VK_S:
                    gameModule.getPlayerTanks().get(0).dirDown=false;
                    break;
                case KeyEvent.VK_D:
                    gameModule.getPlayerTanks().get(0).dirRight = false;
                    break;
                case KeyEvent.VK_J:
                    gameModule.getPlayerTanks().get(0).fire();
                    break;
            }
            if (!gameModule.getPlayerTanks().get(0).dirUp&& !gameModule.getPlayerTanks().get(0).dirRight&&
                    !gameModule.getPlayerTanks().get(0).dirDown&&!gameModule.getPlayerTanks().get(0).dirLeft){
                gameModule.getPlayerTanks().get(0).setMoving(false);
            }
        }
    }
}



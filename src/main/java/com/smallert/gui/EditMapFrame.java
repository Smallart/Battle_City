package com.smallert.gui;

import com.smallert.common.EditMapIcoEnum;
import com.smallert.common.GameObjectType;
import com.smallert.common.MapEnum;
import com.smallert.common.FrameEnum;
import com.smallert.gamebody.GameModule;
import com.smallert.utils.ImgLoadUtil;
import com.smallert.utils.MapUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * 坦克地图编辑界面
 */
public class EditMapFrame extends JPanel {

    /**
     * 绘画位置与外框的边距
     */
    public static int margin_height=60;
    public static int margin_width=88;
    public static int pictureWidth = 48;
    private static int LabelX=720;
    private static int LabelY=30;

    //规定的基地数量
    private static int ruleHomeNum;

    /**
     * 绘制的图片
     */
    private int PicNum=0;


    public static int verticalCount = (GameFrame.GAME_WIDTH-2*margin_width)/pictureWidth;
    public static int transverseCount = (GameFrame.GAME_HEIGHT-2*margin_height)/pictureWidth;

    private float[] dash = {5,5};

    private int positionX=-1;
    private int positionY=-1;

    //全图基地数量
    private int homeNum;

    /**
     * 放置物体的二元数组
     */
    private int[][] gameObjects =new int[verticalCount][transverseCount];

    private Font font = new Font(Font.SANS_SERIF,Font.BOLD,20);

    public EditMapFrame(){
        setLayout(null);
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                positionX=(checkThePointX(e.getX())-margin_width)/pictureWidth;
                positionY =(checkThePointY(e.getY())-margin_height+pictureWidth)/pictureWidth;
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                positionX=(checkThePointX(e.getX())-margin_width)/pictureWidth;
                positionY =(checkThePointY(e.getY())-margin_height+pictureWidth)/pictureWidth;
                gameObjects[positionX][positionY] = PicNum;
            }
        });


        // 选择贴图框
        for (int i = 0; i < EditMapIcoEnum.values().length-1; i++) {
            JLabel label = addLabel(LabelX, LabelY+i*pictureWidth+10);
            final EditMapIcoEnum value = EditMapIcoEnum.values()[i];
            if (value ==EditMapIcoEnum.Home){
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        PicNum = value.getIndex();
                    }
                });
            }else{
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        PicNum = value.getIndex();
                    }
                });
            }
            add(label);
        }

        //保存
        JLabel saveLabel = new JLabel();
        saveLabel.setBounds(GameFrame.GAME_WIDTH-margin_width+20,GameFrame.GAME_HEIGHT-2*margin_height-30,40,20);
        saveLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        saveLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (JOptionPane.showConfirmDialog(null, "是否保存修改？", "保存", JOptionPane.YES_NO_OPTION)){
                    case 0:
                        final String fileName = JOptionPane.showInputDialog("请输入新建地图名称：");
                        if (fileName==null) return;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                MapUtil.saveMap(gameObjects,fileName);
                            }
                        }).start();
                        destroy();
                        break;
                    default:
                        break;
                }
            }
        });
        add(saveLabel);
        //返回
        JLabel backLabel = new JLabel();
        backLabel.setBounds(GameFrame.GAME_WIDTH-margin_width+20,GameFrame.GAME_HEIGHT-2*margin_height+10,40,20);
        backLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (JOptionPane.showConfirmDialog(null,"是否放弃修改，返回主界面？","返回",JOptionPane.YES_NO_OPTION)){
                    case 0:
                        destroy();
                        break;
                    default:
                        break;
                }
            }
        });
        add(backLabel);
        GameFrame.getInstance().add(this);
        GameFrame.getInstance().revalidate();
    }

    private JLabel addLabel(int x,int y){
        JLabel label = new JLabel();
        label.setBounds(x,y,pictureWidth,pictureWidth);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return label;
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.gray);
        g.fillRect(0,0,GameFrame.GAME_WIDTH,margin_height);
        g.fillRect(0,margin_height,margin_width,GameFrame.GAME_HEIGHT-2*margin_height);
        g.fillRect(GameFrame.GAME_WIDTH-margin_width,margin_height,margin_width,GameFrame.GAME_HEIGHT-2*margin_height);
        g.fillRect(0,GameFrame.GAME_HEIGHT-margin_height,GameFrame.GAME_WIDTH,margin_height);
        if (positionX>-1&&positionY>-1){
            g.fillRect(margin_width+positionX*pictureWidth,margin_height+positionY*pictureWidth,pictureWidth,pictureWidth);
        }
        g.setColor(color);

        //绘画出左边图片
        g.fillRect(GameFrame.GAME_WIDTH-margin_width+(margin_width-pictureWidth)/2,margin_height+10,38,38);
        g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.IronWall.ordinal()],GameFrame.GAME_WIDTH-margin_width+(margin_width-pictureWidth)/2,margin_height+pictureWidth+10,null);
        g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.BrickWall.ordinal()],GameFrame.GAME_WIDTH-margin_width+(margin_width-pictureWidth)/2,margin_height+pictureWidth*2+10,null);
        g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.IceField.ordinal()],GameFrame.GAME_WIDTH-margin_width+(margin_width-pictureWidth)/2,margin_height+pictureWidth*3+10,null);
        g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.Forest.ordinal()],GameFrame.GAME_WIDTH-margin_width+(margin_width-pictureWidth)/2,margin_height+pictureWidth*4+10,null);
        g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.Home.ordinal()],GameFrame.GAME_WIDTH-margin_width+(margin_width-pictureWidth)/2,margin_height+pictureWidth*5+10,null);


        //绘图
        for (int i = 0; i < gameObjects.length; i++) {
            for (int j = 0; j < gameObjects[i].length; j++) {
                if (gameObjects[i][j]>0){
                    g.drawImage(ImgLoadUtil.GameObjectTypes[gameObjects[i][j]],margin_width+i*pictureWidth,margin_height+j*pictureWidth,null);
                }
            }
        }

        //画虚线
        Color c = g.getColor();
        g.setColor(Color.red);
        Graphics2D g2 = (Graphics2D)g;
        BasicStroke basicStroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10.0f, dash, 0.0f);
        g2.setStroke(basicStroke);
        for (int i=1;i<verticalCount;i++){
            g2.drawLine(margin_width+pictureWidth*i,margin_height,margin_width+pictureWidth*i,GameFrame.GAME_HEIGHT-margin_height);
        }
        for (int j=1;j<transverseCount;j++){
            g2.drawLine(margin_width,margin_height+j*pictureWidth,GameFrame.GAME_WIDTH-margin_width,margin_height+j*pictureWidth);
        }
        g2.setColor(c);
        drainSelectedT(EditMapIcoEnum.getIndexByItem(PicNum),g2);

        g2.setFont(font);
        Color col = g2.getColor();
        g2.setColor(Color.RED);
        g2.drawString("保存",GameFrame.GAME_WIDTH-margin_width+(margin_width-stringWidth(g2,"保存"))/2,GameFrame.GAME_HEIGHT-margin_height-40);
        g2.drawString("返回",GameFrame.GAME_WIDTH-margin_width+(margin_width-stringWidth(g2,"返回"))/2,GameFrame.GAME_HEIGHT-margin_height);
        g2.setColor(col);

    }

    //绘画选中框
    private void drainSelectedT(EditMapIcoEnum icoEnum,Graphics2D g){
        Color color = g.getColor();
        g.setColor(Color.PINK);
        g.setStroke(new BasicStroke(3.0f));
        switch (icoEnum){
            case Delete:
                g.drawRect(GameFrame.GAME_WIDTH-margin_width+(margin_width-pictureWidth)/2,margin_height+10,38,38);
                break;
            case IronWall:
                g.drawRect(GameFrame.GAME_WIDTH-margin_width+(margin_width-pictureWidth)/2,margin_height+pictureWidth+10,38,38);
                break;
            case BrickWall:
                g.drawRect(GameFrame.GAME_WIDTH-margin_width+(margin_width-pictureWidth)/2,margin_height+2*pictureWidth+10,38,38);
                break;
            case IceField:
                g.drawRect(GameFrame.GAME_WIDTH-margin_width+(margin_width-pictureWidth)/2,margin_height+3*pictureWidth+10,38,38);
                break;
            case Forest:
                g.drawRect(GameFrame.GAME_WIDTH-margin_width+(margin_width-pictureWidth)/2,margin_height+4*pictureWidth+10,38,38);
                break;
            case Home:
                g.drawRect(GameFrame.GAME_WIDTH-margin_width+(margin_width-pictureWidth)/2,margin_height+5*pictureWidth+10,38,38);
                break;
        }
        g.setColor(color);
    }

    //点击事件检测
    private int checkThePointX(int x){
        if (x<margin_width) x=margin_width;
        if (x+margin_width>GameFrame.GAME_WIDTH) x = GameFrame.GAME_WIDTH - margin_width - pictureWidth;
        return x;
    }

    private int checkThePointY(int y){
        if (y<margin_height-pictureWidth) y=margin_height-pictureWidth;
        if (y>GameFrame.GAME_HEIGHT-margin_height-2*pictureWidth) y = GameFrame.GAME_HEIGHT-margin_height-2*pictureWidth;
        return y;
    }

    //计算字符长度
    private int stringWidth(Graphics g,String text){
        return g.getFontMetrics().stringWidth(text);
    }

    private void destroy(){
        GameModule.currentMap = MapEnum.STAGE_1;
        GameFrame.type = FrameEnum.MENU;
        GameFrame.selected = true;
        GameFrame.getInstance().remove(this);
    }

}

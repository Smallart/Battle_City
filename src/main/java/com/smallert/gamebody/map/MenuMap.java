package com.smallert.gamebody.map;

import com.smallert.gui.GameFrame;
import com.smallert.utils.ImgLoadUtil;
import com.smallert.utils.PropertyUtil;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * 开始菜单
 */
public class MenuMap extends GameMap {

    private static MenuMap INSTANCE = new MenuMap();

    private MenuMap(){}

    public static MenuMap getInstance(){
        return INSTANCE;
    }

    public static String menuString;
    public static int menuStringSize;
    private static final String CopyRight_ONE = "@ 2020 09 SMALLART DREAM.";
    private static final String CopyRight_TWO = "ALL RIGHTS RESERVED";
    private static Map<Label,Boolean> labelMap =new HashMap<>();
    static {
        menuString = (String) PropertyUtil.get("selectMenu");
        menuStringSize = Integer.parseInt((String) PropertyUtil.get("menuStringSize"));
    }

    public static int Battle_City_Height = 120;
    public static int Menu_String_Margin = 40;

    public void paint(Graphics g) {
        g.drawImage(ImgLoadUtil.Battle_City, (GameFrame.GAME_WIDTH-ImgLoadUtil.Battle_City.getWidth())/2,Battle_City_Height,null);
        paintElection(g);
    }

    private void paintElection(Graphics g){
        if (menuString==null) return;

        Color color = g.getColor();
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, menuStringSize);
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(CopyRight_TWO,(GameFrame.GAME_WIDTH-stringWidth(g,CopyRight_TWO))/2,GameFrame.GAME_HEIGHT-Menu_String_Margin);
        g.drawString(CopyRight_ONE,(GameFrame.GAME_WIDTH-stringWidth(g,CopyRight_ONE))/2,GameFrame.GAME_HEIGHT-Menu_String_Margin-(menuStringSize*2));
        if (labelMap.size()<=0){
            createLabels(g,font);
        }
        Set<Label> labels = MenuMap.labelMap.keySet();
        for (Label label : labels) {
            if (labelMap.get(label)){
                g.drawImage(ImgLoadUtil.MENU_ELECT_Tank,label.getX()-2*ImgLoadUtil.MENU_ELECT_Tank.getWidth(),label.getY(),null);
            }
        }
        g.setColor(color);

    }

    private int stringWidth(Graphics g,String text){
        return g.getFontMetrics().stringWidth(text);
    }

    private void createLabels(Graphics g, Font f){
        String[] selectMenu = menuString.split("_");
        int height=ImgLoadUtil.Battle_City.getHeight()+Battle_City_Height+(ImgLoadUtil.Battle_City.getHeight()+Battle_City_Height-Menu_String_Margin-menuStringSize)/selectMenu.length;
        int width = stringWidth(g,selectMenu[0]);
        for (String createLabels : selectMenu) {
            final Label label = new Label(createLabels);
            label.setBounds((GameFrame.GAME_WIDTH-width)/2,height,stringWidth(g,createLabels),menuStringSize);
            label.setFont(f);
            label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label.setForeground(Color.white);
            label.setBackground(Color.black);
            GameFrame.getInstance().add(label);
            labelMap.put(label,false);
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("点击");
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    Label label =(Label) e.getSource();
                    labelMap.put(label,true);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    Label label =(Label) e.getSource();
                    labelMap.put(label,false);
                }
            });
            height +=menuStringSize*1.5;
        }
    }
}

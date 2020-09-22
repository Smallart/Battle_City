package com.smallert.gamebody.map;

import com.smallert.common.MapEnum;
import com.smallert.common.FrameEnum;
import com.smallert.gamebody.GameModule;
import com.smallert.gui.EditMapFrame;
import com.smallert.gui.GameFrame;
import com.smallert.utils.AudioUtil;
import com.smallert.utils.ImgLoadUtil;
import com.smallert.utils.PropertyUtil;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 开始菜单
 */
public class MenuMap extends GameMap {

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

    private Font font = new Font(Font.SANS_SERIF, Font.BOLD, menuStringSize);

    public void paint(Graphics g) {
        g.drawImage(ImgLoadUtil.Battle_City, (GameFrame.GAME_WIDTH-ImgLoadUtil.Battle_City.getWidth())/2,Battle_City_Height,null);
        paintElection(g);
    }

    private void paintElection(Graphics g){
        if (menuString==null) return;

        Color color = g.getColor();

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

        for (int i = 0; i < selectMenu.length; i++) {
            Label label = builderLabelsDetail(selectMenu[i],g,height,f);
            if (selectMenu[i].contains("PLAYER")){
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //转换状态
                        GameFrame.type= FrameEnum.GameFrame;
                        GameModule.currentMap = MapEnum.STAGE_1;
                        AudioUtil.stageStartAudio();
                        Set<Label> labels = labelMap.keySet();
                        for (Label label : labels) {
                            GameFrame.getInstance().remove(label);
                        }
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

            }else{
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        GameFrame.type= FrameEnum.EditMap;
                        GameFrame.selected = true;
                        Set<Label> labels = labelMap.keySet();
                        Iterator<Label> iterator = labels.iterator();
                        while (iterator.hasNext()){
                            Label next = iterator.next();
                            GameFrame.getInstance().remove(next);
                            iterator.remove();
                        }
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
            }
            labelMap.put(label,false);
            height +=menuStringSize*1.5;
        }
    }

    private Label builderLabelsDetail(String words,Graphics g,int height,Font f){
        int width = stringWidth(g,words);
        Label label = new Label(words);
        label.setBounds((GameFrame.GAME_WIDTH-width)/2,height,stringWidth(g,words),menuStringSize);
        label.setFont(f);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.setForeground(Color.white);
        label.setBackground(Color.black);
        GameFrame.getInstance().add(label);
        return label;
    }
}

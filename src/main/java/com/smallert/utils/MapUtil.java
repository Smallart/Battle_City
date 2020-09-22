package com.smallert.utils;

import com.smallert.gui.EditMapFrame;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 加载地图的工具类
 */
public class MapUtil {
    /**
     * 保存地图
     * @return
     */
    public static boolean saveMap(int[][] map,String fileName){
        boolean flag=false;

        int[][] newArray = new int[EditMapFrame.transverseCount][EditMapFrame.verticalCount];
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[i].length; j++) {
                newArray[i][j] = map[j][i];
            }
        }


        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("maps/"+fileName+".map"));){
            for (int[] ints : newArray) {
                bufferedWriter.write(Arrays.toString(ints).replaceAll("\\[|\\]|\\s", ""));
                bufferedWriter.newLine();
            }
           if (writeMapsName(fileName)){
               flag = true;
           }else{
               Path path = Paths.get("maps", fileName+".map");
               if (Files.exists(path)){
                   Files.delete(path);
               }
           }
            return flag;
        }catch (IOException e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 写入新编地图名字
     * @param fileName
     * @return
     */
    public static boolean writeMapsName(String fileName){
        //对该文件进行检查
        Path path = Paths.get("maps","map.config");
        if (!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        // 向该文件末尾添加文件名称
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(),true))){
            writer.write(fileName);
            writer.newLine();
            return true;
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 读取地图配置文件
     * @param fileName
     * @return
     */
    public static int[][] readMap(String fileName){
        int[][] map = new int[EditMapFrame.transverseCount][];
        int count = 0;
        try(BufferedReader reader =new BufferedReader(new FileReader(fileName));){
            String s=null;
            while((s=reader.readLine())!=null){
                int[] ints = new int[EditMapFrame.verticalCount];
                String[] split = s.split(",");
                for (int i = 0; i < split.length; i++) {
                    ints[i] = Integer.parseInt(split[i]);
                }
                map[count] = ints;
                count++;
            }
            return map;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取map配置文件中的地图名称
     * @return
     */
    public static List<String> getMapNames(){
        List<String> mapNames = new ArrayList<>();
        try(BufferedReader reader =new BufferedReader(new FileReader("maps/map.config"))){
            String s=null;
            while((s= reader.readLine())!=null){
                mapNames.add(s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return mapNames;
    }
}

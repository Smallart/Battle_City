package com.smallert;

import com.smallert.common.Direction;
import com.smallert.common.GameObjectType;
import com.smallert.gamebody.GameObject;
import com.smallert.utils.MapUtil;
import com.smallert.utils.PropertyUtil;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        String selectMenu = (String) PropertyUtil.get("selectMenu");
        String[] split = selectMenu.split("_");
        for (String s : split) {
            System.out.println(s);
        }
    }

    @Test
    public void testEnum(){
        int[][] map = {{1,2,3},{4,5,9},{1,2,4}};
        MapUtil.saveMap(map,"test.map");
    }

    @Test
    public void testMapUtil(){
        MapUtil.writeMapsName("stage_3_map");
    }
}

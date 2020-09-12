package com.smallert;

import com.smallert.common.Direction;
import com.smallert.utils.PropertyUtil;
import org.junit.Test;

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
    }
}

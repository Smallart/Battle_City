package com.smallert;

import static org.junit.Assert.assertTrue;

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
}

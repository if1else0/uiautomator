package com.example.aaron.uiautomaotor.testcases.login;

import com.example.aaron.uiautomaotor.BasicTest;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Aaron on 2017/6/1.
 */

public class Login1 extends BasicTest{



    @Test
    public void name() throws Exception {
        helper.getPageCommon().clickMyTab();
        helper.getPageMy().clickLoginIcon();
        helper.getPageLogin().login("robotium2016@163.com","uiautomator");
        assertEquals("robotium2016",helper.getPageMy().getNickNameText());
    }



}

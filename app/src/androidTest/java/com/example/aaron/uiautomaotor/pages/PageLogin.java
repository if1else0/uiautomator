package com.example.aaron.uiautomaotor.pages;

import android.support.test.uiautomator.UiObject2;

import com.example.aaron.uiautomaotor.utils.Finder;

/**
 * Created by aaronyang on 6/25/17.
 */

public class PageLogin {
    private Finder finder;

    public PageLogin(Finder finder){
        this.finder = finder;
    }

    public UiObject2 getNameEditText(){
        return finder.findById("com.netease.newsreader.activity:id/ox");
    }

    public UiObject2 getPwdEditText(){
        return finder.findById("com.netease.newsreader.activity:id/p3");
    }

    public UiObject2 getLoginBtn(){
        return finder.findById("com.netease.newsreader.activity:id/p5");
    }

    public void clearNameET(){
        getNameEditText().clear();
    }

    public void clearPwdET(){
        getPwdEditText().clear();
    }

    public void clickLoginBtn(){
        getLoginBtn().click();
    }

    public void entertName(String name){
        getNameEditText().setText(name);
    }

    public void enterPwd(String pwd){

        getPwdEditText().setText(pwd);
    }

    public void login(String name,String pwd){
        clearNameET();
        entertName(name);
//        clearPwdET();
        getPwdEditText().click();
        enterPwd(pwd);
        clickLoginBtn();
    }
}

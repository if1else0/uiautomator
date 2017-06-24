package com.example.aaron.uiautomaotor.pages;

import android.graphics.pdf.PdfDocument;
import android.support.test.uiautomator.UiObject2;

import com.example.aaron.uiautomaotor.utils.Finder;

/**
 * Created by aaronyang on 6/25/17.
 */

public class PageMy {
    private Finder finder;

    public PageMy(Finder finder){
        this.finder = finder;
    }

    public UiObject2 getLoginIcon(){
        return finder.findById("com.netease.newsreader.activity:id/a6b");
    }

    public void clickLoginIcon(){
        getLoginIcon().click();
    }

    public UiObject2 getNickName(){
        return finder.findById("com.netease.newsreader.activity:id/biz_pc_main_info_profile_nickname");
    }

    public String getNickNameText(){
        return getNickName().getText().toString();
    }

}

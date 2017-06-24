package com.example.aaron.uiautomaotor;

import com.example.aaron.uiautomaotor.pages.PageCommon;
import com.example.aaron.uiautomaotor.pages.PageLogin;
import com.example.aaron.uiautomaotor.pages.PageMy;
import com.example.aaron.uiautomaotor.utils.Finder;

/**
 * Created by aaronyang on 6/25/17.
 */

public class PageHelper {
    private Finder finder;

    public PageCommon pageCommon;
    public PageMy pageMy;
    public PageLogin pageLogin;

    public PageHelper(Finder finder){
        this.finder = finder;
    }

    public PageCommon getPageCommon(){
        if(pageCommon == null){
            pageCommon = new PageCommon(finder);
        }
        return pageCommon;
    }

    public PageMy getPageMy(){
        if(pageMy == null){
            pageMy = new PageMy(finder);
        }
        return pageMy;
    }

    public PageLogin getPageLogin(){
        if(pageLogin == null){
            pageLogin = new PageLogin(finder);
        }
        return pageLogin;
    }
}

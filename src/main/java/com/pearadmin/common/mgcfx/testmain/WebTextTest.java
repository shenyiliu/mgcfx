package com.pearadmin.common.mgcfx.testmain;


import com.pearadmin.common.mgcfx.tool.crawler.CrawlerHtml;
import com.pearadmin.common.mgcfx.tool.crawler.RegexFilterText;

public class WebTextTest {
    public static void main(String[] args) throws Exception {
       String a= CrawlerHtml.getHtml("https://www.chazidian.com/baijiaxing/");
       a= RegexFilterText.getText(a);
        System.out.println(a);
    }
}

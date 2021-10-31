package com.pearadmin.common.mgcfx.testmain;


import com.pearadmin.common.mgcfx.tool.crawler.CrawlerHtml;
import com.pearadmin.common.mgcfx.tool.crawler.RegexFilterText;

public class test {
    public static void main(String[] args) throws Exception {
        System.out.println(RegexFilterText.getText(CrawlerHtml.getHtml("http://www.hbeu.cn/info/1020/13813.htm")));
    }
}

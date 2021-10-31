package com.pearadmin.common.mgcfx.tool.crawler;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class CrawlerHtml{
    /**
     * 本类为爬虫类
     * @param url  所需爬取的web页面地址
     * @return  get请求
     * @throws Exception
     */
    public static String getHtml(String url) throws Exception {
//发起一个get请求
        HttpGet httpGet = new HttpGet(url);
//设置请求头
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
//返回页面的信息
        return gethtml(httpGet);
    }

    /**
     *   执行发送请求的方法，获取html源码
     * @param httpGet  网页get请求
     * @return  html源码
     * @throws Exception
     */
    private static String gethtml(HttpGet httpGet) throws Exception {
// TODO Auto-generated method stub
        String html = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse execute = httpClient.execute(httpGet);
//判断响应码是否为200，200正常请求
        if (execute.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = execute.getEntity();
            html = EntityUtils.toString(entity,"utf-8");
        }
        return html;
    }
}
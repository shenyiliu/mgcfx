package com.pearadmin.common.mgcfx.main;



import com.pearadmin.common.mgcfx.tool.Mysql.CloseMysql;
import com.pearadmin.common.mgcfx.tool.Mysql.GetValueToMysql;
import com.pearadmin.common.mgcfx.tool.Mysql.LinkMysql;
import com.pearadmin.common.mgcfx.tool.comparison.TwoListBeMixed;
import com.pearadmin.common.mgcfx.tool.crawler.CrawlerHtml;
import com.pearadmin.common.mgcfx.tool.crawler.Paticiple;
import com.pearadmin.common.mgcfx.tool.crawler.RegexFilterText;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    /** target:
     * 1、获取网页信息
     * 2、对获取到的文本进行分词，得到文本分词结果
     * 3、从数据库拿取敏感词
     * 4、将得到的文本分词结果与敏感词进行比对
     * 5、对常用的人名、身份证号、电话进行正则匹配
     */

    /**
     * 本方法是得到数据库（敏感词库）的记录
     * @param mySqlTableName  传入数据库表名
     * @return   返回读取的数据库记录所存放的list集合
     * @throws Exception
     */
    public static ArrayList mysqlValue(String mySqlTableName) throws Exception {
        String sql= LinkMysql.inquirysql(mySqlTableName);//完成查询数据库表的sql语句
        ArrayList<String> sqlValue= GetValueToMysql.readsql(sql); //得到数据库表（敏感词库）的所有记录
        System.out.println("数据库文本："+sqlValue);
        CloseMysql.close();//sql关闭语句
        return sqlValue;
    }

    /**
     * 本方法是获取网页文本
     * @param url  传入所需要爬取的网页网址
     * @return  返回处理过（正则筛选及第三方分词工具分词操作）的网页文本
     * @throws Exception
     */
    public static ArrayList getWebText(String url) throws Exception {
        String html= CrawlerHtml.getHtml(url);
        String text= RegexFilterText.getText(html);
        System.out.println(text);
        ArrayList<String> webText= Paticiple.fenci(text);
        System.out.println("分词后网页文本："+webText);
        return webText;
    }

    public static String getText(String url) throws Exception {
        String html= CrawlerHtml.getHtml(url);
        String text= RegexFilterText.getText(html);
        return text;
    }

    /**
     * 本方法是求两个集合的交集，即得到爬取的网页词与敏感词库进行匹配
     * @param sqlValue  注意此参数为大集合参数，传入敏感词库
     * @param webText   此参小集合参数，传入待检测的网页词语
     * @return   返回匹配的交集（筛查出的敏感词）
     */
    public static ArrayList fixArrayList(ArrayList sqlValue, ArrayList webText) {
        ArrayList<String> collectionList = new ArrayList<String>();//交集List
        // 获取交集,大集合用sqlValue,小集合用webText
        collectionList = TwoListBeMixed.receiveCollectionList(sqlValue,webText); //求两个集合的交集即核查敏感词集
        return collectionList;
    }


    /**
     * 正则匹配
     * @param regex
     * @return
     */
    public static String regexContext(String regex,String str){
        Pattern p1=Pattern.compile(regex);
        Matcher m1=p1.matcher(str);
        String titleText="";
        while (m1.find()){
            titleText=m1.group();
        }
        return titleText;
    }

    /**
     * 主函数入口
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //getWebText("http://www.hbeu.cn/info/1025/12323.htm");
        //ArrayList a= fixArrayList(mysqlValue("bad_word"),getWebText("http://www.hbeu.cn/info/1025/12323.htm"));
//        System.out.println("敏感词："+a);
//        System.out.println("敏感词数："+a.size()+"个");


        String str=getText("http://www.hbeu.cn/info/1025/14033.htm");

        //标题
        String title="(?<=正文)([\\s\\S]*)?(?=来源)";
        System.out.println(regexContext(title,str));

        //来源
        String ly="(?<=来源：)([\\s\\S]*)?(?=作者)";
        System.out.println(regexContext(ly,str));

        //作者
        String outhor="(?<=作者：)([\\s\\S]*)?(?=编辑)";
        System.out.println(regexContext(outhor,str));

        //发布时间
        String fbTime="(?<=发布时间：)([\\s\\S]*)?(?=点击次数)";
        System.out.println(regexContext(fbTime,str));


    }




}

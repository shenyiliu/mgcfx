package com.pearadmin.common.mgcfx.tool.crawler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFilterText {

    /**
     * 正则表达式筛查文本类
     * @param html  网页html代码信息
     * @return 被正则匹配筛选后的文本
     */

    public static String getText(String html) {
        Matcher matcher;
        matcher=pattern1.matcher(html);
        html=matcher.replaceAll("");		//匹配普通标签
        matcher=pattern2.matcher(html);
        html=matcher.replaceAll("");		//匹配script标签
        matcher=pattern3.matcher(html);
        html=matcher.replaceAll("");		//匹配style标签
        matcher=pattern4.matcher(html);
        html=matcher.replaceAll("\n");	//匹配连续回车或空格
        matcher=pattern5.matcher(html);
        html=matcher.replaceAll("");		//匹配网页图案出现的乱码
//        matcher=pattern6.matcher(html);
//       html=matcher.replaceAll("");		//匹配手机号
//        matcher=pattern7.matcher(html);
//        html=matcher.replaceAll("");		//匹配身份证
//        matcher=pattern8.matcher(html);
//        html=matcher.replaceAll("");		//匹配姓名

        String text=html;
        return text;		//返回文本
    }
 

    //设置正则表达式的匹配符
    private static String regExHtml="<[^>]+>";		//匹配标签
    private static String regExScript = "<script[^>]*?>[\\s\\S]*?<\\/script>";		//匹配script标签
    private static String regExStyle = "<style[^>]*?>[\\s\\S]*?<\\/style>";		//匹配style标签
    private static String regExSpace="[\\s]{2,}";	//匹配连续空格或回车等
    private static String regExImg="&[\\S]*?;+";	//匹配网页上图案的乱码
    private static String mobile="^1(3[0-9]|5[0-3,5-9]|7[1-3,5-8]|8[0-9])\\d{8}$";	//匹配手机号
    private static String id="/^([1-6][1-9]|50)\\d{4}(18|19|20)\\d{2}((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$/";//匹配身份证
    private static String name="[\\u4e00-\\u9fa5]{2,4}";	//匹配姓名



    //定义正则表达式
    private static Pattern pattern3=Pattern.compile(regExHtml, Pattern.CASE_INSENSITIVE);
    private static Pattern pattern1=Pattern.compile(regExScript,Pattern.CASE_INSENSITIVE);
    private static Pattern pattern2=Pattern.compile(regExStyle,Pattern.CASE_INSENSITIVE);
    private static Pattern pattern4=Pattern.compile(regExSpace, Pattern.CASE_INSENSITIVE);
    private static Pattern pattern5=Pattern.compile(regExImg,Pattern.CASE_INSENSITIVE);
    private static Pattern pattern6=Pattern.compile(mobile,Pattern.CASE_INSENSITIVE);
    private static Pattern pattern7=Pattern.compile(id,Pattern.CASE_INSENSITIVE);
    private static Pattern pattern8=Pattern.compile(name,Pattern.CASE_INSENSITIVE);



}

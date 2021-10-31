package com.pearadmin.common.mgcfx.tool.comparison;



import java.util.*;

public class TwoListBeMixed {
    /**
     * 1.本类为求两个list交集
     *
     * @param sqlValue  为数据库提取的数据list
     * @param webText    为网页提取的数据list
     * @return
     */

    //求交集
    public static ArrayList<String> receiveCollectionList(List<String> sqlValue, List<String> webText) {
        ArrayList<String> resultList = new ArrayList<String>();
        LinkedList<String> result = new LinkedList<String>(sqlValue);// 大集合用linkedlist
        HashSet<String> othHash = new HashSet<String>(webText);// 小集合用hashset（hashset是无重复元素的集合）
        Iterator<String> iter = othHash.iterator();// 采用Iterator迭代器进行数据的操作
        while(iter.hasNext()) {

            if(!result.contains(iter.next())) {//不包含就移除
                iter.remove();
            }
        }
        resultList = new ArrayList<String>(othHash);
        return resultList;
    }
}

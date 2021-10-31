package com.pearadmin.modules.sys.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.sys.domain.NewE;

/**
 * 获取文章Service接口
 * 
 * @author jmys
 * @date 2021-10-28
 */
public interface INewEService 
{
    /**
     * 查询获取文章
     * 
     * @param newid 获取文章ID
     * @return 获取文章
     */
    NewE selectNewEById(Long newid);


    /**
    * 查询获取文章
     * @param ${classsName} 获取文章
     * @param pageDomain
     * @return 获取文章 分页集合
     * */
    PageInfo<NewE> selectNewEPage(NewE newE, PageDomain pageDomain);

    /**
     * 查询获取文章列表
     * 
     * @param newE 获取文章
     * @return 获取文章集合
     */
    List<NewE> selectNewEList(NewE newE);

    /**
     * 新增获取文章
     * 
     * @param newE 获取文章
     * @return 结果
     */
    int insertNewE(NewE newE);

    /**
     * 修改获取文章
     * 
     * @param newE 获取文章
     * @return 结果
     */
    int updateNewE(NewE newE);

    /**
     * 批量删除获取文章
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteNewEByIds(String[] ids);

    /**
     * 删除获取文章信息
     * 
     * @param newid 获取文章ID
     * @return 结果
     */
    int deleteNewEById(Long newid);

}

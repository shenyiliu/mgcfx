package com.pearadmin.modules.sys.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.sys.mapper.NewEMapper;
import com.pearadmin.modules.sys.domain.NewE;
import com.pearadmin.modules.sys.service.INewEService;

/**
 * 获取文章Service业务层处理
 * 
 * @author jmys
 * @date 2021-10-28
 */
@Service
public class NewEServiceImpl implements INewEService 
{
    @Autowired
    private NewEMapper newEMapper;

    /**
     * 查询获取文章
     * 
     * @param newid 获取文章ID
     * @return 获取文章
     */
    @Override
    public NewE selectNewEById(Long newid)
    {
        return newEMapper.selectNewEById(newid);
    }

    /**
     * 查询获取文章列表
     * 
     * @param newE 获取文章
     * @return 获取文章
     */
    @Override
    public List<NewE> selectNewEList(NewE newE)
    {
        return newEMapper.selectNewEList(newE);
    }

    /**
     * 查询获取文章
     * @param newE 获取文章
     * @param pageDomain
     * @return 获取文章 分页集合
     * */
    @Override
    public PageInfo<NewE> selectNewEPage(NewE newE, PageDomain pageDomain)
    {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<NewE> data = newEMapper.selectNewEList(newE);
        return new PageInfo<>(data);
    }

    /**
     * 新增获取文章
     * 
     * @param newE 获取文章
     * @return 结果
     */

    @Override
    public int insertNewE(NewE newE)
    {
        return newEMapper.insertNewE(newE);
    }

    /**
     * 修改获取文章
     * 
     * @param newE 获取文章
     * @return 结果
     */
    @Override
    public int updateNewE(NewE newE)
    {
        return newEMapper.updateNewE(newE);
    }

    /**
     * 删除获取文章对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNewEByIds(String[] ids)
    {
        return newEMapper.deleteNewEByIds(ids);
    }

    /**
     * 删除获取文章信息
     * 
     * @param newid 获取文章ID
     * @return 结果
     */
    @Override
    public int deleteNewEById(Long newid)
    {
        return newEMapper.deleteNewEById(newid);
    }
}

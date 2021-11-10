package com.pearadmin.modules.sys.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.sys.mapper.GpMgcMapper;
import com.pearadmin.modules.sys.domain.GpMgc;
import com.pearadmin.modules.sys.service.IGpMgcService;

/**
 * 高频敏感词Service业务层处理
 * 
 * @author jmys
 * @date 2021-11-04
 */
@Service
public class GpMgcServiceImpl implements IGpMgcService 
{
    @Autowired
    private GpMgcMapper gpMgcMapper;

    /**
     * 查询高频敏感词
     * 
     * @param id 高频敏感词ID
     * @return 高频敏感词
     */
    @Override
    public GpMgc selectGpMgcById(Long id)
    {
        return gpMgcMapper.selectGpMgcById(id);
    }

    /**
     * 查询高频敏感词列表
     * 
     * @param gpMgc 高频敏感词
     * @return 高频敏感词
     */
    @Override
    public List<GpMgc> selectGpMgcList(GpMgc gpMgc)
    {
        return gpMgcMapper.selectGpMgcList(gpMgc);
    }

    /**
     * 查询高频敏感词
     * @param gpMgc 高频敏感词
     * @param pageDomain
     * @return 高频敏感词 分页集合
     * */
    @Override
    public PageInfo<GpMgc> selectGpMgcPage(GpMgc gpMgc, PageDomain pageDomain)
    {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<GpMgc> data = gpMgcMapper.selectGpMgcList(gpMgc);
        return new PageInfo<>(data);
    }

    /**
     * 新增高频敏感词
     * 
     * @param gpMgc 高频敏感词
     * @return 结果
     */

    @Override
    public int insertGpMgc(GpMgc gpMgc)
    {
        return gpMgcMapper.insertGpMgc(gpMgc);
    }

    /**
     * 修改高频敏感词
     * 
     * @param gpMgc 高频敏感词
     * @return 结果
     */
    @Override
    public int updateGpMgc(GpMgc gpMgc)
    {
        return gpMgcMapper.updateGpMgc(gpMgc);
    }

    /**
     * 删除高频敏感词对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGpMgcByIds(String[] ids)
    {
        return gpMgcMapper.deleteGpMgcByIds(ids);
    }

    /**
     * 删除高频敏感词信息
     * 
     * @param id 高频敏感词ID
     * @return 结果
     */
    @Override
    public int deleteGpMgcById(Long id)
    {
        return gpMgcMapper.deleteGpMgcById(id);
    }

    @Override
    public List<GpMgc> selectNum() {
        List<GpMgc> data = gpMgcMapper.selectNum();
        return data;
    }
}

package com.pearadmin.modules.sys.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.sys.domain.GpMgc;

/**
 * 高频敏感词Mapper接口
 * 
 * @author jmys
 * @date 2021-11-04
 */
@Mapper
public interface GpMgcMapper 
{
    /**
     * 查询高频敏感词
     * 
     * @param id 高频敏感词ID
     * @return 高频敏感词
     */
    public GpMgc selectGpMgcById(Long id);

    /**
     * 查询高频敏感词列表
     * 
     * @param gpMgc 高频敏感词
     * @return 高频敏感词集合
     */
    List<GpMgc> selectGpMgcList(GpMgc gpMgc);

    /**
     * 新增高频敏感词
     * 
     * @param gpMgc 高频敏感词
     * @return 结果
     */
    int insertGpMgc(GpMgc gpMgc);

    /**
     * 修改高频敏感词
     * 
     * @param gpMgc 高频敏感词
     * @return 结果
     */
    int updateGpMgc(GpMgc gpMgc);

    /**
     * 删除高频敏感词
     * 
     * @param id 高频敏感词ID
     * @return 结果
     */
    int deleteGpMgcById(Long id);

    /**
     * 批量删除高频敏感词
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteGpMgcByIds(String[] ids);

    /**
     * 查询高频敏感词列表
     *
     * @param
     * @return 高频敏感词集合
     */
    List<GpMgc> selectNum();

}

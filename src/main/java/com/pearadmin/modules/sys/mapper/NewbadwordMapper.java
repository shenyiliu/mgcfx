package com.pearadmin.modules.sys.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.sys.domain.Newbadword;

/**
 * 敏感词表Mapper接口
 * 
 * @author shenyi
 * @date 2021-11-02
 */
@Mapper
public interface NewbadwordMapper 
{
    /**
     * 查询敏感词表
     * 
     * @param id 敏感词表ID
     * @return 敏感词表
     */
    public Newbadword selectNewbadwordById(Long id);

    /**
     * 查询敏感词表列表
     * 
     * @param newbadword 敏感词表
     * @return 敏感词表集合
     */
    List<Newbadword> selectNewbadwordList(Newbadword newbadword);

    /**
     * 新增敏感词表
     * 
     * @param newbadword 敏感词表
     * @return 结果
     */
    int insertNewbadword(Newbadword newbadword);

    /**
     * 修改敏感词表
     * 
     * @param newbadword 敏感词表
     * @return 结果
     */
    int updateNewbadword(Newbadword newbadword);

    /**
     * 删除敏感词表
     * 
     * @param id 敏感词表ID
     * @return 结果
     */
    int deleteNewbadwordById(Long id);

    /**
     * 批量删除敏感词表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteNewbadwordByIds(String[] ids);

}

package com.pearadmin.modules.sys.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.sys.domain.NewE;

/**
 * 获取文章Mapper接口
 * 
 * @author jmys
 * @date 2021-10-28
 */
@Mapper
public interface NewEMapper 
{
    /**
     * 查询获取文章
     * 
     * @param newid 获取文章ID
     * @return 获取文章
     */
    public NewE selectNewEById(Long newid);

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
     * 删除获取文章
     * 
     * @param newid 获取文章ID
     * @return 结果
     */
    int deleteNewEById(Long newid);

    /**
     * 批量删除获取文章
     * 
     * @param newids 需要删除的数据ID
     * @return 结果
     */
    int deleteNewEByIds(String[] newids);

}

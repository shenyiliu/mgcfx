package com.pearadmin.modules.sys.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.sys.domain.Newbadword;
import org.springframework.web.multipart.MultipartFile;

/**
 * 敏感词表Service接口
 * 
 * @author shenyi
 * @date 2021-11-02
 */
public interface INewbadwordService 
{
    /**
     * 查询敏感词表
     * 
     * @param id 敏感词表ID
     * @return 敏感词表
     */
    Newbadword selectNewbadwordById(Long id);


    /**
    * 查询敏感词表
     * @param ${classsName} 敏感词表
     * @param pageDomain
     * @return 敏感词表 分页集合
     * */
    PageInfo<Newbadword> selectNewbadwordPage(Newbadword newbadword, PageDomain pageDomain);

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
     * 批量删除敏感词表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteNewbadwordByIds(String[] ids);

    /**
     * 删除敏感词表信息
     * 
     * @param id 敏感词表ID
     * @return 结果
     */
    int deleteNewbadwordById(Long id);

    /**
     * 导入
     * @return 结果
     */
    void importExclData(MultipartFile excl);
}

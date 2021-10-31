package com.pearadmin.modules.sys.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.sys.domain.Notice;

/**
 * 系统公告Mapper接口
 * 
 * @author jmys
 * @date 2021-10-16
 */
@Mapper
public interface NoticeMapper 
{
    /**
     * 查询系统公告
     * 
     * @param id 系统公告ID
     * @return 系统公告
     */
    public Notice selectNoticeById(Long id);

    /**
     * 查询系统公告列表
     * 
     * @param notice 系统公告
     * @return 系统公告集合
     */
    List<Notice> selectNoticeList(Notice notice);

    /**
     * 新增系统公告
     * 
     * @param notice 系统公告
     * @return 结果
     */
    int insertNotice(Notice notice);

    /**
     * 修改系统公告
     * 
     * @param notice 系统公告
     * @return 结果
     */
    int updateNotice(Notice notice);

    /**
     * 删除系统公告
     * 
     * @param id 系统公告ID
     * @return 结果
     */
    int deleteNoticeById(Long id);

    /**
     * 批量删除系统公告
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteNoticeByIds(String[] ids);

}

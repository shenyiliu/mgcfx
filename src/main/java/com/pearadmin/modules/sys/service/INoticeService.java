package com.pearadmin.modules.sys.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.sys.domain.Notice;

/**
 * 系统公告Service接口
 * 
 * @author jmys
 * @date 2021-10-16
 */
public interface INoticeService 
{
    /**
     * 查询系统公告
     * 
     * @param id 系统公告ID
     * @return 系统公告
     */
    Notice selectNoticeById(Long id);


    /**
    * 查询系统公告
     * @param ${classsName} 系统公告
     * @param pageDomain
     * @return 系统公告 分页集合
     * */
    PageInfo<Notice> selectNoticePage(Notice notice, PageDomain pageDomain);

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
     * 批量删除系统公告
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteNoticeByIds(String[] ids);

    /**
     * 删除系统公告信息
     * 
     * @param id 系统公告ID
     * @return 结果
     */
    int deleteNoticeById(Long id);

}

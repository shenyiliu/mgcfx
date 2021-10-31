package com.pearadmin.modules.sys.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.sys.mapper.NoticeMapper;
import com.pearadmin.modules.sys.domain.Notice;
import com.pearadmin.modules.sys.service.INoticeService;

/**
 * 系统公告Service业务层处理
 * 
 * @author jmys
 * @date 2021-10-16
 */
@Service
public class NoticeServiceImpl implements INoticeService 
{
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 查询系统公告
     * 
     * @param id 系统公告ID
     * @return 系统公告
     */
    @Override
    public Notice selectNoticeById(Long id)
    {
        return noticeMapper.selectNoticeById(id);
    }

    /**
     * 查询系统公告列表
     * 
     * @param notice 系统公告
     * @return 系统公告
     */
    @Override
    public List<Notice> selectNoticeList(Notice notice)
    {
        return noticeMapper.selectNoticeList(notice);
    }

    /**
     * 查询系统公告
     * @param notice 系统公告
     * @param pageDomain
     * @return 系统公告 分页集合
     * */
    @Override
    public PageInfo<Notice> selectNoticePage(Notice notice, PageDomain pageDomain)
    {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<Notice> data = noticeMapper.selectNoticeList(notice);
        return new PageInfo<>(data);
    }

    /**
     * 新增系统公告
     * 
     * @param notice 系统公告
     * @return 结果
     */

    @Override
    public int insertNotice(Notice notice)
    {
        return noticeMapper.insertNotice(notice);
    }

    /**
     * 修改系统公告
     * 
     * @param notice 系统公告
     * @return 结果
     */
    @Override
    public int updateNotice(Notice notice)
    {
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 删除系统公告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(String[] ids)
    {
        return noticeMapper.deleteNoticeByIds(ids);
    }

    /**
     * 删除系统公告信息
     * 
     * @param id 系统公告ID
     * @return 结果
     */
    @Override
    public int deleteNoticeById(Long id)
    {
        return noticeMapper.deleteNoticeById(id);
    }
}

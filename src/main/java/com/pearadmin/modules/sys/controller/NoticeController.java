package com.pearadmin.modules.sys.controller;

import com.github.pagehelper.PageInfo;

import com.pearadmin.common.tools.string.Convert;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.common.tools.secure.SecurityUtil;
import com.pearadmin.modules.sys.domain.Notice;
import com.pearadmin.modules.sys.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.pearadmin.modules.sys.service.INoticeService;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 系统公告Controller
 *
 * @author jmys
 * @date 2021-10-16
 */
@RestController
@RequestMapping("/system/notice")
public class NoticeController extends BaseController
{
    private String prefix = "system/notice";

    @Autowired
    private INoticeService noticeService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/system/notice/main','system:notice:main')")
    public ModelAndView main()
    {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询系统公告列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/system/notice/data','system:notice:data')")
    public ResultTable list(@ModelAttribute Notice notice, PageDomain pageDomain)
    {
        PageInfo<Notice> pageInfo = noticeService.selectNoticePage(notice,pageDomain);
        return pageTable(pageInfo.getList(),pageInfo.getTotal());
    }

    /**
     * 主页查询公告列表
     */
    @ResponseBody
    @GetMapping("/data-list")
    @PreAuthorize("hasPermission('/system/notice/data-list','system:notice:data')")
    public List<Notice> data_list(Notice notice)
    {
        return noticeService.selectNoticeList(notice);
    }

    /**
     * 主页查询公告列表
     */
    @ResponseBody
    @GetMapping("/data-list-id")
    @PreAuthorize("hasPermission('/system/notice/data-list-id','system:notice:data')")
    public Notice data_list_id(Long id)
    {
        return noticeService.selectNoticeById(id);
    }


    /**
     * 新增系统公告
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/system/notice/add','system:notice:add')")
    public ModelAndView add()
    {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增保存系统公告
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/system/notice/add','system:notice:add')")
    public Result save(@RequestBody Notice notice)
    {

        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date=new Date();
        notice.setNoticetime(format.format(date));

        SysUser sysUser = (SysUser)SecurityUtil.currentUserObj();
        notice.setCreateTime(LocalDateTime.now());
        notice.setCreateBy(sysUser.getUserId());
        notice.setCreateName(sysUser.getUsername());
        return decide(noticeService.insertNotice(notice));
    }

    /**
     * 修改系统公告
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/system/notice/edit','system:notice:edit')")
    public ModelAndView edit(Long id, ModelMap mmap)
    {
        Notice notice = noticeService.selectNoticeById(id);
        mmap.put("notice", notice);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改保存系统公告
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/system/notice/edit','system:notice:edit')")
    public Result update(@RequestBody Notice notice)
    {

        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date=new Date();
        notice.setNoticetime(format.format(date));

        SysUser sysUser = (SysUser)SecurityUtil.currentUserObj();
        notice.setUpdateTime(LocalDateTime.now());
        notice.setUpdateBy(sysUser.getUserId());
        notice.setUpdateName(sysUser.getUsername());
        return decide(noticeService.updateNotice(notice));
    }

    /**
     * 删除系统公告
     */
    @ResponseBody
    @DeleteMapping( "/batchRemove")
    @PreAuthorize("hasPermission('/system/notice/remove','system:notice:remove')")
    public Result batchRemove(String ids)
    {
        return decide(noticeService.deleteNoticeByIds(Convert.toStrArray(ids)));
    }

    /**
     * 删除
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/system/notice/remove','system:notice:remove')")
    public Result remove(@PathVariable("id") Long id)
    {
        return decide(noticeService.deleteNoticeById(id));
    }
}

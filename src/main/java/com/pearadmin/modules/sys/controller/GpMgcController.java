package com.pearadmin.modules.sys.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.modules.sys.domain.GpMgc;
import com.pearadmin.common.tools.string.Convert;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.common.tools.secure.SecurityUtil;
import com.pearadmin.modules.sys.domain.SysUser;
import com.pearadmin.modules.sys.service.IGpMgcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.time.LocalDateTime;
import java.util.List;

/**
 * 高频敏感词Controller
 *
 * @author jmys
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/system/mgc")
public class GpMgcController extends BaseController
{
    private String prefix = "system/mgc";

    @Autowired
    private IGpMgcService gpMgcService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/system/mgc/main','system:mgc:main')")
    public ModelAndView main()
    {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询高频敏感词列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/system/mgc/data','system:mgc:data')")
    public ResultTable list(@ModelAttribute GpMgc gpMgc, PageDomain pageDomain)
    {
        PageInfo<GpMgc> pageInfo = gpMgcService.selectGpMgcPage(gpMgc,pageDomain);
        return pageTable(pageInfo.getList(),pageInfo.getTotal());
    }

    /**
     * 新增高频敏感词
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/system/mgc/add','system:mgc:add')")
    public ModelAndView add()
    {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增保存高频敏感词
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/system/mgc/add','system:mgc:add')")
    public Result save(@RequestBody GpMgc gpMgc)
    {
        SysUser sysUser = (SysUser)SecurityUtil.currentUserObj();
        gpMgc.setCreateTime(LocalDateTime.now());
        gpMgc.setCreateBy(sysUser.getUserId());
        gpMgc.setCreateName(sysUser.getUsername());
        return decide(gpMgcService.insertGpMgc(gpMgc));
    }

    /**
     * 修改高频敏感词
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/system/mgc/edit','system:mgc:edit')")
    public ModelAndView edit(Long id, ModelMap mmap)
    {
        GpMgc gpMgc = gpMgcService.selectGpMgcById(id);
        mmap.put("gpMgc", gpMgc);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改保存高频敏感词
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/system/mgc/edit','system:mgc:edit')")
    public Result update(@RequestBody GpMgc gpMgc)
    {
        SysUser sysUser = (SysUser)SecurityUtil.currentUserObj();
        gpMgc.setUpdateTime(LocalDateTime.now());
        gpMgc.setUpdateBy(sysUser.getUserId());
        gpMgc.setUpdateName(sysUser.getUsername());
        return decide(gpMgcService.updateGpMgc(gpMgc));
    }

    /**
     * 删除高频敏感词
     */
    @ResponseBody
    @DeleteMapping( "/batchRemove")
    @PreAuthorize("hasPermission('/system/mgc/remove','system:mgc:remove')")
    public Result batchRemove(String ids)
    {
        return decide(gpMgcService.deleteGpMgcByIds(Convert.toStrArray(ids)));
    }

    /**
     * 删除
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/system/mgc/remove','system:mgc:remove')")
    public Result remove(@PathVariable("id") Long id)
    {
        return decide(gpMgcService.deleteGpMgcById(id));
    }


    /**
     * 查询高频敏感词列表
     */
    @ResponseBody
    @GetMapping("/gpMgcList")
    @PreAuthorize("hasPermission('/system/mgc/gpMgcList','system:mgc:gpMgcList')")
    public List<GpMgc> gpMgcList()
    {
        return gpMgcService.selectNum();
    }
}

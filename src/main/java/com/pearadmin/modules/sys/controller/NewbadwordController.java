package com.pearadmin.modules.sys.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.modules.sys.domain.Newbadword;
import com.pearadmin.common.tools.string.Convert;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.common.tools.secure.SecurityUtil;
import com.pearadmin.modules.sys.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.pearadmin.modules.sys.service.INewbadwordService;

import java.time.LocalDateTime;

/**
 * 敏感词表Controller
 *
 * @author shenyi
 * @date 2021-11-02
 */
@RestController
@RequestMapping("/system/newbadword")
public class NewbadwordController extends BaseController
{
    private String prefix = "system/newbadword";

    @Autowired
    private INewbadwordService newbadwordService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/system/newbadword/main','system:newbadword:main')")
    public ModelAndView main()
    {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询敏感词表列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/system/newbadword/data','system:newbadword:data')")
    public ResultTable list(@ModelAttribute Newbadword newbadword, PageDomain pageDomain)
    {
        PageInfo<Newbadword> pageInfo = newbadwordService.selectNewbadwordPage(newbadword,pageDomain);
        return pageTable(pageInfo.getList(),pageInfo.getTotal());
    }

    /**
     * 新增敏感词表
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/system/newbadword/add','system:newbadword:add')")
    public ModelAndView add()
    {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增保存敏感词表
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/system/newbadword/add','system:newbadword:add')")
    public Result save(@RequestBody Newbadword newbadword)
    {
        SysUser sysUser = (SysUser)SecurityUtil.currentUserObj();
        newbadword.setCreateTime(LocalDateTime.now());
        newbadword.setCreateBy(sysUser.getUserId());
        newbadword.setCreateName(sysUser.getUsername());
        return decide(newbadwordService.insertNewbadword(newbadword));
    }

    /**
     * 修改敏感词表
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/system/newbadword/edit','system:newbadword:edit')")
    public ModelAndView edit(Long id, ModelMap mmap)
    {
        Newbadword newbadword = newbadwordService.selectNewbadwordById(id);
        mmap.put("newbadword", newbadword);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改保存敏感词表
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/system/newbadword/edit','system:newbadword:edit')")
    public Result update(@RequestBody Newbadword newbadword)
    {
        SysUser sysUser = (SysUser)SecurityUtil.currentUserObj();
        newbadword.setUpdateTime(LocalDateTime.now());
        newbadword.setUpdateBy(sysUser.getUserId());
        newbadword.setUpdateName(sysUser.getUsername());
        return decide(newbadwordService.updateNewbadword(newbadword));
    }

    /**
     * 删除敏感词表
     */
    @ResponseBody
    @DeleteMapping( "/batchRemove")
    @PreAuthorize("hasPermission('/system/newbadword/remove','system:newbadword:remove')")
    public Result batchRemove(String ids)
    {
        return decide(newbadwordService.deleteNewbadwordByIds(Convert.toStrArray(ids)));
    }

    /**
     * 删除
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/system/newbadword/remove','system:newbadword:remove')")
    public Result remove(@PathVariable("id") Long id)
    {
        return decide(newbadwordService.deleteNewbadwordById(id));
    }

    /**
     * 导入文件
     */
    @RequestMapping(value = "/importFile",method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasPermission('/system/newbadword/importFile','system:newbadword:importFile')")
    public boolean importFile(@RequestParam("file") MultipartFile excl){
        System.out.println("-------------"+excl);
        newbadwordService.importExclData(excl);
        return false;
    }


}

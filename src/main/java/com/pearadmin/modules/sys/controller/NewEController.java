package com.pearadmin.modules.sys.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.mgcfx.main.main;
import com.pearadmin.common.plugin.logging.aop.annotation.Logging;
import com.pearadmin.common.plugin.logging.aop.enums.BusinessType;
import com.pearadmin.modules.sys.domain.NewE;
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
import org.springframework.web.servlet.ModelAndView;
import com.pearadmin.modules.sys.service.INewEService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取文章Controller
 *
 * @author jmys
 * @date 2021-10-28
 */
@RestController
@RequestMapping("/system/newe")
public class NewEController extends BaseController
{
    private String prefix = "system/newe";

    @Autowired
    private INewEService newEService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/system/newe/main','system:newe:main')")
    public ModelAndView main()
    {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询获取文章列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/system/newe/data','system:newe:data')")
    @Logging(title = "查询文章", describe = "查询文章", type = BusinessType.QUERY)
    public ResultTable list(@ModelAttribute NewE newE, PageDomain pageDomain)
    {
        PageInfo<NewE> pageInfo = newEService.selectNewEPage(newE,pageDomain);
        return pageTable(pageInfo.getList(),pageInfo.getTotal());
    }

    /**
     * 新增获取文章
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/system/newe/add','system:newe:add')")
    public ModelAndView add()
    {
        return jumpPage(prefix + "/add");
    }



    /**
     * 新增保存获取文章
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/system/newe/add','system:newe:add')")
    @Logging(title = "新增文章", describe = "新增文章", type = BusinessType.ADD)
    public Result save(@RequestBody NewE newE) throws ParseException {
        SysUser sysUser = (SysUser)SecurityUtil.currentUserObj();

        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=format.format(new Date());
        newE.setCollecttime(format.parse(date));

        newE.setCreateTime(LocalDateTime.now());//LocalDateTime.now()
        newE.setCreateBy(sysUser.getUserId());
        newE.setCreateName(sysUser.getUsername());
        return decide(newEService.insertNewE(newE));
    }

    /**
     * 修改获取文章
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/system/newe/edit','system:newe:edit')")

    public ModelAndView edit(Long newid, ModelMap mmap)
    {
        NewE newE = newEService.selectNewEById(newid);
        mmap.put("newE", newE);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改保存获取文章
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/system/newe/edit','system:newe:edit')")
    @Logging(title = "修改文章", describe = "修改文章", type = BusinessType.EDIT)
    public Result update(@RequestBody NewE newE)
    {
        SysUser sysUser = (SysUser)SecurityUtil.currentUserObj();
        newE.setUpdateTime(LocalDateTime.now());
        newE.setUpdateBy(sysUser.getUserId());
        newE.setUpdateName(sysUser.getUsername());
        return decide(newEService.updateNewE(newE));
    }

    /**
     * 删除获取文章
     */
    @ResponseBody
    @DeleteMapping( "/batchRemove")
    @PreAuthorize("hasPermission('/system/newe/remove','system:newe:remove')")
    @Logging(title = "批量删除文章", describe = "批量删除文章", type = BusinessType.REMOVE)
    public Result batchRemove(String ids)
    {
        return decide(newEService.deleteNewEByIds(Convert.toStrArray(ids)));
    }

    /**
     * 删除
     */
    @ResponseBody
    @DeleteMapping("/remove/{newid}")
    @PreAuthorize("hasPermission('/system/newe/remove','system:newe:remove')")
    @Logging(title = "删除文章", describe = "删除文章", type = BusinessType.REMOVE)
    public Result remove(@PathVariable("newid") Long newid)
    {
        return decide(newEService.deleteNewEById(newid));
    }

    /**
     * 爬取文章
     */
    @GetMapping("/hq")
    @PreAuthorize("hasPermission('/system/newe/hq','system:newe:hq')")
    public ModelAndView hq()
    {
        return jumpPage(prefix + "/hq");
    }

    /**
     * 爬取保存文章
     */
    @GetMapping("/newSave")
    @PreAuthorize("hasPermission('/system/newe/hqSave','system:newe:hqSave')")
    public Result newSave(String newurl) throws Exception {

        NewE n=new NewE();
        main a=new main();
        String str=a.getText(newurl);

        //正则匹配
        //标题
        String title="(?<=正文)([\\s\\S]*)?(?=来源)";
        String titleNew=a.regexContext(title,str);

        //来源
        String ly="(?<=来源：)([\\s\\S]*)?(?=作者)";
        String lyNew=a.regexContext(ly,str);

        //作者
        String author="(?<=作者：)([\\s\\S]*)?(?=编辑)";
        String authorNew=a.regexContext(author,str);

        //发布时间
        String fbTime="(?<=发布时间：)([\\s\\S]*)?(?=点击次数)";
        String fbTimeNew=a.regexContext(fbTime,str);

        //添加数据
        n.setNewurl(newurl);
        n.setNewtitle(titleNew);
        n.setNewsource(lyNew);
        n.setNewauthor(authorNew);
        n.setNewcontent(str);


        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日");
        n.setNewcreatetime(format.parse(fbTimeNew));
        n.setCollecttime(format.parse(format.format(new Date())));


        //ArrayList all= a.fixArrayList(a.mysqlValue("bad_word"),a.getWebText(newurl));
        //System.out.println("敏感词："+all);
        //System.out.println("敏感词数："+all.size()+"个");
        return decide(newEService.insertNewE(n));

    }


    /**
     * 修改分析文章
     */
    @GetMapping("/fx")
    @PreAuthorize("hasPermission('/system/newe/fx','system:newe:fx')")
    public ModelAndView fx(Long newid) throws Exception {

        ModelAndView mv=new ModelAndView();
        NewE newE = newEService.selectNewEById(newid);
        main a=new main();
        ArrayList all= a.fixArrayList(a.mysqlValue("bad_word"),a.getWebText(newE.getNewurl()));
//        System.out.println("敏感词："+all);
//        System.out.println("敏感词数："+all.size()+"个");
        mv.addObject("newE",newE);
        mv.addObject("mgc",all);
        mv.setViewName(prefix + "/fx");

        return mv;
    }
}

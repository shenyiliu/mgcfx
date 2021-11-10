package com.pearadmin.modules.sys.service.impl;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.sys.context.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.sys.mapper.NewbadwordMapper;
import com.pearadmin.modules.sys.domain.Newbadword;
import com.pearadmin.modules.sys.service.INewbadwordService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 敏感词表Service业务层处理
 * 
 * @author shenyi
 * @date 2021-11-02
 */
@Service
public class NewbadwordServiceImpl implements INewbadwordService 
{
    @Autowired
    private NewbadwordMapper newbadwordMapper;

    /**
     * 查询敏感词表
     * 
     * @param id 敏感词表ID
     * @return 敏感词表
     */
    @Override
    public Newbadword selectNewbadwordById(Long id)
    {
        return newbadwordMapper.selectNewbadwordById(id);
    }

    /**
     * 查询敏感词表列表
     * 
     * @param newbadword 敏感词表
     * @return 敏感词表
     */
    @Override
    public List<Newbadword> selectNewbadwordList(Newbadword newbadword)
    {
        return newbadwordMapper.selectNewbadwordList(newbadword);
    }

    /**
     * 查询敏感词表
     * @param newbadword 敏感词表
     * @param pageDomain
     * @return 敏感词表 分页集合
     * */
    @Override
    public PageInfo<Newbadword> selectNewbadwordPage(Newbadword newbadword, PageDomain pageDomain)
    {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<Newbadword> data = newbadwordMapper.selectNewbadwordList(newbadword);
        return new PageInfo<>(data);
    }

    /**
     * 新增敏感词表
     * 
     * @param newbadword 敏感词表
     * @return 结果
     */

    @Override
    public int insertNewbadword(Newbadword newbadword)
    {
        return newbadwordMapper.insertNewbadword(newbadword);
    }

    /**
     * 修改敏感词表
     * 
     * @param newbadword 敏感词表
     * @return 结果
     */
    @Override
    public int updateNewbadword(Newbadword newbadword)
    {
        return newbadwordMapper.updateNewbadword(newbadword);
    }

    /**
     * 删除敏感词表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNewbadwordByIds(String[] ids)
    {
        return newbadwordMapper.deleteNewbadwordByIds(ids);
    }

    /**
     * 删除敏感词表信息
     * 
     * @param id 敏感词表ID
     * @return 结果
     */
    @Override
    public int deleteNewbadwordById(Long id)
    {
        return newbadwordMapper.deleteNewbadwordById(id);
    }


    /**
     * 导入
     * @return 结果
     */
    @Override
    public void importExclData(MultipartFile excl) {
        InputStream in = null;
        try {
            in = excl.getInputStream();
            // 获取execl文件对象
            Workbook workbook = null;
            // 根据后缀，得到不同的Workbook子类，即HSSFWorkbook或XSSFWorkbook
            if (excl.getOriginalFilename().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(in);//给定输入流读取文件创建XLSX操作对象
            } else if (excl.getOriginalFilename().endsWith("xls")) {
                workbook = new HSSFWorkbook(in);//给定输入流读取文件创建XLS操作对象
            } else {
                throw new Exception("文件格式不对或者文件损坏....");
            }
            // 获得sheet对应对象 获取第一页对象
            Sheet sheet = workbook.getSheetAt(0);
            // 创建Station对象容器
            // 解析sheet,获得多行数据，并放入迭代器中
            Iterator<Row> ito = sheet.iterator();

            Row row = null;
            int count = 0;
            while (ito.hasNext()) {

                row = ito.next();
                // 由于第一行是标题因此这里单独处理
                if (count == 0) {
                    ++count;
                    continue;
                } else {
                    if (row != null) {
                        Newbadword newbadword=new Newbadword();

                        String badword=row.getCell(0).getRichStringCellValue().toString();
                        String kind=row.getCell(1).getRichStringCellValue().toString();

                        newbadword.setBadword(badword);
                        newbadword.setKind(kind);


                        //依次添加，因为oracle最大可容纳1000游标，只能依次添加
                        newbadwordMapper.insertNewbadword(newbadword);

                    }
                }

            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}

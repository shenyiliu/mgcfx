package com.pearadmin.common.mgcfx.tool.Mysql;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcelToMysql {
    /**
     *   1.本类为读取Excel文件至数据库
     * @param excelpath   Excel文件地址
     * @param sql    sql语句
     * @param startrow  读取Excel开始行
     * @param rows    总行数
     * @param coloumNum  总列数
     * @throws Exception
     */

    public static void ExcelToMysql(String excelpath,String sql,int startrow,int rows,int coloumNum) throws Exception {
        String excelPath = excelpath;
        File excel = new File(excelPath);
        PreparedStatement stmt = LinkMysql.conn.prepareStatement(sql);//填值进入数据库
        try {
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在
                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb;      //创建Workbook对象
                //根据文件后缀（xls/xlsx）进行判断
                if ( "xls".equals(split[1])){
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);     //创建Excel，读取文件内容

                    //两种方式读取工作表
                    //  HSSFSheet sheet=workbook.getSheet("Sheet0");
                    HSSFSheet sheet = (HSSFSheet) wb.getSheetAt(0);  //getSheetAt 的参数是索引，getSheet的参数是sheet的名称，获取具体名称的sheet
                   // int rows = sheet.getPhysicalNumberOfRows();   //获取sheet表的行数
//                    int coloumNum = sheet.getRow(0).getPhysicalNumberOfCells();    //获取sheet表的列数

                    for (int i = startrow; i < rows; i++) {    //i为行数数，
                        for (int j = 0; j < coloumNum; j++) {   //j为列数，
                            HSSFRow row = sheet.getRow(i);  //获取sheet中行索引
                            HSSFCell cell = row.getCell(j);   //获取当前最后一个单元格列索引
                            //   if (row.getRowNum() == 0) continue;       //首行不读取
                            cell.setCellType(CellType.STRING);//设置单元格类型


                            String stringcellvalue = cell.getStringCellValue();  //将上面索引对应的单元格值赋给stringcellvalue变量
                            stmt.setString(j+1,""+stringcellvalue);//每个值加一个空格确保无空值（空指针）异常
                            //   System.out.print(getEquelsLength(stringcellvalue,15));          //输出单元格值
                        }stmt.addBatch();
                        System.out.println(i);
                    }stmt.executeBatch();//批量更新数据

                    CloseMysql.close();
                    fis.close();

                }
                else if ("xlsx".equals(split[1])){
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);     //创建Excel，读取文件内容

                    //两种方式读取工作表
                    //  HSSFSheet sheet=workbook.getSheet("Sheet0");
                    HSSFSheet sheet = (HSSFSheet) wb.getSheetAt(0);  //getSheetAt 的参数是索引，getSheet的参数是sheet的名称，获取具体名称的sheet
//                    int rows = sheet.getPhysicalNumberOfRows();   //获取sheet表的行数
//                    int coloumNum = sheet.getRow(0).getPhysicalNumberOfCells();    //获取sheet表的列数


                    for (int i = startrow; i < rows; i++) {    //i为行数数，
                        for (int j = 0; j < coloumNum; j++) {   //j为列数，
                            HSSFRow row = sheet.getRow(i);  //获取sheet中行索引

                            HSSFCell cell = row.getCell(j);   //获取当前最后一个单元格列索引
                            //   if (row.getRowNum() == 0) continue;       //首行不读取
                            cell.setCellType(CellType.STRING);//设置单元格类型

                            String stringcellvalue = cell.getStringCellValue();  //将上面索引对应的单元格值赋给stringcellvalue变量

                            stmt.setString(j+1,stringcellvalue);

//                        System.out.print(getEquelsLength(stringcellvalue,23));          //输出单元格值
                        }stmt.addBatch();//增加一条记录
                    }stmt.executeBatch();//批量更新数据
                    CloseMysql.close();
                    fis.close();
                }
            }else {
                System.out.println("文件类型错误!");
                return;
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}


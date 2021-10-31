package com.pearadmin.common.mgcfx.testmain;


import com.pearadmin.common.mgcfx.tool.Mysql.CloseMysql;
import com.pearadmin.common.mgcfx.tool.Mysql.ExcelToMysql;
import com.pearadmin.common.mgcfx.tool.Mysql.LinkMysql;

public class ExcelToSqlTest {
    public static void main(String[] args) throws Exception {
      String sql= LinkMysql.insertsql("newbadword",3);//输入数据库表名和，所需插入的数据库字段数目，以得到sql语句
        ExcelToMysql.ExcelToMysql("C:\\Users\\Lenovo\\Desktop\\bad_world.xls",sql,1,4189,3);//Excel文件地址,sql语句，
        CloseMysql.close();
    }
}

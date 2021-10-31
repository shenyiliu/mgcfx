package com.pearadmin.common.mgcfx.tool.Mysql;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;


public class GetValueToMysql {
       private static ArrayList<String> a=new ArrayList<String>();
       private static  String[] tempo;
    public static ArrayList<String> readsql(String sqls) throws Exception {

//执行数据库的sq语句
                // PreparedStatement 预编译
                PreparedStatement ps_struts= LinkMysql.conn.prepareStatement(sqls);
                //ResultSet查询数据库数据
                ResultSet rs_struts = ps_struts.executeQuery();
//获取Connection对象所连接的数据库的元数据。元数据包括关于数据库的表
                ResultSetMetaData rsm = rs_struts.getMetaData();
//getRowCount 获取数据库表行的数量  getColumnCount获取列的数量
                int columnCount = rsm.getColumnCount();


//循环数据库表中的每一行,来得到每一行的数据
                while (rs_struts.next()) {
                    tempo = new String[columnCount];
                    for (int i = 0; i < columnCount; i++) {
//getMetaData().getColumnName(i);字段名
                        String columnName = rs_struts.getMetaData().getColumnName(i + 1);
                        tempo[i] = rs_struts.getString(columnName);  //tempo存的是每个字段的数据
//设置单元格内容
                        a.add(tempo[i]);
                    }
              CloseMysql.close();//引包关sql
            // JOptionPane.showMessageDialog(null, "导出完成");
        }
    return a;

    }

}
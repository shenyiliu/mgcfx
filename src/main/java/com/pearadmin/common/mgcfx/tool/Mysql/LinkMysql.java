package com.pearadmin.common.mgcfx.tool.Mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LinkMysql {
    /**
     * 插入sql的方法
     * @param MysqlTableName  所要插入的Mysql的表名
     * @param MysqlFieldNum   所需要的表的字段数
     * @return    返回sql语句 例如insert into test01 values (?,?,?,?,?,?,?,?,?)
     * @throws Exception
     */
    public static String insertsql(String MysqlTableName,int MysqlFieldNum) throws Exception {
        String sql = "insert into "+MysqlTableName+" values ("+num(MysqlFieldNum)+")";
        Class.forName(driver);
        return sql;
    }
    /**
     * 访问sql的方法
     * @param MysqlTableName  所需要读取的Mysql的表名
     * @return  返回sql语句，
     * @throws Exception
     */
    public static String inquirysql(String MysqlTableName) throws Exception {
        String sql = "select * from "+MysqlTableName+"";
        Class.forName(driver);
        return sql;
    }

    /**
     * 辅助写sql语句选择插入的数据库字段数，作用是添加例如 insert into test01 values (?,?,?,?,?,?,?,?,?)中的问号数量
     * @param a  传入所需要的问号数，即字段数
     * @return
     */
    private static String num(int a){
        String b="?,";
        for (int i = 1; i <a ; i++) {
            if (i+1==a){
                b+="?";
            }else b+="?,";
        }return b;
    }

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/"+"pear-admin"+"?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";;
    private static String user = "root";
    private static String password = "123456";
    static Connection conn;
    static  {
        try {
            conn = (Connection) DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

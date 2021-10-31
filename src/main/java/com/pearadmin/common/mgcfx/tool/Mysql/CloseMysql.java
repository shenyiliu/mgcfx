package com.pearadmin.common.mgcfx.tool.Mysql;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CloseMysql {
    /**
     *   工具类，关闭连接数据库
     */
    public static void close() {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                preparedStatement = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
                resultSet = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static Connection connection = null;
    //PreparedStatement比Statement访问速度更快。能防止sql注入
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet;
}

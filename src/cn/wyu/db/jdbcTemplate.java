package cn.wyu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcTemplate {
    /**
     * 查询操作
     * @param pscreator
     * @param callbackHandler
     */
    public static void query(PreparedStatementCreator pscreator,
                             RowCallbackHandler callbackHandler) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBHelp.getConnection();
            preparedStatement = pscreator.createPreparedStatement(connection);
            resultSet = preparedStatement.executeQuery();

            //遍历结果集
            while(resultSet.next()){
                callbackHandler.processRow(resultSet);
            }
        } catch (ClassNotFoundException e) {
            throw new DataAccessException("jdbcTemplate中的ClassNotFoundException异常",e);
        } catch (SQLException e) {
            throw new DataAccessException("jdbcTemplate中的SQLException异常",e);
        } finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DataAccessException("不能关闭数据库连接",e);
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new DataAccessException("不能释放语句对象",e);
                }
            }
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DataAccessException("不能关闭结果集对象",e);
                }
            }
        }
    }

    /**
     * 修改操作
     * @param pscreator
     */
    public static int update(PreparedStatementCreator pscreator) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int count = 0;
        try {
            connection = DBHelp.getConnection();
            preparedStatement = pscreator.createPreparedStatement(connection);
            count = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new DataAccessException("jdbcTemplate中的ClassNotFoundException异常",e);
        } catch (SQLException e) {
            throw new DataAccessException("jdbcTemplate中的SQLException异常",e);
        } finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DataAccessException("不能关闭数据库连接",e);
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new DataAccessException("不能释放语句对象",e);
                }
            }
        }
        return count;
    }
}

package cn.wyu.DaoImple;

import cn.wyu.Dao.UsersDao;
import cn.wyu.Domain.Users;
import cn.wyu.bean.PageInfo;
import cn.wyu.db.PreparedStatementCreator;
import cn.wyu.db.RowCallbackHandler;
import cn.wyu.db.jdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersImple implements UsersDao {
    boolean flag = false;
    String sql = null;
    Long totalCount = 0L;
    Users user = null;
    @Override
    public Users queryByUser(String userName, String password) {
        List<Users> list = new ArrayList();
        sql = "select userId,userNo,userName,password,className,isStu,isAdmin from users where userName=? and password=?;";
        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preStatement = conn.prepareStatement(sql);
                preStatement.setString(1, userName);
                preStatement.setString(2, password);
                return preStatement;


            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                Users user = new Users();
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setClassName(rs.getString("className"));
                user.setUserNo(rs.getString("userNo"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                user.setIsStu(rs.getInt("isStu"));
                user.setUserId(rs.getInt("userId"));
                list.add(user);
            }
        });

        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean isExist(String No) {
        sql = "select count(*) from users where userNo=?";
        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preStatement = conn.prepareStatement(sql);
                preStatement.setString(1, No);
                return preStatement;
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                int count = rs.getInt(1);
                if (count > 0) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        });
        return flag;
    }

    @Override
    public PageInfo queryByCurrent(int currentPage) {
        List<Users> list = new ArrayList();
        PageInfo pageInfo = null;
        sql = "select * from users limit ?,?";
        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preStatement = conn.prepareStatement(sql);
                preStatement.setInt(1, (currentPage-1)*5);
                preStatement.setInt(2, 5);
                return preStatement;
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                Users user = new Users();
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setClassName(rs.getString("className"));
                user.setUserNo(rs.getString("userNo"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                user.setIsStu(rs.getInt("isStu"));
                user.setUserId(rs.getInt("userId"));
                list.add(user);
            }
        });
        sql = "select count(*) from users";
        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preStatement = conn.prepareStatement(sql);
                return preStatement;
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                totalCount = rs.getLong(1);
            }
        });
        pageInfo = new PageInfo(list,currentPage,totalCount);
        return pageInfo;
    }

   /* @Override
    public PageInfo queryAll() {
        List<Users> list = new ArrayList();
        String sql = "select * from users";
        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preStatement = conn.prepareStatement(sql);
                return preStatement;
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                Users user = new Users();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setClassName(rs.getString("className"));
                user.setUserNo(rs.getString("userNo"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                user.setIsStu(rs.getInt("isStu"));
                user.setUserId(rs.getInt("userId"));
                list.add(user);
            }
        });
        return list;
    }*/

    @Override
    public boolean addUsers(String name, String no, String pwd, String classname, int isStu) {
        String sql = "insert into users(userNo,userName,password,className,isStu,isAdmin) values(?,?,?,?,?,?)";
        int count;
        count = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preStatement = conn.prepareStatement(sql);
                preStatement.setString(1, no);
                preStatement.setString(2, name);
                preStatement.setString(3, pwd);
                preStatement.setString(4, classname);
                preStatement.setInt(5, isStu);
                preStatement.setInt(6, 0);
                return preStatement;
            }
        });
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int deleteById(int id) {
        sql = "delete from users where userId = ?";
        int count = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1,id);
                return preparedStatement;
            }
        });
        return count;
    }

    @Override
    public Users queryById(int id) {
        sql = "select * from users where userId=?";

        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                return preparedStatement;
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                user = new Users();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserNo(rs.getString("userNo"));
                user.setClassName(rs.getString("className"));
                user.setPassword(rs.getString("password"));
                user.setIsStu(rs.getInt("isStu"));
                user.setIsAdmin(rs.getInt("isAdmin"));
            }
        });
        return user;
    }

    @Override
    public int updateUser(int userId, int isStu, String userName, String userNo, String password, String className) {
        sql = "update users set isStu=?,userName=?,userNo=?,password=?,className=? where userId=?";
        int count = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1,isStu);
                preparedStatement.setString(2,userName);
                preparedStatement.setString(3,userNo);
                preparedStatement.setString(4,password);
                preparedStatement.setString(5,className);
                preparedStatement.setInt(6,userId);
                return preparedStatement;
            }
        });
        return count;
    }

    @Override
    public boolean updateUser(String no,String name,String classname,int id) {
        sql = "update users set userNo=?,userName=?,className=? where userId=?";
        int count = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,no);
                preparedStatement.setString(2,name);
                preparedStatement.setString(3,classname);
                preparedStatement.setInt(4,id);
                return preparedStatement;
            }
        });
        if(count==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int updateUserByUser(int id, String password) {

        List<Users> list = new ArrayList();
        sql = "update users set password=? where userId = ?;";
        int count = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preStatement = conn.prepareStatement(sql);
                preStatement.setString(1, password);
                preStatement.setInt(2, id);
                return preStatement;
            }
        });
        return count;
    }

   /* @Override
    public int updateUser(int id,int isStu, String userName, String userNo, String password, String className) {

    }*/
}

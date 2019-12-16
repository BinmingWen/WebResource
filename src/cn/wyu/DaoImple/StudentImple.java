package cn.wyu.DaoImple;

import cn.wyu.Dao.StudentsDao;
import cn.wyu.Domain.Students;
import cn.wyu.db.PreparedStatementCreator;
import cn.wyu.db.RowCallbackHandler;
import cn.wyu.db.jdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentImple implements StudentsDao {
    //public static jdbcTemplate jdbcTemplate;
    @Override
    public void insert(Students students) {

    }

    @Override
    public Students queryByStu(String userName,String password) {
        List<Students> list = new ArrayList();
        String sql = "select studentId,password,class,name,majorOrEle,teacher,selfDescn from students where name=? and password=?;";
        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preStatement = conn.prepareStatement(sql);
                preStatement.setString(1,userName);
                preStatement.setString(2,password);
                return preStatement;


            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                Students student = new Students();
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setClassName(rs.getInt("class"));
                student.setMajorOrEle(rs.getInt("majorOrEle"));
                student.setStudentId(rs.getInt("studentId"));
                student.setTeacher(rs.getString("teacher"));
                student.setSelfDescn(rs.getString("selfDescn"));
                list.add(student);
            }
        });

        if(list.size()==1){
            return list.get(0);
        }else {
            return null;
        }

    }

    @Override
    public List<Students> queryAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void modify(int id) {

    }
}

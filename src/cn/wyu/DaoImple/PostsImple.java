package cn.wyu.DaoImple;

import cn.wyu.Dao.PostsDao;
import cn.wyu.Domain.Posts;
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

public class PostsImple implements PostsDao {
    String sql = null;
    Posts post = null;
    Long totalRecorders = 0l;
    @Override
    public int insert(Posts posts) {
        sql = "insert into posts(name,postDate,content,isExcellent,isWorld) values(?,?,?,?,?)";
        int count = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,posts.getName());
                preparedStatement.setString(2,posts.getPostDate());
                preparedStatement.setString(3,posts.getContent());
                preparedStatement.setInt(4,posts.getIsExcellent());
                preparedStatement.setInt(5,posts.getIsWorld());
                return preparedStatement;
            }
        });
        return  count;

    }

    @Override
    public Posts queryById(int id) {
        sql = "select * from posts where postId=?";
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
                post = new Posts();
                post.setPostId(rs.getInt("postId"));
                post.setName(rs.getString("name"));
                post.setPostDate(rs.getString("postDate"));
                post.setContent(rs.getString("content"));
                post.setIsExcellent(rs.getInt("isExcellent"));
                post.setIsWorld(rs.getInt("isWorld"));
            }
        });
        return post;
    }

    @Override
    public List<Posts> queryAll() {
        return null;
    }

    @Override
    public int deleteById(int id) {
        sql = "delete from posts where postId=?";
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
    public void modify(int id) {

    }

    @Override
    public PageInfo queryByCurPage(Integer currentPage) {
        List<Posts> list = new ArrayList<>();
        sql = "select * from posts limit ?,?";
        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, (currentPage - 1) * 5);
                preparedStatement.setInt(2, 5);
                return preparedStatement;
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                post = new Posts();
                post.setPostId(rs.getInt("postId"));
                post.setName(rs.getString("name"));
                post.setPostDate(rs.getString("postDate"));
                post.setContent(rs.getString("content"));
                post.setIsExcellent(rs.getInt("isExcellent"));
                post.setIsWorld(rs.getInt("isWorld"));
                list.add(post);
            }
        });
        sql = "select count(*) from posts";
        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                return preparedStatement;
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                totalRecorders = rs.getLong(1);
            }
        });
        PageInfo pageInfo = new PageInfo(list,currentPage,totalRecorders);
        return pageInfo;
    }

    @Override
    public int updatePost(Posts post) {
        sql = "update posts set name=?,postDate=?,content=?,isExcellent=?,isWorld=? where postId=?";
        int count = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,post.getName());
                preparedStatement.setString(2,post.getPostDate());
                preparedStatement.setString(3,post.getContent());
                preparedStatement.setInt(4,post.getIsExcellent());
                preparedStatement.setInt(5,post.getIsWorld());
                preparedStatement.setInt(6,post.getPostId());
                return preparedStatement;
            }
        });
        return count;
    }
}

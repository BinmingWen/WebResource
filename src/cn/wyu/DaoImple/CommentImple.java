package cn.wyu.DaoImple;

import cn.wyu.Dao.CommentDao;
import cn.wyu.Domain.Comment;
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

public class CommentImple implements CommentDao {
    String sql = null;
    Comment comment = null;
    Long totalRecorders = 0l;
    @Override
    public int insertCom(Comment comment) {
        sql = "insert into comment(Com_content,com_postId,comName) values(?,?,?)";
        int count = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, comment.getComContent());
                preparedStatement.setInt(2, comment.getCom_postId());
                preparedStatement.setString(3,comment.getComName());
                return preparedStatement;
            }
        });
        return count;
    }

    @Override
    public List<Comment> queryAll() {
        List<Comment> list = new ArrayList<>();
        sql = "select * from comment";
        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                return preparedStatement;
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                comment = new Comment();
                comment.setCom_postId(rs.getInt("Com_postId"));
                comment.setComContent(rs.getString("com_content"));
                comment.setCommentId(rs.getInt("CommentId"));
                comment.setComName(rs.getString("comName"));
                list.add(comment);
            }
        });
        return list;
    }

    @Override
    public PageInfo queryByAll(Integer currentPage) {
        /*List<Comment> list = new ArrayList<>();
        sql = "select * from comment limit ?,?";
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
                C
                post.setPostId(rs.getInt("postId"));
                post.setName(rs.getString("name"));
                post.setPostDate(rs.getString("postDate"));
                post.setContent(rs.getString("content"));
                post.setIsExcellent(rs.getString("isExcellent"));
                post.setIsWorld(rs.getString("isWorld"));
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
        PageInfo pageInfo = new PageInfo(list,currentPage,totalRecorders);*/
        return null;
    }
}

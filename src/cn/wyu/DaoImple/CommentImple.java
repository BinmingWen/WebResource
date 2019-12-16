package cn.wyu.DaoImple;

import cn.wyu.Dao.CommentDao;
import cn.wyu.Domain.Comment;
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
    @Override
    public int insertCom(Comment comment) {
        sql = "insert into comment(Com_content,com_postId) values(?,?)";
        int count = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, comment.getComContent());
                preparedStatement.setInt(2, comment.getCom_postId());
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
                list.add(comment);
            }
        });
        return list;
    }
}

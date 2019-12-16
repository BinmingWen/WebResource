package cn.wyu.DaoImple;

import cn.wyu.Dao.ResourceDao;
import cn.wyu.Domain.Resource;
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

public class ResourceImple implements ResourceDao {
    String sql = null;
    Long totalCount = 0L;
    Resource resource=null;
    @Override
    public int insert(Resource resource) {

        sql = "insert into resource (uploaderName,name,descn,type,fileName,saveFileName) values(?,?,?,?,?,?) ";
        int count = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setString(1,resource.getUploaderName());
                preparedStatement.setString(2,resource.getName());
                preparedStatement.setString(3,resource.getDescn());
                preparedStatement.setString(4,resource.getType());
                preparedStatement.setString(5,resource.getFileName());
                preparedStatement.setString(6,resource.getSaveFileName());

                return preparedStatement;
            }
        });
        return count;
    }

    @Override
    public Resource queryById(int id) {
        sql = "select resourceId,uploaderName,name,descn,type,fileName from resource where resourceId=?";
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
                resource = new Resource();
                resource.setResourceId(rs.getInt("resourceId"));
                resource.setUploaderName(rs.getString("uploaderName"));
                resource.setName(rs.getString("name"));
                resource.setDescn(rs.getString("descn"));
                resource.setType(rs.getString("type"));
                resource.setFileName(rs.getString("fileName"));
            }
        });
        return resource;
    }

    @Override
    public List<Resource> queryAll() {
        return null;
    }

    @Override
    public int deleteById(int id) {

        sql = "delete from resource where resourceId = ?";
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
    public PageInfo queryByAll(Integer currentPage) {
        List<Resource> list = new ArrayList<>();
        PageInfo pageinfo = null;
        sql = "select resourceId,uploaderName,name,descn,type,fileName,saveFileName from resource limit ?,?";
        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preStatement = conn.prepareStatement(sql);
                preStatement.setInt(1,(currentPage-1)*5);
                preStatement.setInt(2,5);
                return preStatement;
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                Resource resource = new Resource();
                resource.setResourceId(rs.getInt("resourceId"));
                resource.setUploaderName(rs.getString("uploaderName"));
                resource.setName(rs.getString("name"));
                resource.setDescn(rs.getString("descn"));
                resource.setType(rs.getString("type"));
                resource.setFileName(rs.getString("fileName"));
                resource.setSaveFileName(rs.getString("saveFileName"));
                list.add(resource);

            }
        });
        sql = "select count(*) from resource";
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
        pageinfo = new PageInfo(list,currentPage,totalCount);
        return pageinfo;
    }

    @Override
    public int updateByRe(Resource resource) {
        sql = "update resource set uploaderName=?,name=?,descn=?,type=?,fileName=? where resourceId = ?";
        int count = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,resource.getUploaderName());
                preparedStatement.setString(2,resource.getName());
                preparedStatement.setString(3,resource.getDescn());
                preparedStatement.setString(4,resource.getType());
                preparedStatement.setString(5,resource.getFileName());
                preparedStatement.setInt(6,resource.getResourceId());
                return preparedStatement;
            }
        });

        return count;
    }
}

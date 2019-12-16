package cn.wyu.db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 处理结果集
 */
public interface RowCallbackHandler {
        void processRow(ResultSet rs) throws SQLException;

}

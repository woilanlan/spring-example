package top.woilanlan.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(List.class)
public class ListStringHandler extends BaseTypeHandler<List<String>> {

    /**
     * 设置参数
     * @param ps
     * @param i
     * @param parameter 对应的是User类的 favorites 属性
     * @param jdbcType
     * @throws SQLException
     */
    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        StringBuffer sb = new StringBuffer();
        for (String s : parameter) {
            sb.append(s).append(";");
        }
        ps.setString(i,sb.toString());
    }

    public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String s = rs.getString(columnName);
        if(s!=null){
            return Arrays.asList(s.split(";"));
        }
        return null;
    }

    public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String s = rs.getString(columnIndex);
        if(s!=null) {
            return Arrays.asList(s.split(";"));
        }
        return null;
    }

    public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String s = cs.getString(columnIndex);
        if(s!=null) {
            return Arrays.asList(s.split(";"));
        }
        return null;
    }
}

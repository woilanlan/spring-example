package com.longlong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            //修改隔离级别
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            //开启事务
            conn.setAutoCommit(false);

            for (int i=0;i<3;i++) {
                //打断点，debug调试，运行 Main，测试脏读和不可重复读
                ps = conn.prepareStatement("select * from account");
                rs = ps.executeQuery();
                while (rs.next()){
                    System.out.println(rs.getString("name")+">>>"+rs.getFloat("money"));
                }
            }

            //提交事务
            conn.commit();
        } catch (Exception e) {
            try {
                //事务回滚
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
    }
}

package com.longlong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
create table account(
	id int primary key auto_increment,
	name varchar(40),
	money float
)character set utf8 collate utf8_general_ci;
*/

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            //开启事务
            conn.setAutoCommit(false);

            ps = conn.prepareStatement("update account set money = money+100 where name = ?;");
            ps.setString(1,"zhangsan");
            ps.executeUpdate();

            //提交事务
            //脏读和不可重复读的区别事务是否提交
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

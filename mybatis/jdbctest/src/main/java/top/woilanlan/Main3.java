package top.woilanlan;

import java.sql.*;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&useSSL=false&useUnicode=true&serverTimezone=UTC"
                , "root", "Longlong");
        PreparedStatement ps = conn.prepareStatement("insert into t_book (b_name,author) values (?,?);",Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,"朝花夕拾");
        ps.setString(2,"鲁迅");
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int anInt = rs.getInt(1);
        System.out.println(anInt);
    }
}

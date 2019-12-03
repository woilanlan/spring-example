package top.woilanlan;

import java.sql.*;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String address = scanner.nextLine();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&useSSL=false&useUnicode=true&serverTimezone=UTC"
                , "root", "Longlong");
        PreparedStatement ps = conn.prepareStatement("select count(*) from t_user where name = ? and address = ?");
        ps.setString(1,username);
        ps.setString(2,address);
        ResultSet rs = ps.executeQuery();

        if(rs.next() && rs.getInt(1)>0){
            System.out.println("登录成功");
        }
    }
}

package top.woilanlan;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //username输入：王五' #
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String address = scanner.nextLine();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&useSSL=false&useUnicode=true&serverTimezone=UTC"
                , "root", "Longlong");
        Statement statement = conn.createStatement();
        //拼接字符串不安全
        ResultSet rs = statement.executeQuery("select count(*) from t_user where name = '" + username
                + "' and address = '" + address + "'");
        if(rs.next() && rs.getInt(1)>0){
            System.out.println("登录成功");
        }
    }
}

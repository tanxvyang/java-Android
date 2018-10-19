package jdbc.test;

import java.sql.*;
import java.util.Scanner;

public class test2 {
    private static String driverClassName="com.mysql.jdbc.Driver";
    private  static  String url="jdbc:mysql://192.168.140.1:3306/jdbc";
    private  static  String username="root" ;
    private  static  String password="610322";

    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        System.out.println("用户登录");
        System.out.println("用户名:");
        String user=sc.nextLine();
        System.out.println("密码:");
        String pwd=sc.nextLine();
        selectByUsernameAndPassword(user,pwd);
    }

    public static  void  selectByUsernameAndPassword(String user,String pwd){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            Class.forName(driverClassName);
            con=DriverManager.getConnection(url,username,password);

            String sql=new StringBuffer()
                    .append("select * ")
                    .append("from t_user ")
                    .append("where username= ?")
                    .append("and password = ?")
                    .toString();
            ps=con.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,pwd);
            rs=ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



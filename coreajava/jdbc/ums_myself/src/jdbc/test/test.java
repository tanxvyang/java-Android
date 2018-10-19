package jdbc.test;//package jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.Scanner;
//
//public class test {
//    private static String driverClassName="com.mysql.jdbc.Driver";
//    private  static  String url="jdbc:mysql://192.168.140.1:3306/jdbc";
//    private  static  String username="root" ;
//    private  static  String password="610322";
//
//    public static void main(String[] args) {
//      //  Scanner sc=new Scanner(String[] args){
//
//        }
//    }
//    public static  void  selectByUsernameAndPassword(String user,String pwd){
//        Connection con =null;
//        Statement st=null;
//        ResultSet rs=null;
//        try {
//            Class.forName(driverClassName);
//            con=DriverManager.getConnection(url,username,password);
//            st=con.createStatement();
//            String sql=new StringBuffer()
//                    .append("select * ")
//                    .append("from t_user ")
//                    .append("where username= '"+user+"'")
//                    .append("and password = '"+pwd+"'")
//                    .toString();
//            rs=st.executeQuery(sql);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

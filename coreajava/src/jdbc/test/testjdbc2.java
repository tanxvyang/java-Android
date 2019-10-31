package jdbc.test;

import java.sql.*;

public class testjdbc2 {
    private static String driverClassName="com.mysql.jdbc.Driver";
    private  static  String url="jdbc:mysql://10.0.0.1:3306/txy";
    private  static  String username="root" ;
    private  static  String password="tan610322";

    public static void main(String[] args) {
        create();
//        insert("aaa");
//        insert("1','abc");
   //     delectById(2);




    }

    public static void create(){
        Connection con=null;
        PreparedStatement ps=null;
        try {
            Class.forName(driverClassName);
            con=DriverManager.getConnection(url,username,password);
            String sql=new StringBuffer()
                    .append("create table t_test( ")
                    .append(" id int primary key auto_increment,  ")
                    .append("name  varchar(10)")
                    .append(" )")
                    .toString();


            ps=con.prepareStatement(sql);

            ps.executeLargeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void insert() {
        Connection con=null;
        Statement st=null;
        PreparedStatement ps=null;
        try {
            Class.forName(driverClassName);
            con=DriverManager.getConnection(url, username, password);
            st=con.createStatement();

            String sql=new StringBuilder()
                    .append("insert into t_test ")
                    .append("    (name) ")
                    .append("values ")
                    .append("    (?)")
                    .toString();
            ps=con.prepareStatement(sql);
            ps.setString('1',"name");
            ps.executeLargeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void delectById(){
        Connection con=null;
        Statement st=null;
        PreparedStatement ps=null;
        try {
            Class.forName(driverClassName);
            con=DriverManager.getConnection(url, username, password);
            st=con.createStatement();

            String sql=new StringBuilder()
                    .append("delete from t_test  ")
                    .append("where id =?")

                    .toString();
            ps=con.prepareStatement(sql);

            ps.executeLargeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }




    public static void updateNameById(int id,String name){
        Connection con=null;
        Statement st=null;
        PreparedStatement ps=null;
        try {
            Class.forName(driverClassName);
            con=DriverManager.getConnection(url, username, password);
            st=con.createStatement();

            String sql=new StringBuilder()
                    .append("update t_test ")
                    .append(" set name=? ")
                    .append("set id=? ")
                    .append(" ")
                    .toString();
            ps=con.prepareStatement(sql);
            ps.setString('1',"name");
            ps.executeLargeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void selectAll() {
        Connection con=null;
        Statement st=null;
        PreparedStatement ps=null;
        try {
            Class.forName(driverClassName);
            con=DriverManager.getConnection(url, username, password);
            st=con.createStatement();

            String sql=new StringBuilder()
                    .append("select *  ")
                    .append(" from t_test ")
                    .toString();
            ps=con.prepareStatement(sql);
            ps.executeLargeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public static  void selectNmae(){
        Connection con=null;
        Statement st=null;
        PreparedStatement ps=null;
        try {
            Class.forName(driverClassName);
            con=DriverManager.getConnection(url, username, password);
            st=con.createStatement();

            String sql=new StringBuilder()
                    .append("select * ")
                    .append("  from t_test ")
//                    .append("where name =?")
                    .append("where name like ")
                    .append(" ")
                    .toString();
            ps=con.prepareStatement(sql);

            ps.executeLargeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

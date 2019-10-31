package jdbc.test;
import java.sql.*;

public class TestJDBC {
    private static String driverClassName="com.mysql.jdbc.Driver";
    private  static  String url="jdbc:mysql://10.0.0.1:3306/txy";
    private  static  String username="root" ;
    private  static  String password="610322";

    public static void main(String[] args)  {
        create();
       //  insert();
       //  delete();
       // update();
       // selectAll();
       //  selectById(3);
       //  selectByname("e3");
    }

    public static void selectByname(String name){
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            Class.forName(driverClassName);
            con=DriverManager.getConnection(url,username,password);

            String sql=new  StringBuilder()
                    .append("select* ")
                    .append(" from ")
                    .append(" t_emp ")
                    .append("where name=" +(name)+ " ")
                    .toString();
            rs=st.executeQuery(sql);
            while (rs.next()){

               int id=rs.getInt("id");

                System.out.println(id+"\t"+name);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (st!=null){
                try {
                    st.close();
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
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void selectById(int id){
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            Class.forName(driverClassName);
            con=DriverManager.getConnection(url,username,password);
            st=con.createStatement();
            String sql=new  StringBuilder()
                    .append("select * ")
                    .append(" from  ")
                    .append("t_emp ")
                    .append("where id="+id+" ")
                    .toString();
            rs=st.executeQuery(sql);
            if (rs.next()){

                String name=rs.getString("name");

                System.out.println(name);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (st!=null){
                try {
                    st.close();
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
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void selectAll(){
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            Class.forName(driverClassName);//1.注册驱动//百度www.baidu.com页面--查看元素,控制台
            con=DriverManager.getConnection(url,username,password);
            st=con.createStatement();
            String sql=new  StringBuilder()
                    .append("select* ")
                    .append("from ")
                    .append("t_user")
                    .toString();

            rs=st.executeQuery(sql);//查询调用

            System.out.println("id\tname");
            while (rs.next()){
//                int id=rs.getInt(1);//列下标
//                String name=rs.getString(2);//
                int id=rs.getInt("id");//
                String name=rs.getString("name");

                System.out.println(id+"\t"+name);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(st!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (con!=null){
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (rs!=null){
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }

    public static void delete() {
        Connection con=null;
        Statement st=null;

        try {
            Class.forName(driverClassName);
            con=DriverManager.getConnection(url,username,password);

            st=con.createStatement();


            String sql=new StringBuilder()  //要求sql语句使用 StringBuffer() .append(b);
                    .append("delete from t_user ")
                    .append("where id=2 ")
                    .toString();


            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if(st!=null){
                try {
                    st.close();
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

//        Connection con=null;
//        Statement st=null;
//        try {
//            Class.forName(driverClassName);
//            con=DriverManager.getConnection(url,username,password);
//
//            st=con.createStatement();
//
//            String sql=new StringBuilder()
//                    .append("delete from t_user ")
//                    .append("where id=1 ")
//                    .toString();
//
//            st.executeUpdate(sql);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if(st!=null){
//                try {
//                    st.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(con!=null){
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

    }

    public static void update(){
        Connection con=null;
        Statement st=null;
        try {
            Class.forName(driverClassName);
            con=DriverManager.getConnection(url,username,password);
            st=con.createStatement();
            String sql=new StringBuffer()
                    .append("update t_user ")
                    .append("set name='eee' ")
                    .append("where id=3 ")
                    .toString();
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(st!=null){
                try {
                    st.close();
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
        try {
            Class.forName(driverClassName);
            con=DriverManager.getConnection(url, username, password);
            st=con.createStatement();

            String sql=new StringBuilder()
                    .append("insert into t_user ")
                    .append("    (name) ")
                    .append("values ")
                    .append("    ('abc')")
                    .toString();

            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(st!=null){
                try {
                    st.close();
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


    public static void create(){
        Connection con=null;
        Statement st=null;



        //---------------------------------------------------------------------------------------

        try {
            //1.注册驱动
//            Driver  driver = new com.mysql.jdbc.Driver();  //方式1
//            DriverManager.registerDriver(driver);
            Class.forName(driverClassName);                 //方式2

            //2.获得连接
            con=DriverManager.getConnection(url,username,password);
            //  System.out.println(con);

            //3.获得操作对象
            st=con.createStatement();

            String sql=new  StringBuffer()  //要求sql语句使用 StringBuffer() .append(b);
                    .append("create table t_user(")
                    .append(" id int primary key auto_increment,  ")
                    .append("name  varchar(10)")
                    .append(" )")
                    .toString();


            //4.发送sql语句并执行
            st.execute(sql);
            //5.处理结果集


        } catch (Exception e) {
            e.printStackTrace();
        }finally {//b必须执行的代码//6.关闭资源
            if (st!=null){
                try {
                    st.close();
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
        }


    }
}

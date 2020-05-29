package jdbc.test;

import java.sql.*;

public class Testjdbc3 {
    private static String driverClassName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/jdbc";//192.168.140.1
    private static String username = "root";
    private static String password = "610322";

    public static void main(String[] args) {
        //create();
        //	insert("aaa");
//			insert("1','abc");
//	deleteById(2);
//		updateNameById(1, "bbb");
        // 	selectAll();
        selectByName("b");
    }


    public static void create() {

        Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName(driverClassName);
            con = DriverManager.getConnection(url, username, password);
            String sql = new StringBuffer()
                    .append("create table t_test( ")
                    .append("	id int primary key auto_increment, ")
                    .append("	name varchar(10) ")
                    .append(") ")
                    .toString();
            ps = con.prepareStatement(sql);

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void insert(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName(driverClassName);
            con = DriverManager.getConnection(url, username, password);

            String sql = new StringBuffer()
                    .append("insert into t_test ")
                    .append("    (name) ")
                    .append("values ")
                    .append("    (?) ")
                    .toString();

            ps = con.prepareStatement(sql);

            ps.setString(1, name);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName(driverClassName);
            con = DriverManager.getConnection(url, username, password);

            String sql = new StringBuffer()
                    .append("delete from t_test ")
                    .append("where id=? ")
                    .toString();

            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void updateNameById(int id, String name) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName(driverClassName);
            con = DriverManager.getConnection(url, username, password);

            String sql = new StringBuffer()
                    .append("update t_test ")
                    .append("set name=? ")
                    .append("where id=? ")
                    .toString();

            ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void selectAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName(driverClassName);
            con = DriverManager.getConnection(url, username, password);

            String sql = new StringBuffer()
                    .append("select * ")
                    .append("from t_test ")
                    .toString();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void selectByName(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName(driverClassName);
            con = DriverManager.getConnection(url, username, password);

            String sql = new StringBuffer()
                    .append("select * ")
                    .append("from t_test ")
//				.append("where name=? ")
                    .append("where name like ? ")
                    .toString();

            ps = con.prepareStatement(sql);

//			ps.setString(1, name);
            ps.setString(1, name + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

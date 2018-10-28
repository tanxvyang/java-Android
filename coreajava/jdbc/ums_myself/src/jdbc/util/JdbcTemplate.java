package jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcTemplate {
    public void update(String sql,Object[] params){
        Connection con=null;
        PreparedStatement ps=null;
              try {
                  con=JdbcUtil.getConnection();
                  ps=con.prepareStatement(sql);
                  for (int i < 0 ; i < params.length ; i++){

                  }


              }catch (Exception e){

              }finally {
                  JdbcUtil.close(null,ps,con);

              }

    }

}

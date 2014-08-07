import models.UserModel;

import java.sql.*;
import java.util.List;

/**
 * Created by deepak.pai on 07/08/14.
 */
public class ConnectMe {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/peekaboo";

    static final String USER = "root";
    static final String PASS = "avengerrocks";

    public List<UserModel> getAllUsers(){
        List<UserModel> users=null;
        String sql = "SELECT * FROM Users";
        ResultSet rs = executeQuery(sql);

        try {
            while(rs.next()){
                users.add(new UserModel(rs.getInt("phno")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    private ResultSet executeQuery(String sql){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return rs;
        }
    }
}

package Hotel.MySQL;

import Hotel.DB.QueryMySQL;
import Hotel.DBEntity.Roomuser;

import java.sql.*;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLUtil {

    private Connection con = null;

    public Connection getConnection() {
        Locale.setDefault(Locale.ENGLISH);
        Properties connInfo = new Properties();
        connInfo.put("user", QueryMySQL.USER);
        connInfo.put("password", QueryMySQL.PASSWORD);
        connInfo.put("useUnicode", "true");
        connInfo.put("charSet", "UTF8");
        try {
            Class.forName(QueryMySQL.CLASS_DRV);
            con = DriverManager.getConnection(QueryMySQL.URL, connInfo);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QueryMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void closeAll(ResultSet rs, PreparedStatement ps, Connection con) {
        try {
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLOrderDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void close(PreparedStatement ps, Connection con) {
        try {
            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLOrderDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeCall(CallableStatement cs, Connection con) {
        try {
            cs.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLOrderDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void myRollback(Connection con) {
        try {
            con.rollback();
        } catch (SQLException ex1) {
            Logger.getLogger(MySQLOrderDAO.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }

    public Roomuser extractUser(ResultSet rs) throws SQLException {
        Roomuser user = new Roomuser();
        user.setId(rs.getInt(1));
        user.setULogin(rs.getString(3));
        user.setUPass(rs.getString(4));
        user.setUName(rs.getString(2));
        user.setUPhone(rs.getString(6));
        user.setUMail(rs.getString(5));
        user.setStatus(rs.getString(7));
        return user;
    }

}

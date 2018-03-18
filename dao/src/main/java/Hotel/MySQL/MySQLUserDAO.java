package Hotel.MySQL;

import Hotel.DB.IDAO.UserDAO;
import Hotel.DB.QueryMySQL;
import Hotel.DBEntity.Roomuser;

import java.sql.*;

public class MySQLUserDAO implements UserDAO {

    private Connection con = null;

    private MySQLUtil util = new MySQLUtil();

    @Override
    public Roomuser login(String uLogin, String uPass) {
        Roomuser user = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = util.getConnection();
        try {
            ps = con.prepareStatement(QueryMySQL.FIND_USER);
            ps.setString(1, uLogin);
            ps.setString(2, uPass);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = util.extractUser(rs);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException in method login");
        } finally {
            assert rs != null;
            MySQLUtil.closeAll(rs, ps, con);
        }
        return user;
    }

    @Override
    public boolean regUser(Roomuser user) {
        boolean flag = true;
        CallableStatement cs = null;
        try {
            con = util.getConnection();
            System.out.println("prepareCall00");
            cs = con.prepareCall(QueryMySQL.REG_USER);
            System.out.println("prepareCall");
            System.out.println(cs);
            cs.setString(1, user.getUName());
            cs.setString(2, user.getULogin());
            cs.setString(3, user.getUPass());
            cs.setString(4, user.getUMail());
            cs.setString(5, user.getUPhone());
            cs.setString(6, "0");
            cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println(cs);
            System.out.println("dfsdgdsgsdgds");
            flag = false;
        } finally {
            if (cs != null) {
                MySQLUtil.closeCall(cs, con);
            }
        }
        return flag;
    }
}

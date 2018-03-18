package Hotel.MySQL;

import Hotel.DB.IDAO.OrderDAO;
import Hotel.DB.QueryMySQL;
import Hotel.Entity.Order;
import Hotel.DBEntity.Room;
import Hotel.DBEntity.Roomuser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLOrderDAO implements OrderDAO {

    private Connection con = null;

    private MySQLUtil util = new MySQLUtil();

    @Override
    public boolean roomHistoryInsert(Room room, String dateStart, String dateEnd, Roomuser user, Integer roomStatus) {
        boolean flag;
        PreparedStatement ps;
        con = util.getConnection();
        boolean myFlag = false;
        List<Room> listRoom = new ArrayList<>();
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement(QueryMySQL.LOAD_ROOM);
            ps.setString(1, dateEnd);
            ps.setString(2, dateStart);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            MySQLRoomDAO.loadListRooms(listRoom, rs);
            for (Room currentRoom : listRoom) {
                if (currentRoom.getRoomNum() == room.getRoomNum()) {
                    myFlag = true;
                }
            }
            if (myFlag) {
                ps = con.prepareStatement(QueryMySQL.ADD_ORDER);
                ps.setInt(1, room.getRoomNum());
                ps.setString(2, dateStart);
                ps.setString(3, dateEnd);
                ps.setInt(4, user.getId());
                ps.setString(5, user.getUName());
                ps.setString(6, user.getUMail());
                ps.setString(7, user.getUPhone());
                ps.setInt(8, roomStatus);
                ps.executeUpdate();
                con.commit();
                flag = true;
            } else {
                flag = false;
                MySQLUtil.myRollback(con);
            }
        } catch (SQLException | NumberFormatException e) {
            flag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flag;
    }

    @Override
    public boolean updateStatusOrder(Room room, Integer status) {
        boolean flag = true;
        PreparedStatement ps = null;
        con = util.getConnection();
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement(QueryMySQL.UPDATE_STATUS_ORDER);
            ps.setInt(1, status);
            ps.setInt(2, room.getRoomNum());
            ps.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            flag = false;
            MySQLUtil.myRollback(con);
        } finally {
            if (ps != null) {
                MySQLUtil.close(ps, con);
            }
        }
        return flag;
    }

    @Override
    public List<Order> loadRommHistory(Roomuser user) {
        List<Order> listOrder = new ArrayList<>();
        con = util.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(QueryMySQL.LOAD_ROOMHISTORY_FOR_USER);
            ps.setInt(1, user.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer roomNum = rs.getInt(1);
                float price = rs.getFloat(4);
                String dateStart = rs.getString(2);
                String dateEnd = rs.getString(3);
                String status = rs.getString(5);
                listOrder.add(new Order(roomNum, dateStart, dateEnd, price, status));
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                MySQLUtil.closeAll(rs, ps, con);
            }
        }
        return listOrder;
    }

    @Override
    public List<Order> loadRoomHistory(Integer status) {
        List<Order> listOrder = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = util.getConnection();
            ps = con.prepareStatement(QueryMySQL.LOAD_ROOMHISTORY);
            ps.setInt(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer roomNum = rs.getInt(1);
                float price = rs.getFloat(6);
                String dateStart = rs.getString(2);
                String dateEnd = rs.getString(3);
                String uName = rs.getString(4);
                String uPhone = rs.getString(5);
                listOrder.add(new Order(roomNum, dateStart, dateEnd, uName, uPhone, price));
            }
        } catch (SQLException ex) {
        } finally {
            if (rs != null) {
                MySQLUtil.closeAll(rs, ps, con);
            }
        }
        return listOrder;
    }
}

package Hotel.MySQL;

import Hotel.DB.IDAO.RoomDAO;
import Hotel.DB.QueryMySQL;
import Hotel.DBEntity.Room;
import Hotel.DBEntity.Roomtype;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLRoomDAO implements RoomDAO {

    private Connection con = null;

    private MySQLUtil util = new MySQLUtil();

    @Override
    public List<Room> loadRoomCatalog(String roomType, String dateStart, String dateEnd) {
        List<Room> listRoom = new ArrayList<>();
        con = util.getConnection();
        PreparedStatement ps = null;
        try {
            Integer id_int = Integer.valueOf(roomType);
            ps = con.prepareStatement(QueryMySQL.LOAD_ROOM_CATALOG);
            ps.setInt(1, id_int);
            ps.setString(2, dateEnd);
            ps.setString(3, dateStart);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            loadListRooms(listRoom, rs);
        } catch (SQLException ex) {
            System.out.println("SQLException in method loadRoomCatalog");
        } finally {
            assert ps != null;
            MySQLUtil.close(ps, con);
        }
        return listRoom;
    }

    static void loadListRooms(List<Room> listRoom, ResultSet rs) throws SQLException {
        while (rs.next()) {
            Integer roomNumber = rs.getInt(1);
            String roomDescript = rs.getString(2);
            float roomPrice = rs.getFloat(3);
            String roomPhoto = rs.getString(4);
            Room room = new Room().setRoomNum(roomNumber).setRate(roomPrice).setDescript(roomDescript).setSrcPhoto(roomPhoto);
            listRoom.add(room);
        }
    }


    @Override
    public List<Roomtype> loadRoomType() {
        List<Roomtype> listRoomType = new ArrayList<>();
        con = util.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(QueryMySQL.LOAD_ROOM_TYPE);
            rs = ps.executeQuery();
            while (rs.next()) {
                listRoomType.add(new Roomtype(rs.getInt("ID"), rs.getString("ROOM_TYPE")));
            }
        } catch (Exception e) {
            System.out.println("Exception in method loadRoomType");
        } finally {
            assert rs != null;
            MySQLUtil.closeAll(rs, ps, con);
        }
        return listRoomType;
    }
}

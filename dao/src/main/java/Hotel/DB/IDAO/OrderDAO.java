package Hotel.DB.IDAO;

import Hotel.Entity.Order;
import Hotel.DBEntity.Room;
import Hotel.DBEntity.Roomuser;

import java.util.List;

public interface OrderDAO {

    boolean roomHistoryInsert(Room room, String dateStart, String dateEnd, Roomuser user, Integer roomStatus);

    boolean updateStatusOrder(Room room, Integer status);

    List<Order> loadRommHistory(Roomuser user);

    List<Order> loadRoomHistory(Integer status);

}

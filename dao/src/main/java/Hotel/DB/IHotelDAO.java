package Hotel.DB;

import Hotel.Entity.Order;
import Hotel.DBEntity.Room;
import Hotel.DBEntity.Roomtype;
import Hotel.DBEntity.Roomuser;
import java.util.List;

public interface IHotelDAO {

    //UserDAO
    Roomuser login(String uLogin, String uPass);

    boolean regUser(Roomuser user);

    //OrderDAO
    boolean roomHistoryInsert(Room room, String dateStart, String dateEnd, Roomuser user, Integer roomStatus);

    boolean updateStatusOrder(Room room, Integer status);

    List<Order> loadRommHistory(Roomuser user);

    List<Order> loadRoomHistory(Integer status);
    
    //RoomDAO
    List<Room> loadRoomCatalog(String roomType, String dateStart, String dateEnd);

    List<Roomtype> loadRoomType();

}

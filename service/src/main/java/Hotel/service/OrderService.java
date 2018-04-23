package Hotel.service;

import Hotel.additionalEntity.Order;
import Hotel.entity.Room;
import Hotel.entity.Roomuser;

import java.util.List;

public interface OrderService {

    int roomHistoryInsert(Room room, String dateStart, String dateEnd, Roomuser user, Integer roomStatus);

    int updateStatusOrder(Room room, String dateStart, String dateEnd, Integer status);

    List<Order> loadRommHistory(Roomuser user);

    List<Order> loadRoomHistory(Integer status);

}

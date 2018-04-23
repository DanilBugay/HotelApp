package Hotel.service;

import Hotel.entity.Room;
import Hotel.entity.Roomtype;

import java.util.List;

public interface RoomService {

    List<Room> loadRoomCatalog(String roomType, String dateStart, String dateEnd);

    List<Roomtype> loadRoomType();
}

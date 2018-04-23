package Hotel.dao.IDAO;

import Hotel.entity.Room;
import Hotel.entity.Roomtype;
import java.util.List;

public interface RoomDAO{

    List<Room> loadRoomCatalog(String roomType, String dateStart, String dateEnd);

    List<Roomtype> loadRoomType();

}

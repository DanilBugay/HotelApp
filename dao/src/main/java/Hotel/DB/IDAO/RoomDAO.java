package Hotel.DB.IDAO;

import Hotel.DBEntity.Room;
import Hotel.DBEntity.Roomtype;
import java.util.List;

public interface RoomDAO{

    List<Room> loadRoomCatalog(String roomType, String dateStart, String dateEnd);

    List<Roomtype> loadRoomType();

}

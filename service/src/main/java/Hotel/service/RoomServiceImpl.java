package Hotel.service;

import Hotel.dao.IDAO.RoomDAO;
import Hotel.entity.Room;
import Hotel.entity.Roomtype;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service("room-service")
public class RoomServiceImpl implements RoomService {

    @Inject
    private RoomDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<Room> loadRoomCatalog(String roomType, String dateStart, String dateEnd) {
        return dao.loadRoomCatalog(roomType, dateStart, dateEnd);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Roomtype> loadRoomType() {
        return dao.loadRoomType();
    }

    public RoomDAO getDao() {
        return dao;
    }

    public void setDao(RoomDAO dao) {
        this.dao = dao;
    }

}

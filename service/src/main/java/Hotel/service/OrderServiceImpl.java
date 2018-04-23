package Hotel.service;

import Hotel.additionalEntity.Order;
import Hotel.dao.IDAO.OrderDAO;
import Hotel.entity.Room;
import Hotel.entity.Roomuser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service("order-service")
public class OrderServiceImpl implements OrderService {

    @Inject
    private OrderDAO dao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int roomHistoryInsert(Room room, String dateStart, String dateEnd, Roomuser user, Integer roomStatus) {
        boolean myFlag = dao.loadRoom(room, dateStart, dateEnd);
        int result;
        if (myFlag) {
            result = dao.roomHistoryInsert(room, dateStart, dateEnd, user, roomStatus);
        } else {
            result = -1;
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateStatusOrder(Room room, String dateStart, String dateEnd, Integer status) {
        return dao.updateStatusOrder(room, dateStart, dateEnd, status);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> loadRommHistory(Roomuser user) {
        return dao.loadRommHistory(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> loadRoomHistory(Integer status) {
        return dao.loadRoomHistory(status);
    }

    public OrderDAO getDao() {
        return dao;
    }

    public void setDao(OrderDAO dao) {
        this.dao = dao;
    }

}

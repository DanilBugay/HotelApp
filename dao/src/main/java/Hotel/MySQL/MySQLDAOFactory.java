package Hotel.MySQL;

import Hotel.DB.IDAO.IDAOFactory;
import Hotel.DB.IDAO.OrderDAO;
import Hotel.DB.IDAO.RoomDAO;
import Hotel.DB.IDAO.UserDAO;

public class MySQLDAOFactory implements IDAOFactory{

    @Override
    public UserDAO createUserDAO() {
        return new MySQLUserDAO();
    }

    @Override
    public OrderDAO createOrderDAO() {
        return new MySQLOrderDAO();
    }

    @Override
    public RoomDAO createRoomDAO() {
        return new MySQLRoomDAO();
    }
}

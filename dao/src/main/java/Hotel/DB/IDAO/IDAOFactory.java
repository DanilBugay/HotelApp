package Hotel.DB.IDAO;

public interface IDAOFactory {
    
    UserDAO createUserDAO();
    
    OrderDAO createOrderDAO();
            
    RoomDAO createRoomDAO();
    
}

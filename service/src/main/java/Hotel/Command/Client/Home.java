package Hotel.Command.Client;

import Hotel.Command.Command;
import Hotel.DB.IDAO.IDAOFactory;
import Hotel.DB.IDAO.OrderDAO;
import Hotel.Entity.Order;
import Hotel.DBEntity.Roomuser;
import Hotel.MySQL.MySQLDAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Home extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        IDAOFactory daoFactory = new MySQLDAOFactory();
        OrderDAO daoOrder = daoFactory.createOrderDAO();
        Roomuser user = (Roomuser) request.getSession().getAttribute("user");
        List<Order> listRoomHistory = daoOrder.loadRommHistory(user);
        Integer sizeList;
        sizeList = listRoomHistory.size();
        if (sizeList == 0) {
            request.getSession().setAttribute("aEMPTY_ORDERS", 0);
        }
        if (sizeList != 0) {
            request.getSession().setAttribute("aEMPTY_ORDERS", 1);
        }
        request.getSession().setAttribute("list_roomHistory", listRoomHistory);
        return "Home.jsp";
    }
}

package Hotel.Command.Admin;

import Hotel.Command.Command;
import Hotel.DB.IDAO.IDAOFactory;
import Hotel.DB.IDAO.OrderDAO;
import Hotel.Entity.Order;
import Hotel.MySQL.MySQLDAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminOrders extends Command {

    private static final int ADMMIN_ID = 1;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        IDAOFactory daoFactory = new MySQLDAOFactory();
        OrderDAO daoOrder = daoFactory.createOrderDAO();
        List<Order> dataRoomHistory = daoOrder.loadRoomHistory(ADMMIN_ID);
        Integer sizeList = dataRoomHistory.size();
        int flagOrder = 1;
        if (sizeList == 0) {
            flagOrder = 0;
        }
        request.getSession().setAttribute("aEMPTY_ORDER", flagOrder);
        request.getSession().setAttribute("dataRoomHistory", dataRoomHistory);
        String forward = "AdminOrders.jsp";
        return forward;
    }

}

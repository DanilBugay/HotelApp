package Hotel.Command.Admin;

import Hotel.Command.Command;
import Hotel.DB.IDAO.IDAOFactory;
import Hotel.DB.IDAO.OrderDAO;
import Hotel.Entity.Order;
import Hotel.DBEntity.Room;
import Hotel.MySQL.MySQLDAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminConfirm extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        IDAOFactory daoFactory = new MySQLDAOFactory();
        OrderDAO daoOrder = daoFactory.createOrderDAO();
        Integer status = 1;
        if (request.getParameter("bConfirm") != null) {
            status = 2;
        }
        if (request.getParameter("bRejec") != null) {
            status = 3;
        }
        String forward = "AdminOrders.jsp";
        String[] roomID = request.getParameterValues("selectroom");
        if (roomID == null) {
            forward = "AdminOrders.jsp";
        } else {
            List<Order> dataRoomHistory = (List) request.getSession().getAttribute("dataRoomHistory");
            for (String currentRow : roomID) {
                int row = Integer.parseInt(currentRow);
                Order order = dataRoomHistory.get(row);
                Room room = new Room(order.getRoomNumber());
                daoOrder.updateStatusOrder(room, status);
            }
            dataRoomHistory = daoOrder.loadRoomHistory(1);
            Integer sizeList = dataRoomHistory.size();
            int flagOrder = 1;
            if (sizeList == 0) {
                flagOrder = 0;
            }
            request.getSession().setAttribute("aEMPTY_ORDER", flagOrder);
            request.getSession().setAttribute("dataRoomHistory", dataRoomHistory);
        }
        return forward;
    }
}

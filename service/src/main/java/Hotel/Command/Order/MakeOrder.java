package Hotel.Command.Order;

import Hotel.DB.IDAO.IDAOFactory;
import Hotel.DB.IDAO.OrderDAO;
import Hotel.Command.Command;
import Hotel.DBEntity.Room;
import Hotel.DBEntity.Roomuser;
import Hotel.MySQL.MySQLDAOFactory;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakeOrder extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        IDAOFactory daoFactory = new MySQLDAOFactory();
        OrderDAO daoOrder = daoFactory.createOrderDAO();
        String forward = null;
        String userName;
        String userPhone;
        String userMail;
        String dateStart;
        String dateEnd;
        Roomuser user = null;
        boolean flag = (boolean) request.getSession().getAttribute("aINFO");
        if (request.getParameter("bMakeOrderInfo") != null) {
            flag = true;
            boolean result = false;
            request.getSession().setAttribute("aINFO", true);
            if (user == null && flag == true) {
                dateStart = (String) request.getSession().getAttribute("Attr_DateStart");
                dateEnd = (String) request.getSession().getAttribute("Attr_DateEnd");
                userName = request.getParameter("UserName");
                userMail = request.getParameter("UserMail");
                userPhone = request.getParameter("UserPhone");
                request.getSession().setAttribute("aUSER_NAME", userName);
                request.getSession().setAttribute("aUSER_MAIL", userMail);
                request.getSession().setAttribute("aUSER_PHONE", userPhone);
                user = new Roomuser().setId(0).setUName(userName).setUMail(userMail).setUPhone(userPhone);
                List<Room> orderRooms = (List) request.getSession().getAttribute("dataSelectRoom");
                for (int i = 0; i < orderRooms.size(); i++) {
                    Room room = orderRooms.get(i);
                    result = daoOrder.roomHistoryInsert(room, dateStart, dateEnd, user, 1);
                }
                if (result == true) {
                    forward = "Order.jsp";
                } else {
                    forward = "Error.jsp";
                }
            }
        }
        if (request.getParameter("bMakeOrder") != null) {
            boolean result = false;
            user = (Roomuser) request.getSession().getAttribute("user");
            if (user != null || flag == true) {
                dateStart = (String) request.getSession().getAttribute("Attr_DateStart");
                dateEnd = (String) request.getSession().getAttribute("Attr_DateEnd");
                List<Room> orderRooms = (List) request.getSession().getAttribute("dataSelectRoom");
                request.getSession().setAttribute("aUSER_NAME", String.valueOf(user.getUName()));
                for (int i = 0; i < orderRooms.size(); i++) {
                    Room room = orderRooms.get(i);
                    result = daoOrder.roomHistoryInsert(room, dateStart, dateEnd, user, 1);
                }
                if (result == true) {
                    forward = "Order.jsp";
                } else {
                    forward = "Error.jsp";
                }
            }
            if (user == null && flag == false) {
                forward = "UserInfo.jsp";
            }
        }
        if (request.getParameter("bDelete") != null) {
            String[] currentID = request.getParameterValues("cart_select_room");
            if (currentID != null) {
                List<Room> dataSelectRoom = (List) request.getSession().getAttribute("dataSelectRoom");
                Room room;
                for (String currentRow : currentID) {
                    int row = Integer.parseInt(currentRow);
                    room = dataSelectRoom.get(row);
                    dataSelectRoom.remove(room);
                }
                Integer sizeList = dataSelectRoom.size();
                int flagCart = 1;
                if (sizeList == 0) {
                    flagCart = 0;
                }
                request.getSession().setAttribute("aEMPTY_CART", flagCart);
                request.getSession().setAttribute("dataSelectRoom", dataSelectRoom);
            }
            forward = "Cart.jsp";
        }
        return forward;
    }
}

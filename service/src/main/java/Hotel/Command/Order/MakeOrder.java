package Hotel.command.Order;

import Hotel.additionalEntity.Order;
import Hotel.command.Command;
import Hotel.config.ApplicationConfig;
import Hotel.entity.Room;
import Hotel.entity.Roomuser;
import Hotel.service.OrderService;
import Hotel.service.OrderServiceImpl;
import Hotel.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakeOrder extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ApplicationContext context = new ClassPathXmlApplicationContext("model.xml");
        OrderService service = context.getBean("order-service", OrderService.class);
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
            int result = -1;
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
                    result = service.roomHistoryInsert(room, dateStart, dateEnd, user, 1);
                }
                if (result != -1) {
                    forward = "Order.jsp";
                } else {
                    forward = "Error.jsp";
                }
            }
        }
        if (request.getParameter("bMakeOrder") != null) {
            int result = -1;
            user = (Roomuser) request.getSession().getAttribute("user");
            if (user != null || flag == true) {
                dateStart = (String) request.getSession().getAttribute("Attr_DateStart");
                dateEnd = (String) request.getSession().getAttribute("Attr_DateEnd");
                List<Room> orderRooms = (List) request.getSession().getAttribute("dataSelectRoom");
                request.getSession().setAttribute("aUSER_NAME", String.valueOf(user.getUName()));
                for (int i = 0; i < orderRooms.size(); i++) {
                    Room room = orderRooms.get(i);
                    result = service.roomHistoryInsert(room, dateStart, dateEnd, user, 1);
                }
                if (result != -1) {
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

package Hotel.command.Admin;

import Hotel.command.Command;
import Hotel.additionalEntity.Order;
import Hotel.config.ApplicationConfig;
import Hotel.entity.Room;
import Hotel.service.OrderService;
import Hotel.service.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminConfirm extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ApplicationContext context = new ClassPathXmlApplicationContext("model.xml");
        OrderService service = context.getBean("order-service", OrderService.class);
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
                service.updateStatusOrder(room, order.getDateStart(), order.getDateEnd(), status);
            }
            dataRoomHistory = service.loadRoomHistory(1);
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

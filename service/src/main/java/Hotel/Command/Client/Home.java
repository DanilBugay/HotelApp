package Hotel.command.Client;

import Hotel.command.Command;
import Hotel.additionalEntity.Order;
import Hotel.config.ApplicationConfig;
import Hotel.entity.Roomuser;
import Hotel.service.OrderService;
import Hotel.service.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Home extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ApplicationContext context = new ClassPathXmlApplicationContext("model.xml");
        OrderService service = context.getBean("order-service", OrderService.class);
        Roomuser user = (Roomuser) request.getSession().getAttribute("user");
        List<Order> listRoomHistory = service.loadRommHistory(user);
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

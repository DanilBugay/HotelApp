package Hotel.command.Admin;

import Hotel.command.Command;
import Hotel.additionalEntity.Order;
import Hotel.config.ApplicationConfig;
import Hotel.service.OrderService;
import Hotel.service.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminOrders extends Command {

    private static final int ADMMIN_ID = 1;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ApplicationContext context = new ClassPathXmlApplicationContext("model.xml");
        OrderService service = context.getBean("order-service", OrderService.class);
        List<Order> dataRoomHistory = service.loadRoomHistory(ADMMIN_ID);
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

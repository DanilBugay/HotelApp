package Hotel.command;

import Hotel.additionalEntity.Order;
import Hotel.entity.Room;
import Hotel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/hotel/newOrders", method = RequestMethod.GET)
    public String showOrders(ModelMap model) {
        List<Order> dataRoomHistory = orderService.loadRoomHistory(1);
        model.addAttribute("dataRoomHistory", dataRoomHistory);
        return "/AdminOrders";
    }

    @RequestMapping(value = "/hotel/changeStatusOrder", method = RequestMethod.POST)
    public String changeStatusOrder(@RequestParam(value = "bConfirm", required = false) String bConfirm,
                                    @RequestParam(value = "bRejec", required = false) String bRejec,
                                    @RequestParam(value = "selectroom", required = false) String[] roomID) {
        Integer status = 1;
        if (bConfirm != null) {
            status = 2;
        }
        if (bRejec != null) {
            status = 3;
        }
        if (roomID != null) {
            List<Order> dataRoomHistory = orderService.loadRoomHistory(1);
            for (String row : roomID) {
                int currentRowrow = Integer.parseInt(row);
                Order order = dataRoomHistory.get(currentRowrow);
                Room room = new Room(order.getRoomNumber());
                orderService.updateStatusOrder(room, order.getDateStart(), order.getDateEnd(), status);
            }
        }
        return "redirect:/hotel/newOrders";
    }
}

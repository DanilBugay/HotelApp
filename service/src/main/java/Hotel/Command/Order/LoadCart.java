package Hotel.command.Order;

import Hotel.command.Command;
import Hotel.entity.Room;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadCart extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Room> dataSelectRoom = (List) request.getSession().getAttribute("dataSelectRoom");
        if (dataSelectRoom == null) {
            request.getSession().setAttribute("aEMPTY_CART", 0);
        } else {
            Integer sizeList = dataSelectRoom.size();
            int flagCart = 1;
            if (sizeList == 0) {
                flagCart = 0;
            }
            request.getSession().setAttribute("aEMPTY_CART", flagCart);
        }
        request.getSession().setAttribute("dataSelectRoom", dataSelectRoom);
        return "Cart.jsp";
    }
}

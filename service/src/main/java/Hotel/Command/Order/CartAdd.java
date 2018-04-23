package Hotel.command.Order;

import Hotel.command.Command;
import Hotel.entity.Room;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartAdd extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String[] roomID = request.getParameterValues("selectroom");
        String forward;
        if (roomID == null) {
            forward = "Catalog.jsp";
        } else {
            List<Room> dataSelectRoom = (List) request.getSession().getAttribute("dataSelectRoom");
            List<Room> dataRoomCatalog = (List) request.getSession().getAttribute("dataRoomCatalog");
            if (dataSelectRoom == null) {
                dataSelectRoom = new ArrayList<>();
            }
            for (String currentRow : roomID) {
                int row = Integer.parseInt(currentRow);
                Room room = dataRoomCatalog.get(row);
                dataSelectRoom.add(room);
            }
            Integer sizeList = dataSelectRoom.size();
            int flagCart = 1;
            if (sizeList == 0) {
                flagCart = 0;
            }
            request.getSession().setAttribute("aEMPTY_CART", flagCart);
            request.getSession().setAttribute("dataSelectRoom", dataSelectRoom);
            forward = "Cart.jsp";
        }
        return forward;
    }
}

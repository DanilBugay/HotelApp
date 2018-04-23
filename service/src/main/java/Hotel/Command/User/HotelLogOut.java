package Hotel.command.User;

import Hotel.command.Command;
import Hotel.entity.Room;
import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

public class HotelLogOut extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Room> orderRooms = (List) request.getSession().getAttribute("dataSelectRoom");
        if (orderRooms != null) {
            orderRooms.clear();
        }
        request.getSession().setAttribute("user", null);
        return "Index.jsp";
    }

}

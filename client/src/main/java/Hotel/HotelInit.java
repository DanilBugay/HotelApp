package Hotel;

import Hotel.DB.IDAO.IDAOFactory;
import Hotel.DB.IDAO.RoomDAO;
import Hotel.DBEntity.Roomtype;
import Hotel.MySQL.MySQLDAOFactory;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "HotelInit", urlPatterns = {"/HotelInit"})
public class HotelInit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IDAOFactory daoFactory = new MySQLDAOFactory();
        RoomDAO daoRoom = daoFactory.createRoomDAO();
        HttpSession session = request.getSession(false);
        if (session == null) {
            session = request.getSession();
        }
        session.setAttribute("ERROR_ID", 1);
        session.setAttribute("aEMPTY_LIST", 1);
        session.setAttribute("aEMPTY_CART", 1);
        session.setAttribute("aEMPTY_ORDER", 1);
        session.setAttribute("aEMPTY_ORDERS", 1);
        session.setAttribute("USER_ID", 0);
        session.setAttribute("aINFO", false);
        session.setAttribute("MENU_1", "SIGN UP");
        session.setAttribute("MENU_2", "LOG IN");
        List<Roomtype> dataRoomType = daoRoom.loadRoomType();
        session.setAttribute("dataRoomType", dataRoomType);
        session.setAttribute("dataRoomType", dataRoomType);
        request.getRequestDispatcher("/Index.jsp").forward(request, response);
    }

}

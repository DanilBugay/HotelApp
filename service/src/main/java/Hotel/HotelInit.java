package Hotel;

import Hotel.config.ApplicationConfig;
import Hotel.entity.Roomtype;
import Hotel.service.RoomService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ApplicationContext context = new ClassPathXmlApplicationContext("model.xml");
        RoomService service = context.getBean("room-service", RoomService.class);
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
        List<Roomtype> dataRoomType = service.loadRoomType();
        session.setAttribute("dataRoomType", dataRoomType);
        session.setAttribute("dataRoomType", dataRoomType);
        request.getRequestDispatcher("/Index.jsp").forward(request, response);
    }

}

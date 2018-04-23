package Hotel.command.User;

import Hotel.command.Command;
import Hotel.additionalEntity.UserRole;
import Hotel.config.ApplicationConfig;
import Hotel.entity.Room;
import Hotel.entity.Roomuser;
import Hotel.service.UserService;
import Hotel.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class HotelLogin extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        ApplicationContext context = new ClassPathXmlApplicationContext("model.xml");
        UserService service = context.getBean("user-service", UserService.class);
        String forward;
        String userLogin = request.getParameter("UserLogin");
        String userPassword = request.getParameter("UserPassword");
        List<Room> orderRooms = (List) request.getSession().getAttribute("dataSelectRoom");
        if (orderRooms != null) {
            orderRooms.clear();
        }
        List<Roomuser> user = service.login(userLogin, userPassword);
        if (user.size() != 0) {
            UserRole userRole = UserRole.getRole(user.get(0));
            session.setAttribute("user", user.get(0));
            session.setAttribute("userRole", userRole);
            forward = "Index.jsp";
        } else {
            request.getSession().setAttribute("ERROR_ID", 0);
            forward = "Login.jsp";
        }
        return forward;
    }
}

package Hotel.command.User;

import Hotel.command.Command;
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
import java.io.IOException;
import java.util.List;

public class HotelReg extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ApplicationContext context = new ClassPathXmlApplicationContext("model.xml");
        UserService service = context.getBean("user-service", UserService.class);
        String forward;
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("UserName");
        String userLogin = request.getParameter("UserLogin");
        String userPassword = request.getParameter("UserPassword");
        String userMail = request.getParameter("UserMail");
        String userPhone = request.getParameter("UserPhone");
        List<Room> orderRooms = (List) request.getSession().getAttribute("dataSelectRoom");
        if (orderRooms != null) {
            orderRooms.clear();
        }
        Roomuser user = new Roomuser().setULogin(userLogin).setUPass(userPassword).setUName(userName)
                .setUMail(userMail).setUPhone(userPhone).setStatus("0");
        int result = service.regUser(user);
        System.out.println(result);
        System.out.println(result != 0);
        if (result != -1) {
            System.out.println("Ну да");
            forward = "Login.jsp";
        } else {
            request.getSession().setAttribute("ERROR_ID", 0);
            forward = "SignUp.jsp";
        }
        return forward;
    }
}

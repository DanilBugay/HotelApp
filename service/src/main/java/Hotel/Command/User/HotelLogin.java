package Hotel.Command.User;

import Hotel.Command.Command;
import Hotel.DB.IDAO.IDAOFactory;
import Hotel.DB.IDAO.UserDAO;
import Hotel.Entity.UserRole;
import Hotel.DBEntity.Room;
import Hotel.DBEntity.Roomuser;
import Hotel.MySQL.MySQLDAOFactory;

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
        IDAOFactory daoFactory = new MySQLDAOFactory();
        UserDAO daoUser = daoFactory.createUserDAO();
        String forward;
        String userLogin = request.getParameter("UserLogin");
        String userPassword = request.getParameter("UserPassword");
        List<Room> orderRooms = (List) request.getSession().getAttribute("dataSelectRoom");
        if (orderRooms != null) {
            orderRooms.clear();
        }
        Roomuser user = daoUser.login(userLogin, userPassword);
        if (user != null) {
            System.out.println(user.getUName());
            UserRole userRole = UserRole.getRole(user);
            session.setAttribute("user", user);
            System.out.println(user);
            session.setAttribute("userRole", userRole);
            forward = "Index.jsp";
        } else {
            request.getSession().setAttribute("ERROR_ID", 0);
            forward = "Login.jsp";
        }
        return forward;
    }
}

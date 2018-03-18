package Hotel.Command.User;

import Hotel.DB.IDAO.IDAOFactory;
import Hotel.DB.IDAO.UserDAO;
import Hotel.Command.Command;
import Hotel.DBEntity.Room;
import Hotel.DBEntity.Roomuser;
import Hotel.MySQL.MySQLDAOFactory;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HotelReg extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        IDAOFactory daoFactory = new MySQLDAOFactory();
        UserDAO daoUser = daoFactory.createUserDAO();
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
        boolean result = daoUser.regUser(user);
        if (result != false) {
            forward = "Login.jsp";
        } else {
            request.getSession().setAttribute("ERROR_ID", 0);
            forward = "SignUp.jsp";
        }
        return forward;
    }
}

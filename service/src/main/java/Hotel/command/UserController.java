package Hotel.command;

import Hotel.additionalEntity.Order;
import Hotel.additionalEntity.UserRole;
import Hotel.entity.Roomuser;
import Hotel.service.OrderService;
import Hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes({"user", "userRole", "dataSelectRoom", "dataRoomCatalog", "Attr_DateStart", "Attr_DateEnd"})
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/hotel/login", method = RequestMethod.GET)
    public String userLogin(@RequestParam(value = "UserLogin") String userLogin,
                            @RequestParam(value = "UserPassword") String userPassword,
                            ModelMap model, HttpSession session) {
        List rooms = (List) session.getAttribute("dataSelectRoom");
        if (rooms != null) {
            rooms.clear();
            session.setAttribute("dataSelectRoom", rooms);
        }
        List<Roomuser> user = userService.login(userLogin, userPassword);
        if (user.size() != 0) {
            UserRole userRole = UserRole.getRole(user.get(0));
            session.setAttribute("user", user.get(0));
            session.setAttribute("userRole", userRole);
            return "redirect:/hotel";
        } else {
            model.addAttribute("ERROR_ID", 0);
            return "/Login";
        }
    }

    @RequestMapping(value = "/hotel/signUp", method = RequestMethod.POST)
    public String userSignUp(@RequestParam(value = "UserName") String userName,
                             @RequestParam(value = "UserLogin") String userLogin,
                             @RequestParam(value = "UserPassword") String userPassword,
                             @RequestParam(value = "UserMail") String userMail,
                             @RequestParam(value = "UserPhone") String userPhone,
                             ModelMap model) {
        int result = userService.regUser(new Roomuser().setULogin(userLogin).setUPass(userPassword).setUName(userName)
                .setUMail(userMail).setUPhone(userPhone).setStatus("0"));
        if (result != -1) {
            return "/Login";
        } else {
            model.addAttribute("ERROR_ID", 0);
            return "/SignUp";
        }
    }

    @RequestMapping(value = "/hotel/logOut", method = RequestMethod.GET)
    public String logOut(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/hotel";
    }

    @RequestMapping(value = "/hotel/home", method = RequestMethod.GET)
    public String showHomePage(HttpSession session, ModelMap model) {
        Roomuser user = (Roomuser) session.getAttribute("user");
        List<Order> listRoomHistory = orderService.loadRommHistory(user);
        model.addAttribute("list_roomHistory", listRoomHistory);
        return "/Home";
    }
}
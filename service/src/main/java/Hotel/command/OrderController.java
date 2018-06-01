package Hotel.command;


import Hotel.entity.Room;
import Hotel.entity.Roomtype;
import Hotel.entity.Roomuser;
import Hotel.service.OrderService;
import Hotel.service.RoomService;
import Hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static Hotel.util.DateValidator.isThisDateValid;

@Controller
@SessionAttributes({"user", "userRole", "dataSelectRoom", "dataRoomCatalog", "Attr_DateStart", "Attr_DateEnd"})
public class OrderController {

    @Autowired
    RoomService roomService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/hotel", method = RequestMethod.GET)
    public String initHotel(Model model) {
        List<Roomtype> dataRoomType = roomService.loadRoomType();
        model.addAttribute("dataRoomType", dataRoomType);
        return "/Index";
    }

    @RequestMapping(value = "/hotel/loadCard", method = RequestMethod.GET)
    public String loadCard(ModelMap model, HttpSession session) {
        List dataSelectRoom = (List) session.getAttribute("dataSelectRoom");
        model.addAttribute("dataSelectRoom", dataSelectRoom);
        return "/Cart";
    }

    @RequestMapping(value = "/hotelCatalog", method = RequestMethod.GET)
    public String userSignUp(@RequestParam(value = "ID_room_type") String ID,
                             @RequestParam(value = "Date_start") String dateStart,
                             @RequestParam(value = "Date_end") String dateEnd,
                             ModelMap model, HttpSession session) {
        boolean startDate = isThisDateValid(dateStart, "dd.MM.yyyy");
        boolean endDate = isThisDateValid(dateEnd, "dd.MM.yyyy");
        if (startDate && endDate) {
            List<Room> dataRoomCatalog = roomService.loadRoomCatalog(ID, dateStart, dateEnd);
            Integer sizeList = dataRoomCatalog.size();
            int flagList = sizeList == 0 ? 0 : 1;
            session.setAttribute("dataRoomCatalog", dataRoomCatalog);
            session.setAttribute("Attr_DateStart", dateStart);
            session.setAttribute("Attr_DateEnd", dateEnd);
            model.addAttribute("aEMPTY_LIST", flagList);
            model.addAttribute("dataRoomCatalog", dataRoomCatalog);
            return "/Catalog";
        } else {
            return "redirect:/hotel";
        }
    }

    @ModelAttribute("dataSelectRoom")
    public List<Room> roomInCard() {
        return new ArrayList<>();
    }

    @RequestMapping(value = "/addCard", method = RequestMethod.GET)
    public String addCard(@RequestParam(value = "selectroom", required = false) String[] roomID, HttpSession session) {
        if (roomID == null) {
            return "/Cart";
        } else {
            List dataSelectRoom = (List) session.getAttribute("dataSelectRoom");
            List dataRoomCatalog = (List) session.getAttribute("dataRoomCatalog");
            for (String currentRow : roomID) {
                int row = Integer.parseInt(currentRow);
                Room room = (Room) dataRoomCatalog.get(row);
                if (!dataSelectRoom.contains(room)) {
                    dataSelectRoom.add(room);
                }
            }
            session.setAttribute("dataSelectRoom", dataSelectRoom);
            return "/Cart";
        }
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(@RequestParam(value = "UserName") String userName,
                             @RequestParam(value = "UserMail") String userMail,
                             @RequestParam(value = "UserPhone") String userPhone,
                             HttpSession session, HttpServletRequest request) {
        Roomuser user = new Roomuser().setId(0).setUName(userName).setUMail(userMail).setUPhone(userPhone);
        session.setAttribute("user", user);
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return "redirect:/makeOrder";
    }


    @RequestMapping(value = "/makeOrder", method = RequestMethod.POST)
    public String makeOrder(@RequestParam(value = "bMakeOrder", required = false) String makeOrder,
                            @RequestParam(value = "bDelete", required = false) String deleteOrder,
                            @RequestParam(value = "cart_select_room", required = false) String[] currentID,
                            HttpSession session) {
        Roomuser roomuser = (Roomuser) session.getAttribute("user");
        if (deleteOrder != null) {
            if (currentID != null) {
                List dataSelectRoom = (List) session.getAttribute("dataSelectRoom");
                for (String currentRow : currentID) {
                    int row = Integer.parseInt(currentRow);
                    Iterator room = dataSelectRoom.iterator();
                    while (room.hasNext()) {
                        Room currentRoom = (Room) room.next();
                        if (currentRoom.getRoomNum() == row) {
                            room.remove();
                        }
                    }
                }
                session.setAttribute("dataSelectRoom", dataSelectRoom);
            }
            return "/Cart";
        }
        if (makeOrder != null && roomuser == null) {
            return "/UserInfo";
        } else {
            int result = -1;
            String dateStart = (String) session.getAttribute("Attr_DateStart");
            String dateEnd = (String) session.getAttribute("Attr_DateEnd");
            List orderRooms = (List) session.getAttribute("dataSelectRoom");
            for (Object orderRoom : orderRooms) {
                Room room = (Room) orderRoom;
                result = orderService.roomHistoryInsert(room, dateStart, dateEnd, roomuser, 1);
            }
            if (result != -1) {
                return "/Order";
            } else {
                return "/Error";
            }
        }
    }

}

package Hotel.command.Order;

import Hotel.command.Command;
import Hotel.config.ApplicationConfig;
import Hotel.entity.Room;
import Hotel.service.RoomService;
import Hotel.service.RoomServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class HotelCatalog extends Command {

    public static boolean isThisDateValid(String dateToValidate, String dateFormat) {
        if (dateToValidate == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateToValidate);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ApplicationContext context = new ClassPathXmlApplicationContext("model.xml");
        RoomService service = context.getBean("room-service", RoomService.class);
        String forward;
        String ID = request.getParameter("ID_room_type");
        String dateStart = request.getParameter("Date_start");
        String dateEnd = request.getParameter("Date_end");
        boolean startDate = isThisDateValid(dateStart, "dd.MM.yyyy");
        boolean endDate = isThisDateValid(dateEnd, "dd.MM.yyyy");
        if (startDate == true && endDate == true) {
            request.getSession().setAttribute("Attr_DateStart", dateStart);
            request.getSession().setAttribute("Attr_DateEnd", dateEnd);
            List<Room> dataRoomCatalog = service.loadRoomCatalog(ID, dateStart, dateEnd);
            Integer sizeList = dataRoomCatalog.size();
            int flagList = 1;
            if (sizeList == 0) {
                flagList = 0;
            }
            request.getSession().setAttribute("aEMPTY_LIST", flagList);
            request.getSession().setAttribute("dataRoomCatalog", dataRoomCatalog);
            forward = "Catalog.jsp";
        } else {
            forward = "Index.jsp";
        }
        return forward;
    }
}

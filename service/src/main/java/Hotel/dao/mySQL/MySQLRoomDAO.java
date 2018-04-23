package Hotel.dao.mySQL;

import Hotel.dao.IDAO.RoomDAO;
import Hotel.entity.Room;
import Hotel.entity.Roomtype;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Repository
public class MySQLRoomDAO implements RoomDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> loadRoomCatalog(String roomType, String dateStart, String dateEnd) {
        Integer typeId = Integer.valueOf(roomType);
        Date dStart = stringToDate(dateStart, "dd.MM.yyyy");
        Date dEnd = stringToDate(dateEnd, "dd.MM.yyyy");
        Query query = em.createQuery("Select r from Room r where idRoomtype = :roomType and r.roomNum "
                + "not in (select rh.room from Roomhistory as rh where rh.dateStart < :dateEnd and rh.dateEnd > :dateStart and rh.roomstatus <> 3)");
        query.setParameter("roomType", typeId);
        query.setParameter("dateStart", dStart);
        query.setParameter("dateEnd", dEnd);
        return query.getResultList();
    }

    @Override
    public List<Roomtype> loadRoomType() {
        return em.createNamedQuery("select_roomtypes").getResultList();
    }

    public static Date stringToDate(String dateString, String dateFormat) {
        if (dateString == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date outDate = sdf.parse(dateString);
            return outDate;
        } catch (ParseException e) {
            return null;
        }
    }

}
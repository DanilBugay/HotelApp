package Hotel.dao.mySQL;

import Hotel.dao.IDAO.OrderDAO;
import Hotel.additionalEntity.Order;
import Hotel.entity.Room;
import Hotel.entity.Roomhistory;
import Hotel.entity.Roomstatus;
import Hotel.entity.Roomuser;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Repository
public class MySQLOrderDAO implements OrderDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public int roomHistoryInsert(Room room, String dateStart, String dateEnd, Roomuser user, Integer roomStatus) {
        Date dStart = stringToDate(dateStart, "dd.MM.yyyy");
        Date dEnd = stringToDate(dateEnd, "dd.MM.yyyy");
        Roomstatus roomstatus = new Roomstatus(roomStatus);
        Roomhistory order = new Roomhistory().setRoom(room).setDateStart(dStart).setDateEnd(dEnd)
                .setIdRoomuser(user.getId()).setUName(user.getUName()).setUMail(user.getUMail())
                .setUPhone(user.getUPhone()).setIdRoomstatus(roomstatus);
        em.persist(order);
        return order.getId();
    }

    @Override
    public int updateStatusOrder(Room room, String dateStart, String dateEnd, Integer status) {
        Date dStart = stringToDate(dateStart, "dd.MM.yyyy");
        Date dEnd = stringToDate(dateEnd, "dd.MM.yyyy");
        Query query = em.createQuery("select hs from Roomhistory hs WHERE room = :cRoom and dateStart = :dStart and " +
                "dateEnd = :dEnd");
        query.setParameter("cRoom", room);
        query.setParameter("dStart", dStart);
        query.setParameter("dEnd", dEnd);
        List<Roomhistory> list = query.getResultList();
        Roomstatus roomStatus = em.find(Roomstatus.class, status);
        list.get(0).setRoomstatus(roomStatus);
        em.flush();
        return list.get(0).getId();
    }

    @Override
    public List<Order> loadRommHistory(Roomuser user) {
        List<Order> orders = new ArrayList<>();
        String hql = "from Roomhistory rh inner join rh.room inner join rh.roomstatus where rh.idRoomuser = :idRoomuser";
        Query query = em.createQuery(hql);
        query.setParameter("idRoomuser", user.getId());
        List<Object[]> listResult = query.getResultList();
        for (Object[] aRow : listResult) {
            Roomhistory rh = (Roomhistory) aRow[0];
            Room room = (Room) aRow[1];
            String dateStart = dateToString(rh.getDateStart(), "dd.MM.yyyy");
            String dateEnd = dateToString(rh.getDateEnd(), "dd.MM.yyyy");
            Order order = new Order(rh.getRoom().getRoomNum(), dateStart, dateEnd, room.getRate(), rh.getRoomstatus().getStatus());
            orders.add(order);
        }
        return orders;
    }

    @Override
    public List<Order> loadRoomHistory(Integer status) {
        List<Order> orders = new ArrayList<>();
        String hql = "from Roomhistory rh inner join rh.room where rh.roomstatus = :idRoomstatus";
        Query query = em.createQuery(hql);
        Roomstatus roomStatus = em.find(Roomstatus.class, status);
        query.setParameter("idRoomstatus", roomStatus);
        List<Object[]> listResult = query.getResultList();
        for (Object[] aRow : listResult) {
            Roomhistory rh = (Roomhistory) aRow[0];
            Room room = (Room) aRow[1];
            String dateStart = dateToString(rh.getDateStart(), "dd.MM.yyyy");
            String dateEnd = dateToString(rh.getDateEnd(), "dd.MM.yyyy");
            Order order = new Order(rh.getRoom().getRoomNum(), dateStart, dateEnd, rh.getUName(), rh.getUPhone(), room.getRate());
            orders.add(order);
        }
        return orders;
    }

    @Override
    public boolean loadRoom(Room room, String dateStart, String dateEnd) {
        boolean myFlag = false;
        Date dStart = stringToDate(dateStart, "dd.MM.yyyy");
        Date dEnd = stringToDate(dateEnd, "dd.MM.yyyy");
        Query query = em.createQuery("Select r from Room r where r.roomNum "
                + "not in (select rh.room from Roomhistory as rh where rh.dateStart < :dateEnd and rh.dateEnd > :dateStart and rh.roomstatus <> 3)");
        query.setParameter("dateStart", dStart);
        query.setParameter("dateEnd", dEnd);
        List<Room> list = query.getResultList();
        for (Room currentRoom : list) {
            if (currentRoom.getRoomNum() == room.getRoomNum()) {
                myFlag = true;
            }
        }
        return myFlag;
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

    public static String dateToString(Date dateToConvert, String dateFormat) {
        String dateString = null;
        if (dateToConvert == null) {
            return dateString;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            dateString = sdf.format(dateToConvert);
        } catch (Exception e) {
        }
        return dateString;
    }

}

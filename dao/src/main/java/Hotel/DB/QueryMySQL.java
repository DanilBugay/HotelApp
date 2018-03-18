package Hotel.DB;

public class QueryMySQL {

 /*   public static final String URL = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/ad_30f33d834f52214";
    public static final String USER = "b43d005bdaa24c";
    public static final String PASSWORD = "820edd2b";*/

    public static final String URL = "jdbc:mysql://localhost:3306/hotel";
    public static final String USER = "root";
    public static final String PASSWORD = "Danil6991";

    public static final String CLASS_DRV = "com.mysql.jdbc.Driver";
    public static final String FIND_USER = "SELECT * FROM ROOMUSER WHERE u_login = ? AND u_pass = ?";
    public static final String ADD_ORDER = "INSERT INTO roomhistory"
            + " ( room_num, date_start, date_end, id_roomuser, u_name, u_mail,"
            + " u_phone, id_roomstatus ) VALUES ( ?, STR_TO_DATE(?, '%d.%m.%Y'),"
            + " STR_TO_DATE(?, '%d.%m.%Y'), ?, ?, ?, ?, ? )";
    public static final String UPDATE_STATUS_ORDER = "UPDATE ROOMHISTORY SET id_roomstatus = ? WHERE room_num = ?";
    public static final String LOAD_ROOM_CATALOG = "SELECT room.room_num, room.descript, room.rate, room.src_photo "
            + "FROM room "
            + "WHERE room.id_roomtype = ? "
            + "AND room_num not in (select room_num from roomhistory "
            + "WHERE date_start < STR_TO_DATE( ?, '%d.%m.%Y') "
            + " and date_end > STR_TO_DATE( ?, '%d.%m.%Y') and id_roomstatus <> 3 )";
    public static final String LOAD_ROOM = "SELECT room.room_num, room.descript, room.rate, room.src_photo "
            + "FROM room "
            + "WHERE room_num not in (select room_num from roomhistory "
            + "WHERE date_start < STR_TO_DATE( ?, '%d.%m.%Y') "
            + " and date_end > STR_TO_DATE( ?, '%d.%m.%Y') and id_roomstatus <> 3 )";
    public static final String LOAD_ROOM_TYPE = "SELECT ID, ROOM_TYPE FROM ROOMTYPE";
    public static final String LOAD_ROOMHISTORY_FOR_USER = "SELECT rh.room_num, "
            + "date_format(rh.date_start, '%d.%m.%Y'), date_format(rh.date_end, '%d.%m.%Y'), "
            + "room.rate, roomstatus.status from roomhistory rh, room, roomstatus WHERE "
            + "roomstatus.id = rh.id_roomstatus and rh.id_roomuser = ? "
            + "AND rh.room_num=room.room_num";
    public static final String LOAD_ROOMHISTORY = "SELECT rh.room_num, date_format(rh.date_start, '%d.%m.%Y'),"
            + " date_format(rh.date_end, '%d.%m.%Y'), rh.u_name, rh.u_phone, room.rate, rh.id FROM roomhistory rh, "
            + "room WHERE rh.id_roomstatus = ? and rh.room_num=room.room_num";
    public static final String REG_USER = "{call insertNewUser( ?, ?, ?, ?, ?, ?)}";

}

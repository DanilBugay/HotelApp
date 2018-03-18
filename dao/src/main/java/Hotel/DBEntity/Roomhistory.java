package Hotel.DBEntity;
// Generated 27.05.2017 20:31:12 by Hibernate Tools 4.3.1

import java.util.Date;

public class Roomhistory implements java.io.Serializable {

    private Integer id;

    private Room room;

    private Date dateStart;

    private Date dateEnd;

    private Integer idRoomuser;

    private String UName;

    private String UMail;

    private String UPhone;

    private Roomstatus roomstatus;

    public Roomhistory() {
    }

    public Roomstatus getRoomstatus() {
        return roomstatus;
    }

    public void setRoomstatus(Roomstatus roomstatus) {
        this.roomstatus = roomstatus;
    }

    public Integer getId() {
        return this.id;
    }

    public Roomhistory setId(Integer id) {
        this.id = id;
        return this;
    }

    public Room getRoom() {
        return this.room;
    }

    public Roomhistory setRoom(Room room) {
        this.room = room;
        return this;
    }

    public Date getDateStart() {
        return this.dateStart;
    }

    public Roomhistory setDateStart(Date dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public Date getDateEnd() {
        return this.dateEnd;
    }

    public Roomhistory setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    public Integer getIdRoomuser() {
        return this.idRoomuser;
    }

    public Roomhistory setIdRoomuser(Integer idRoomuser) {
        this.idRoomuser = idRoomuser;
        return this;
    }

    public String getUName() {
        return this.UName;
    }

    public Roomhistory setUName(String UName) {
        this.UName = UName;
        return this;
    }

    public String getUMail() {
        return this.UMail;
    }

    public Roomhistory setUMail(String UMail) {
        this.UMail = UMail;
        return this;
    }

    public String getUPhone() {
        return this.UPhone;
    }

    public Roomhistory setUPhone(String UPhone) {
        this.UPhone = UPhone;
        return this;
    }

    public Roomstatus getIdRoomstatus() {
        return this.roomstatus;
    }

    public Roomhistory setIdRoomstatus(Roomstatus idRoomstatus) {
        this.roomstatus = idRoomstatus;
        return this;
    }

}

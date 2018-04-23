package Hotel.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "roomhistory")
public class Roomhistory implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "room_num", nullable = false)
    private Room room;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "id_roomuser")
    private Integer idRoomuser;

    @Column(name = "u_name")
    private String UName;

    @Column(name = "u_mail")
    private String UMail;

    @Column(name = "u_phone")
    private String UPhone;

    @ManyToOne
    @JoinColumn(name = "id_roomstatus", nullable = false)
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

    @Override
    public String toString() {
        return "Roomhistory{" +
                "id=" + id +
                ", room=" + room +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", idRoomuser=" + idRoomuser +
                ", UName='" + UName + '\'' +
                ", UMail='" + UMail + '\'' +
                ", UPhone='" + UPhone + '\'' +
                ", roomstatus=" + roomstatus +
                '}';
    }
}

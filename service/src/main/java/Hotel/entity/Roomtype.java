package Hotel.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
@NamedQueries(
        @NamedQuery(name = "select_roomtypes", query = "select rt from Roomtype rt")
)
@Entity
@Table(name = "roomtype")
public class Roomtype implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "room_type")
    @NotNull
    private String roomType;

    public Roomtype() {
    }

    public Roomtype(int id, String roomType) {
        this.id = id;
        this.roomType = roomType;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

}

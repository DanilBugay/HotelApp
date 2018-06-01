package Hotel.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "room")
public class Room implements java.io.Serializable {

    @Id
    @Column(name = "room_num", nullable = false)
    private int roomNum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNum == room.roomNum &&
                idRoomtype == room.idRoomtype &&
                Float.compare(room.rate, rate) == 0 &&
                Objects.equals(descript, room.descript) &&
                Objects.equals(srcPhoto, room.srcPhoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNum, idRoomtype, rate, descript, srcPhoto);
    }

    @Column(name = "id_roomtype", nullable = false)

    private int idRoomtype;

    @Column(name = "rate", nullable = false)
    private float rate;

    @Column(name = "descript", nullable = false)
    private String descript;

    @Column(name = "src_photo", nullable = false)
    private String srcPhoto;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Roomhistory> roomhistories;

    public Room() {
    }

    public Room(int roomNum, String descript, float rate, String srcPhoto) {
        this.roomNum = roomNum;
        this.rate = rate;
        this.descript = descript;
        this.srcPhoto = srcPhoto;
    }

    public Room(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getRoomNum() {
        return this.roomNum;
    }

    public Room setRoomNum(int roomNum) {
        this.roomNum = roomNum;
        return this;
    }

    public int getIdRoomtype() {
        return this.idRoomtype;
    }

    public Room setIdRoomtype(int idRoomtype) {
        this.idRoomtype = idRoomtype;
        return this;
    }

    public float getRate() {
        return this.rate;
    }

    public Room setRate(float rate) {
        this.rate = rate;
        return this;
    }

    public String getDescript() {
        return this.descript;
    }

    public Room setDescript(String descript) {
        this.descript = descript;
        return this;
    }

    public String getSrcPhoto() {
        return this.srcPhoto;
    }

    public Room setSrcPhoto(String srcPhoto) {
        this.srcPhoto = srcPhoto;
        return this;
    }

    public List<Roomhistory> getRoomhistories() {
        return this.roomhistories;
    }

    public void setRoomhistories(List<Roomhistory> roomhistories) {
        this.roomhistories = roomhistories;
    }

}

package Hotel.DBEntity;
// Generated 27.05.2017 20:31:12 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

public class Room implements java.io.Serializable {

    private int roomNum;

    private int idRoomtype;

    private float rate;

    private String descript;

    private String srcPhoto;

    private Set<Roomhistory> roomhistories = new HashSet<>(0);

    public Room() {
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

    public Set<Roomhistory> getRoomhistories() {
        return this.roomhistories;
    }

    public void setRoomhistories(Set<Roomhistory> roomhistories) {
        this.roomhistories = roomhistories;
    }

}

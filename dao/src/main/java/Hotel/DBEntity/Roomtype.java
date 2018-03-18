package Hotel.DBEntity;

public class Roomtype implements java.io.Serializable {

    private int id;

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

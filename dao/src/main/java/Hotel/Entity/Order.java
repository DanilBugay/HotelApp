package Hotel.Entity;

import java.util.Date;

public class Order {

    private Integer roomNumber;
    private String dateStart;
    private String dateEnd;
    private String UName;
    private String UPhone;
    private float price;
    private String status;

    public Order(Integer roomNumber, String dateStart, String dateEnd, String UName, String UPhone, float price) {
        this.roomNumber = roomNumber;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.UName = UName;
        this.UPhone = UPhone;
        this.price = price;
    }

    public Order(Integer roomNumber, String dateStart, String dateEnd, float price, String status) {
        this.roomNumber = roomNumber;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.price = price;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public String getUName() {
        return UName;
    }

    public String getUPhone() {
        return UPhone;
    }

    public float getPrice() {
        return price;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public void setUPhone(String UPhone) {
        this.UPhone = UPhone;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}

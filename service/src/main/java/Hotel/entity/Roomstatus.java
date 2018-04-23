package Hotel.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roomstatus")
public class Roomstatus implements java.io.Serializable {

    @Id
    private int id;

    private String status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Roomhistory> roomhistories;

    public Roomstatus() {
    }

    public Roomstatus(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public Roomstatus(int id) {
        this.id = id;
    }

    public Roomstatus(int id, String status, List<Roomhistory> roomhistories) {
        this.id = id;
        this.status = status;
        this.roomhistories = roomhistories;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Roomhistory> getRoomhistories() {
        return this.roomhistories;
    }

    public void setRoomhistories(List<Roomhistory> roomhistories) {
        this.roomhistories = roomhistories;
    }

}

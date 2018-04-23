package Hotel.entity;

import javax.persistence.*;

@Entity
@Table(name = "roomuser")
public class Roomuser implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "u_name", nullable = false)
    private String UName;

    @Column(name = "u_login", nullable = false)
    private String ULogin;

    @Column(name = "u_pass", nullable = false)
    private String UPass;

    @Column(name = "u_mail", nullable = false)
    private String UMail;

    @Column(name = "u_phone", nullable = false)
    private String UPhone;

    @Column(name = "status", nullable = false)
    private String status;

    public Roomuser() {
    }

    public Roomuser(Integer id, String UName, String ULogin, String UPass, String UMail, String UPhone, String status) {
        this.id = id;
        this.UName = UName;
        this.ULogin = ULogin;
        this.UPass = UPass;
        this.UMail = UMail;
        this.UPhone = UPhone;
        this.status = status;
    }

    public Integer getId() {
        return this.id;
    }

    public Roomuser setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUName() {
        return this.UName;
    }

    public Roomuser setUName(String UName) {
        this.UName = UName;
        return this;
    }

    public String getULogin() {
        return this.ULogin;
    }

    public Roomuser setULogin(String ULogin) {
        this.ULogin = ULogin;
        return this;
    }

    public String getUPass() {
        return this.UPass;
    }

    public Roomuser setUPass(String UPass) {
        this.UPass = UPass;
        return this;
    }

    public String getUMail() {
        return this.UMail;
    }

    public Roomuser setUMail(String UMail) {
        this.UMail = UMail;
        return this;
    }

    public String getUPhone() {
        return this.UPhone;
    }

    public Roomuser setUPhone(String UPhone) {
        this.UPhone = UPhone;
        return this;
    }

    public String getStatus() {
        return this.status;
    }

    public Roomuser setStatus(String status) {
        this.status = status;
        return this;
    }

}

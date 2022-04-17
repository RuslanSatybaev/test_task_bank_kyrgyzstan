package spring_data_jpa.entity;

import javax.persistence.*;

@Entity //use for JPA. For JDBC you can clear this
@Table(name = "response")
public class DBLogXML {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "pay_id")
    private int p_id;

    @Column(name = "status")
    private String status;

    @Column(name = "message")
    private String  message;

    @Column(name = "date")
    private String  dts;

    public DBLogXML() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDts() {
        return dts;
    }

    public void setDts(String dts) {
        this.dts = dts;
    }
}
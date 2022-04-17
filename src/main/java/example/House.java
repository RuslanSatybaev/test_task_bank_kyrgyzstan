package example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@XmlRootElement(name = "response")

public class House {
    @XmlAttribute(name="id")
    public int id;

    @XmlAttribute(name="dts")
    public Date date;

    public int p_id;
    public String status;
    public String message;

    public House() {
    }
}
package example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "response")

public class House {
    @XmlAttribute(name="id")
    public int id;

    @XmlAttribute(name="dts")
    public String date;

    public int p_id;
    public String status;
    public String message;

    public House() {
    }
}
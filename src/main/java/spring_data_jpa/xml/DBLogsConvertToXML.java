package spring_data_jpa.xml;

import example.House;
import spring_data_jpa.entity.DBLogXML;
import spring_data_jpa.entity.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.List;

@XmlRootElement(name = "response")
public class DBLogsConvertToXML {

    private List<DBLogXML> logList;

    @XmlElement(name = "response")
    public List<DBLogXML> getLogList() {
        return logList;
    }

    public void setLogList(List<DBLogXML> logList) {
        this.logList = logList;
    }

    public String convertToXMLString(Employee employee) throws JAXBException {
        //создание объекта для сериализации в XML
        House dog = new House();

        dog.id = employee.getId();
        dog.date = employee.getDate();
        dog.p_id = 111222;
        dog.status = "1";
        dog.message = "PAYMENT CONFIRMED";

        //писать результат сериализации будем в Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(House.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // сама сериализация
        marshaller.marshal(dog, writer);

        //преобразовываем в строку все записанное в StringWriter
        String result = writer.toString();
        return result;
    }


}
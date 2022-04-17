package spring_data_jpa.xml;

import spring_data_jpa.entity.Response;
import spring_data_jpa.entity.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

@XmlRootElement(name = "response")
public class DBLogsConvertToXML {

    public String convertToXMLString(Employee employee) throws JAXBException {

        Response response = new Response();

        response.id = employee.getId();
        response.date = employee.getDate();
        response.p_id = 111222;
        response.status = "1";
        if (employee.getCommand().equals("pay")) {
            response.message = "PAYMENT CONFIRMED";
        } else if (employee.getCommand().equals("check")) {
            response.message = "ACCOUNT EXISTS";
        }

        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Response.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(response, writer);
        String result = writer.toString();
        return result;
    }
}
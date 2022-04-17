package example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class CatXml {

    public static void main(String[] args) throws JAXBException {
        //создание объекта для сериализации в XML
        House house = new House();


        //писать результат сериализации будем в Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(House.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // сама сериализация
        marshaller.marshal(house, writer);

        //преобразовываем в строку все записанное в StringWriter
        String result = writer.toString();
        System.out.println(result);
    }
}

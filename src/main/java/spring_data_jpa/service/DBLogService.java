package spring_data_jpa.service;

import org.springframework.stereotype.Service;
import spring_data_jpa.entity.DBLogXML;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class DBLogService {
    List<DBLogXML> logXML = new ArrayList<>();

    @PersistenceContext
    private EntityManager entityManager;

    public List<DBLogXML> queryAllDBLogsXML() {
        System.out.println("DBLogService queryAllDBLogsXML() is called");

        DBLogXML dbLogXML = new DBLogXML();
        dbLogXML.setId(1);
        dbLogXML.setP_id(25);
        dbLogXML.setStatus("1");
        dbLogXML.setMessage("PAYMENT CONFIRMED");
        logXML.add(dbLogXML);

        return logXML;
    }
}
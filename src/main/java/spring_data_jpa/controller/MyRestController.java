package spring_data_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_data_jpa.entity.Employee;
import spring_data_jpa.service.EmployeeService;
import spring_data_jpa.xml.DBLogsConvertToXML;

import javax.xml.bind.JAXBException;

@RestController
@RequestMapping("/api/employees")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/pay")
    public @ResponseBody
    String getPayXML(@RequestBody Employee employee) {
        employee.getDate();
        employeeService.saveEmployee(employee);
        DBLogsConvertToXML dbLogsConvertToXML = new DBLogsConvertToXML();
        try {
            return dbLogsConvertToXML.convertToXMLString(employee);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return "";
    }

    @PostMapping("/check")
    public @ResponseBody
    String getCheckXML(@RequestBody Employee employee) {
        employee.getDate();
        DBLogsConvertToXML dbLogsConvertToXML = new DBLogsConvertToXML();
        try {
            return dbLogsConvertToXML.convertToXMLString(employee);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return "";
    }
}

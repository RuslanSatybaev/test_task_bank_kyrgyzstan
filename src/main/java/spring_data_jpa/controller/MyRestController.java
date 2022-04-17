package spring_data_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_data_jpa.entity.DBLogXML;
import spring_data_jpa.entity.Employee;
import spring_data_jpa.service.DBLogService;
import spring_data_jpa.service.EmployeeService;
import spring_data_jpa.xml.DBLogsConvertToXML;

import javax.xml.bind.JAXBException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    DBLogService dbLogService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public @ResponseBody
    String getAllDBLogsXML(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        DBLogsConvertToXML dbLogsConvertToXML = new DBLogsConvertToXML();
        try {
            return dbLogsConvertToXML.convertToXMLString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return "";
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";
    }

    @RequestMapping(value = "/rest/getAllDBLogsXML", method = RequestMethod.GET, produces = "application/xml")
    public @ResponseBody
    DBLogsConvertToXML getAllDBLogsXML() {
        List<DBLogXML> dbLogsList = null;
        try {
            dbLogsList = dbLogService.queryAllDBLogsXML();  //JPA (Hibernate)
//            dbLogsList = dbLogService.queryAllDBLogsJDBCExampleXML(); //JDBC
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dbLogsList);
        DBLogsConvertToXML dbLogsConvertToXML = new DBLogsConvertToXML();
        dbLogsConvertToXML.setLogList(dbLogsList);
        return dbLogsConvertToXML;
    }
}

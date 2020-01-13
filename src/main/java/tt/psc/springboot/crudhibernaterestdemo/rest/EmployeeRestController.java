package tt.psc.springboot.crudhibernaterestdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tt.psc.springboot.crudhibernaterestdemo.dao.EmployeeDAO;
import tt.psc.springboot.crudhibernaterestdemo.entity.Employee;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeDAO.getEmployees();
    }
}

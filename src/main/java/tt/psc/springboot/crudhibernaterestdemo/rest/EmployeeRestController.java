package tt.psc.springboot.crudhibernaterestdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tt.psc.springboot.crudhibernaterestdemo.entity.Employee;
import tt.psc.springboot.crudhibernaterestdemo.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable(name = "employeeId") Integer id){
        Employee employee =  employeeService.getEmployee(id);
        if (employee == null){
            throw new RuntimeException("Employee with ID " + id + " not found!");
        }
        return employee;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employeeService.getEmployee(employee.getId());
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return employee;
    }

    @DeleteMapping("/{employeeId}")
    public void  deleteEmployee(@PathVariable Integer employeeId){
        employeeService.deleteById(employeeId);
    }
}

package tt.psc.springboot.crudhibernaterestdemo.service;

import tt.psc.springboot.crudhibernaterestdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee getEmployee(Integer id);
    void saveEmployee(Employee employee);
    void deleteById(Integer id);
    void updateEmployee(Employee employee);
}

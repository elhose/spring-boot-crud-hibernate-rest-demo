package tt.psc.springboot.crudhibernaterestdemo.dao;

import tt.psc.springboot.crudhibernaterestdemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getEmployees();

    Employee getEmployee(Integer id);

    void saveEmployee(Employee employee);

    void deleteById(Integer id);
}

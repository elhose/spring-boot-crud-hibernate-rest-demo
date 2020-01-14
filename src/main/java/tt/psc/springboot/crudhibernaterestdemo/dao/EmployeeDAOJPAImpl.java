package tt.psc.springboot.crudhibernaterestdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tt.psc.springboot.crudhibernaterestdemo.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getEmployees() {
        Query query = entityManager.createQuery("from Employee");

        return query.getResultList();
    }

    @Override
    public Employee getEmployee(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);

        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.remove(getEmployee(id));
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);

        employee.setId(dbEmployee.getId());
    }
}

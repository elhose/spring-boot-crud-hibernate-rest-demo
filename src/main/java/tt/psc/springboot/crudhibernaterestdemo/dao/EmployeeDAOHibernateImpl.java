package tt.psc.springboot.crudhibernaterestdemo.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tt.psc.springboot.crudhibernaterestdemo.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    //define entity manager - field injection
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getEmployees() {

        //get current hibernate session
        Session session = entityManager.unwrap(Session.class);

        //create query
        Query<Employee> query = session.createQuery("from Employee", Employee.class);

        //execute the guery
        List<Employee> list = query.getResultList();

        //get list
        return list;
    }

    @Override
    public void saveEmployee(Employee employee) {

        Session session = entityManager.unwrap(Session.class);

        session.save(employee);

    }

    @Override
    public Employee getEmployee(Integer id) {

        Session session = entityManager.unwrap(Session.class);

        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteById(Integer id) {

        Session session = entityManager.unwrap(Session.class);

        Employee employee = session.get(Employee.class,id);

        session.delete(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);

        session.update(employee);
    }
}

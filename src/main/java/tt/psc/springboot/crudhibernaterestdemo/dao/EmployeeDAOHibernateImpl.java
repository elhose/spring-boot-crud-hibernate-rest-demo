package tt.psc.springboot.crudhibernaterestdemo.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tt.psc.springboot.crudhibernaterestdemo.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

    //define entity manager - field injection
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
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
}

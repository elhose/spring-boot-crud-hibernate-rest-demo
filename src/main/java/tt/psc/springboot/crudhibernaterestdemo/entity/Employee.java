package tt.psc.springboot.crudhibernaterestdemo.entity;

import tt.psc.springboot.crudhibernaterestdemo.entity.names.NamesEmployee;

import javax.persistence.*;

@Entity
@Table(name = NamesEmployee.TABLENAME)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = NamesEmployee.FIRST_NAME)
    private String firstName;

    @Column(name = NamesEmployee.LAST_NAME)
    private String lastName;

    @Column(name = NamesEmployee.EMAIL)
    private String email;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

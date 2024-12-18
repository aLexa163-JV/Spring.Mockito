package pro.sky.Spring.Mockito;

import java.util.Objects;

import static org.apache.tomcat.util.IntrospectionUtils.capitalize;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int id;
    private int salary;

    public Employee(String firstName, String lastName, int id, int salary) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(firstName.toLowerCase());
        this.id = id;
        this.salary = salary;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(id, employee.id) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id, salary);
    }

    @Override
    public String toString() {
        return "Имя " + firstName +
                ", Фамилия" + lastName +
                ", отдел " + id +
                ", зарплата " + salary
                ;
    }


}

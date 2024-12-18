package pro.sky.Spring.Mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.sky.Spring.Mockito.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    @DisplayName("Тест добавления сотрудника")
    public void testAddEmployee() {
        Employee employee = new Employee("Иванов", "Иван", 1, 5000);
        employeeService.addEmployee(employee);
        assertEquals(1, employeeService.getAllEmployees().size());
    }

    @Test
    @DisplayName("Тест удаления сотрудника")
    public void testRemoveEmployee() {
        Employee employee = new Employee("Иванов", "Иван", 1, 5000);
        employeeService.addEmployee(employee);
        employeeService.removeEmployee(employee);
        assertEquals(0, employeeService.getAllEmployees().size());
    }

    @Test
    @DisplayName("Тест найти сотрудника")
    public void testFindEmployeeById() {
        Employee employee = new Employee("Иванов", "Иван", 1, 5000);
        employeeService.addEmployee(employee);
        assertEquals(employee, employeeService.findEmployeeById(1));
    }

    @Test
    @DisplayName("Тест поиска сотрудника по ID")
    public void testFindEmployeeByIdNotFound() {
        assertNull(employeeService.findEmployeeById(1));
    }
}

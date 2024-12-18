package pro.sky.Spring.Mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pro.sky.Spring.Mockito.service.DepartmentService;
import pro.sky.Spring.Mockito.service.EmployeeService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Тест поиска сотрудника по ID")
    public void testGetEmployeesByDepartmentId() {
        List<Employee> employees = Arrays.asList(
                new Employee("Иванов", "Иван", 1, 5000),
                new Employee("Петров", "Петр", 1, 6000)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        List<Employee> result = departmentService.getEmployeesByDepartmentId(1);
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Тест сумма зп по отделу")
    public void testGetSumSalaryByDepartmentId() {
        List<Employee> employees = Arrays.asList(
                new Employee("Иванов", "Иван", 1, 5000),
                new Employee("Петров", "Петр", 1, 6000)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        double result = departmentService.getSumSalaryByDepartmentId(1);
        assertEquals(11000, result);
    }

    @Test
    @DisplayName("Тест мах зп по отделу")
    public void testGetMaxSalaryByDepartmentId() {
        List<Employee> employees = Arrays.asList(
                new Employee("Иванов", "Иван", 1, 5000),
                new Employee("Петров", "Петр", 1, 6000)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        double result = departmentService.getMaxSalaryByDepartmentId(1);
        assertEquals(6000, result);
    }

    @Test
    @DisplayName("Тест мин зп по отделу")
    public void testGetMinSalaryByDepartmentId() {
        List<Employee> employees = Arrays.asList(
                new Employee("Иванов", "Иван", 1, 5000),
                new Employee("Петров", "Петр", 1, 6000)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        double result = departmentService.getMinSalaryByDepartmentId(1);
        assertEquals(5000, result);
    }

    @Test
    @DisplayName("Тест группировки сотрудников по отделу")
    public void testGetAllEmployeesGroupedByDepartment() {
        List<Employee> employees = Arrays.asList(
                new Employee("Иванов", "Иван", 1, 5000),
                new Employee("Петров", "Петр", 2, 6000)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        assertEquals(2, departmentService.getAllEmployeesGroupedByDepartment().size());
    }
}

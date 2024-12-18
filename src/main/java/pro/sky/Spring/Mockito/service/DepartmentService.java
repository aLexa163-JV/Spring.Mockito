package pro.sky.Spring.Mockito.service;

import org.springframework.beans.factory.annotation.Autowired;
import pro.sky.Spring.Mockito.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentService {
    @Autowired
    private EmployeeService employeeService;

    public List<Employee> getEmployeesByDepartmentId(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getId() == departmentId)
                .collect(Collectors.toList());
    }

    public double getSumSalaryByDepartmentId(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getId() == departmentId)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public double getMaxSalaryByDepartmentId(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getId() == departmentId)
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0);
    }

    public double getMinSalaryByDepartmentId(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getId() == departmentId)
                .mapToDouble(Employee::getSalary)
                .min()
                .orElse(0);
    }

    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getId));
    }

}

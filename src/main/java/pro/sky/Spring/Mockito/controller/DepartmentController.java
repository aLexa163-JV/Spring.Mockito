package pro.sky.Spring.Mockito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Spring.Mockito.Employee;
import pro.sky.Spring.Mockito.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{id}/employees")
    public List<Employee>getEmployeesByDepartmentId(@PathVariable int id) {
        return departmentService.getEmployeesByDepartmentId(id);
    }


    @GetMapping("/{id}/salary/sum")
    public double getSumSalaryByDepartmentId(@PathVariable int id) {
        return departmentService.getSumSalaryByDepartmentId(id);
    }

    @GetMapping("/{id}/salary/max")
    public double getMaxSalaryByDepartmentId(@PathVariable int id) {
        return departmentService.getMaxSalaryByDepartmentId(id);
    }

    @GetMapping("/{id}/salary/min")
    public double getMinSalaryByDepartmentId(@PathVariable int id) {
        return departmentService.getMinSalaryByDepartmentId(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return departmentService.getAllEmployeesGroupedByDepartment();
    }
}

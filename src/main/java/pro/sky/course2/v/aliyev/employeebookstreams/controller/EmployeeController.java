package pro.sky.course2.v.aliyev.employeebookstreams.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.v.aliyev.employeebookstreams.model.Employee;
import pro.sky.course2.v.aliyev.employeebookstreams.service.EmployeeService;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName,
                        @RequestParam float salary, @RequestParam int departmentId) {
        return employeeService.add(firstName, lastName, salary, departmentId);
    }

    @RequestMapping("remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @RequestMapping("find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @RequestMapping()
    public Collection<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
}

package pro.sky.course2.v.aliyev.employeebookstreams.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.v.aliyev.employeebookstreams.exception.EmployeeNotFoundException;
import pro.sky.course2.v.aliyev.employeebookstreams.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int departmentId) {
        return employeeService.getEmployees()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with max salary not found!"));
    }

    @Override
    public Employee getEmployeeWithMinSalary(int departmentId) {
        return employeeService.getEmployees()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with min salary not found!"));
    }

    @Override
    public List<Employee> getAllEmployee(int departmentId) {
        return employeeService.getEmployees()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployee() {
        return employeeService.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}

package pro.sky.course2.v.aliyev.employeebookstreams.service;

import pro.sky.course2.v.aliyev.employeebookstreams.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(int departmentId);
    Employee getEmployeeWithMinSalary(int departmentId);
    List<Employee> getAllEmployee(int departmentId);
    Map<Integer, List<Employee>> getAllEmployee();
}

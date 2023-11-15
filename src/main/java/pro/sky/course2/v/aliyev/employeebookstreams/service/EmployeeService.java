package pro.sky.course2.v.aliyev.employeebookstreams.service;

import pro.sky.course2.v.aliyev.employeebookstreams.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, float salary, int departmentId);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> getEmployees();
}

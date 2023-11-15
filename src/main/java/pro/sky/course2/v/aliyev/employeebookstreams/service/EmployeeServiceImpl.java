package pro.sky.course2.v.aliyev.employeebookstreams.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.v.aliyev.employeebookstreams.exception.EmployeeAlreadyAddedException;
import pro.sky.course2.v.aliyev.employeebookstreams.exception.EmployeeNotFoundException;
import pro.sky.course2.v.aliyev.employeebookstreams.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee add(String firstName, String lastName, float salary, int departmentId) {
        String fullName = getFullName(firstName, lastName);
        if (employees.containsKey(fullName)) {
            throw new EmployeeAlreadyAddedException("Сотрудник " + fullName + " уже есть в системе!");
        }
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        employees.put(fullName, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        String fullName = getFullName(firstName, lastName);
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFoundException("Сотрудник " + fullName + " не найден в системе!");
        }
        Employee employee = employees.get(fullName);
        employees.remove(fullName);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String fullName = getFullName(firstName, lastName);
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFoundException("Сотрудник " + fullName + " не найден в системе!");
        }
        return employees.get(fullName);
    }

    @Override
    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values()); // Unmodifiable client copy
    }

    private static String getFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}

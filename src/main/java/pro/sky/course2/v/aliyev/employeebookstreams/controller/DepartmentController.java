package pro.sky.course2.v.aliyev.employeebookstreams.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.v.aliyev.employeebookstreams.model.Employee;
import pro.sky.course2.v.aliyev.employeebookstreams.service.DepartmentService;

@RestController
@RequestMapping("departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping("max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam int departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @RequestMapping("min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam int departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }

    @RequestMapping("all")
    public ResponseEntity<?> getAll(@RequestParam(required = false) Integer departmentId) {
        return departmentId == null
                ? ResponseEntity.ok(departmentService.getAllEmployee())
                : ResponseEntity.ok(departmentService.getAllEmployee(departmentId));
    }
}

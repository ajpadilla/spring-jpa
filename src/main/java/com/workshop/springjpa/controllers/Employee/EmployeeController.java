package com.workshop.springjpa.controllers.Employee;


import com.workshop.springjpa.controllers.Employee.requests.CreateRequest;
import com.workshop.springjpa.dao.EmployeeSearchDao;
import com.workshop.springjpa.dao.SearchRequest;
import com.workshop.springjpa.models.Department;
import com.workshop.springjpa.models.Employee;
import com.workshop.springjpa.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeSearchDao employeeSearchDao;

    @PostMapping("/create")
    public ResponseEntity<Employee> register(@RequestBody CreateRequest request) {
        Employee employee = this.employeeService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
       // return ResponseEntity.status(HttpStatus.CREATED).body("Ejecuto el controlador");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getAddressById(@PathVariable Integer id) {
        Employee employee = this.employeeService.getEmployeeById(id);

        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = this.employeeService.getDepartments();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<List<Employee>> getAllDepartments(@PathVariable Integer id) {
        Department department = this.employeeService.getDepartmentById(id);
        return ResponseEntity.ok(department.getEmployees());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> getEmployee(@RequestBody SearchRequest request) {
        List<Employee> employees = this.employeeSearchDao.findAllByCriteria(request);
        return ResponseEntity.ok(employees);
    }
}

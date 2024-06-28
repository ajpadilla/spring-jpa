package com.workshop.springjpa.services;

import com.workshop.springjpa.controllers.Employee.requests.AddressRequest;
import com.workshop.springjpa.controllers.Employee.requests.CreateRequest;
import com.workshop.springjpa.models.Address;
import com.workshop.springjpa.models.Department;
import com.workshop.springjpa.models.Employee;
import com.workshop.springjpa.models.Mission;
import com.workshop.springjpa.repositories.AddressRepository;
import com.workshop.springjpa.repositories.DepartmentRepository;
import com.workshop.springjpa.repositories.EmployeeRepository;
import com.workshop.springjpa.repositories.MissionRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final DepartmentRepository departmentRepository;
    private final MissionRepository missionRepository;

    public Employee create(CreateRequest request) {

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        List<Mission> missions = request.getMissionIds().stream()
                .map(missionId -> missionRepository.findById(missionId)
                        .orElseThrow(() -> new RuntimeException("Mission not found")))
                .toList();


        var employee = Employee.builder()
                .identifier(request.getIdentifier())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .birthdate(request.getBirthdate())
                .role(request.getRole())
                .address(this.makeAddress(request.getAddress()))
                .department(department)
                .missions(missions)
                .build();
        return this.employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Integer id) {
        return this.employeeRepository.getReferenceById(id);
    }

    public List<Department> getDepartments() {
        return  this.departmentRepository.findAll();
    }

    public Department getDepartmentById(Integer id) {
        return  this.departmentRepository.getReferenceById(id);
    }

    private Address makeAddress(AddressRequest request) {
        Address address = new Address();
        address.setStreetName(request.getStreetName());
        address.setHouseNumber(request.getHouseNumber());
        address.setZipCode(request.getZipCode());
        return this.addressRepository.save(address);
    }
}

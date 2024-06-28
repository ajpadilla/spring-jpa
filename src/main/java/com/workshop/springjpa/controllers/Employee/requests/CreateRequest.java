package com.workshop.springjpa.controllers.Employee.requests;

import com.workshop.springjpa.models.Address;
import com.workshop.springjpa.models.Department;
import com.workshop.springjpa.models.EmployeeRole;
import com.workshop.springjpa.models.Mission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequest {
    private String identifier;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate birthdate;
    private EmployeeRole role;
    private AddressRequest address;
    private Integer departmentId;
    private List<Integer> missionIds;
}

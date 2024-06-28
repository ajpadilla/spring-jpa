package com.workshop.springjpa.controllers.Employee.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
    private String streetName;
    private String houseNumber;
    private String zipCode;
}

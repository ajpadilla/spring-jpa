package com.workshop.springjpa.repositories;

import com.workshop.springjpa.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}

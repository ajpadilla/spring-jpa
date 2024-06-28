package com.workshop.springjpa.repositories;

import com.workshop.springjpa.models.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Integer> {

}
package com.workshop.springjpa;

import com.workshop.springjpa.models.Department;
import com.workshop.springjpa.models.Mission;
import com.workshop.springjpa.repositories.DepartmentRepository;
import com.workshop.springjpa.repositories.MissionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringjpaApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringjpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
             MissionRepository missionRepository,
            DepartmentRepository departmentRepository
    ) {
        return args -> {
            Mission missionA = new Mission();
            missionA.setName("Mission_1");
            missionA.setDuration(8);
            Mission missionObjectA = missionRepository.save(missionA);
            System.out.println(missionObjectA.getId());
            System.out.println(missionObjectA);

            Mission missionB = new Mission();
            missionB.setName("Mission_2");
            missionB.setDuration(4);
            Mission missionObjectB = missionRepository.save(missionB);
            System.out.println(missionObjectB.getId());
            System.out.println(missionObjectB);

            Department departmentA = new Department();
            departmentA.setName("department A");
            departmentRepository.save(departmentA);

            Department departmentB = new Department();
            departmentB.setName("department B");
            departmentRepository.save(departmentB);
        };
    }

}

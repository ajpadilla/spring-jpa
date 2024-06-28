package com.workshop.springjpa.dao;

import com.workshop.springjpa.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeSearchDao {

    private final EntityManager entityManager;

    public List<Employee> findAllBySimpleQuery(String firstname, String lastname, String email) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        // select * from employee
        Root <Employee> root = criteriaQuery.from(Employee.class);

        // prepare where clause
        // WHERE first like '%ali%';
        Predicate firstnamePredicate = criteriaBuilder.like(root.get("firstname"), "%"+ firstname + "%");
        Predicate lastnamePredicate = criteriaBuilder.like(root.get("lastname"), "%"+ lastname + "%");
        Predicate emailPredicate = criteriaBuilder.like(root.get("email"), "%"+ email + "%");

        Predicate firstnameOrLastnamePredicate = criteriaBuilder.or(firstnamePredicate, lastnamePredicate);
        // => final query = SELECT * FROM employee Where firtsname like '%a%'
        // or lastname like '%a%' and email like '%email%'

        var andEmailPredicate = criteriaBuilder.and(firstnameOrLastnamePredicate,emailPredicate);
        criteriaQuery.where(andEmailPredicate);
        TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<Employee> findAllByCriteria(SearchRequest request) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        List<Predicate> predicates = new ArrayList<>();

        // SELECT FROM employee
        Root<Employee> root = criteriaQuery.from(Employee.class);

        if (request.getFirstname() != null) {
            Predicate firstnamePredicate = criteriaBuilder.like(root.get("firstname"), "%"+ request.getFirstname() + "%");
            predicates.add(firstnamePredicate);
        }

        if (request.getLastname() != null) {
            Predicate lastnamePredicate = criteriaBuilder.like(root.get("lastname"), "%"+ request.getLastname() + "%");
            predicates.add(lastnamePredicate);
        }

        if (request.getEmail() != null) {
            Predicate emailPredicate = criteriaBuilder.like(root.get("email"), "%"+ request.getEmail() + "%");
            predicates.add(emailPredicate);
        }

        criteriaQuery.where(criteriaBuilder.or(predicates.toArray(new Predicate[0])));
        TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}

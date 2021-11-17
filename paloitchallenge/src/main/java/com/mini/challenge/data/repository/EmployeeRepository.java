package com.mini.challenge.data.repository;

import com.mini.challenge.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM EMPLOYEE WHERE EMAIL_ADDRESS = :email ", nativeQuery = true)
    List<Employee> findByEmailAccount( @Param("email") String email);
}

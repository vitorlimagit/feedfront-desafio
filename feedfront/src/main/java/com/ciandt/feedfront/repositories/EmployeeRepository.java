package com.ciandt.feedfront.repositories;

import com.ciandt.feedfront.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//TODO: IMPLEMENTE A INTERFACE JPAREPOSITORY E MAPEIE A CLASSE PARA O SPRINGBOOT

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
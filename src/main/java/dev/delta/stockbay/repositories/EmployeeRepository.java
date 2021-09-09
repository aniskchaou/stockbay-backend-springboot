package dev.delta.stockbay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dev.delta.stockbay.entities.Employee;
import dev.delta.stockbay.entities.Supplier;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

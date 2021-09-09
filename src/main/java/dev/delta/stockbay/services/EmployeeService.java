package dev.delta.stockbay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.delta.stockbay.entities.Employee;
import dev.delta.stockbay.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public Employee saveOrUpdate(Employee employee) {

		return employeeRepository.save(employee);
	}

	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Employee findById(Long id) {
		return employeeRepository.getById(id);
	}

	public void delete(Long id) {
		Employee employee = findById(id);
		employeeRepository.delete(employee);
	}

	public long count() {
		return employeeRepository.count();
	}
}

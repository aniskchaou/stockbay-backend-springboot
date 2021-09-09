package dev.delta.stockbay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.delta.stockbay.entities.Income;
import dev.delta.stockbay.repositories.IncomeRepository;

@Service
public class IncomeService {
	@Autowired
	IncomeRepository incomeRepository;

	public Income saveOrUpdate(Income income) {

		return incomeRepository.save(income);
	}

	public Iterable<Income> findAll() {
		return incomeRepository.findAll();
	}

	public Income findById(Long id) {
		return incomeRepository.getById(id);
	}

	public void delete(Long id) {
		Income income = findById(id);
		incomeRepository.delete(income);
	}

	public long size() {
		// TODO Auto-generated method stub
		return incomeRepository.count();
	}
}

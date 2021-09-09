package dev.delta.stockbay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.delta.stockbay.entities.Expense;
import dev.delta.stockbay.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	ExpenseRepository expenseRepository;

	public Expense saveOrUpdate(Expense expense) {

		return expenseRepository.save(expense);
	}

	public Iterable<Expense> findAll() {
		return expenseRepository.findAll();
	}

	public Expense findById(Long id) {
		return expenseRepository.getById(id);
	}

	public void delete(Long id) {
		Expense expense = findById(id);
		expenseRepository.delete(expense);
	}

	public long size() {
		// TODO Auto-generated method stub
		return expenseRepository.count();
	}
}

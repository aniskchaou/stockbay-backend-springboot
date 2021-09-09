package dev.delta.stockbay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.delta.stockbay.entities.Category;
import dev.delta.stockbay.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	public Category saveOrUpdate(Category category) {

		return categoryRepository.save(category);
	}

	public Iterable<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		return categoryRepository.getById(id);
	}

	public void delete(Long id) {
		Category category = findById(id);
		categoryRepository.delete(category);
	}
}

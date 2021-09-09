package dev.delta.stockbay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.delta.stockbay.entities.Product;
import dev.delta.stockbay.repositories.ProductRepository;

@Service
@Transactional
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public Product saveOrUpdate(Product product) {

		return productRepository.save(product);
	}

	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		return productRepository.getById(id);
	}

	public void delete(Long id) {
		Product product = findById(id);
		productRepository.delete(product);
	}

	public long size() {
		// TODO Auto-generated method stub
		return productRepository.count();
	}
}

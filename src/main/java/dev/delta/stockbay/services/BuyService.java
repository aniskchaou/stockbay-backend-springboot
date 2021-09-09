package dev.delta.stockbay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.delta.stockbay.entities.Buy;
import dev.delta.stockbay.repositories.BuyRepository;

@Service

public class BuyService {
	@Autowired
	BuyRepository buyRepository;

	public Buy saveOrUpdate(Buy buy) {

		return buyRepository.save(buy);
	}

	public Iterable<Buy> findAll() {
		return buyRepository.findAll();
	}

	public Buy findById(Long id) {
		return buyRepository.getById(id);
	}

	public void delete(Long id) {
		Buy buy = findById(id);
		buyRepository.delete(buy);
	}
}

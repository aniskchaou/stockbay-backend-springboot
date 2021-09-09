package dev.delta.stockbay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.delta.stockbay.entities.Sell;
import dev.delta.stockbay.repositories.SellRepository;

@Service
public class SellService {
	@Autowired
	SellRepository sellRepository;

	public Sell saveOrUpdate(Sell sell) {

		return sellRepository.save(sell);
	}

	public Iterable<Sell> findAll() {
		return sellRepository.findAll();
	}

	public Sell findById(Long id) {
		return sellRepository.getById(id);
	}

	public void delete(Long id) {
		Sell sell = findById(id);
		sellRepository.delete(sell);
	}
}

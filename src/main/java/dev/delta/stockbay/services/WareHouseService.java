package dev.delta.stockbay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.delta.stockbay.entities.WareHouse;
import dev.delta.stockbay.repositories.WareHouseRepository;

@Service

public class WareHouseService {
	@Autowired
	WareHouseRepository wareHouseRepository;

	public WareHouse saveOrUpdate(WareHouse wareHouse) {

		return wareHouseRepository.save(wareHouse);
	}

	public Iterable<WareHouse> findAll() {
		return wareHouseRepository.findAll();
	}

	public WareHouse findById(Long id) {
		return wareHouseRepository.getById(id);
	}

	public void delete(Long id) {
		WareHouse wareHouse = findById(id);
		wareHouseRepository.delete(wareHouse);
	}
}

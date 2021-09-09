package dev.delta.stockbay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.delta.stockbay.entities.Configuration;
import dev.delta.stockbay.repositories.ConfigurationRepository;

@Service
public class ConfigurationService {
	@Autowired
	ConfigurationRepository configurationRepository;

	public Configuration saveOrUpdate(Configuration configuration) {

		return configurationRepository.save(configuration);
	}

	public Iterable<Configuration> findAll() {
		return configurationRepository.findAll();
	}

	public Configuration findById(Long id) {
		return configurationRepository.getById(id);
	}

	public void delete(Long id) {
		Configuration configuration = findById(id);
		configurationRepository.delete(configuration);
	}
}

package dev.delta.stockbay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.delta.stockbay.entities.Client;
import dev.delta.stockbay.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;

	public Client saveOrUpdate(Client client) {

		return clientRepository.save(client);
	}

	public Iterable<Client> findAll() {
		return clientRepository.findAll();
	}

	public Client findById(Long id) {
		return clientRepository.getById(id);
	}

	public void delete(Long id) {
		Client client = findById(id);
		clientRepository.delete(client);
	}
}

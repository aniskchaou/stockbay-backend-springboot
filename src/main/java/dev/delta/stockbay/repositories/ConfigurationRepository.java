package dev.delta.stockbay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dev.delta.stockbay.entities.Configuration;
import dev.delta.stockbay.entities.Supplier;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {

}

package dev.delta.stockbay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dev.delta.stockbay.entities.Buy;

public interface BuyRepository extends JpaRepository<Buy, Long> {

}

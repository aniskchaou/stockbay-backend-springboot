package dev.delta.stockbay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dev.delta.stockbay.entities.Supplier;
import dev.delta.stockbay.entities.WareHouse;

public interface WareHouseRepository extends JpaRepository<WareHouse, Long> {

}

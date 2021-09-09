package dev.delta.stockbay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import dev.delta.stockbay.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}

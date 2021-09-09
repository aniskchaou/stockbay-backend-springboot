package dev.delta.stockbay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dev.delta.stockbay.datas.InsertDataDB;
import dev.delta.stockbay.entities.Category;
import dev.delta.stockbay.repositories.CategoryRepository;
import dev.delta.stockbay.services.CategoryService;

@SpringBootApplication()
@ComponentScan({ "dev.delta.stockbay.security", "dev.delta.stockbay.controllers", "dev.delta.stockbay.datas",
		"dev.delta.stockbay.services" }) // to scan repository files
@EntityScan("dev.delta.stockbay.entities")
@EnableJpaRepositories("dev.delta.stockbay.repositories")
public class SpringbootStockBayApplication implements CommandLineRunner {

	@Autowired
	InsertDataDB dataDB;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStockBayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataDB.populate();

	}
}

package dev.delta.stockbay.datas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.delta.stockbay.entities.Buy;
import dev.delta.stockbay.entities.Category;
import dev.delta.stockbay.entities.Client;
import dev.delta.stockbay.entities.Configuration;
import dev.delta.stockbay.entities.Employee;
import dev.delta.stockbay.entities.Expense;
import dev.delta.stockbay.entities.Product;
import dev.delta.stockbay.entities.Revenue;
import dev.delta.stockbay.entities.Sell;
import dev.delta.stockbay.entities.Supplier;
import dev.delta.stockbay.entities.WareHouse;
import dev.delta.stockbay.repositories.BuyRepository;
import dev.delta.stockbay.repositories.CategoryRepository;
import dev.delta.stockbay.repositories.ClientRepository;
import dev.delta.stockbay.repositories.ConfigurationRepository;
import dev.delta.stockbay.repositories.EmployeeRepository;
import dev.delta.stockbay.repositories.ExpenseRepository;
import dev.delta.stockbay.repositories.ProductRepository;
import dev.delta.stockbay.repositories.RevenueRepository;
import dev.delta.stockbay.repositories.SellRepository;
import dev.delta.stockbay.repositories.SupplierRepository;
import dev.delta.stockbay.repositories.WareHouseRepository;

@Service
public class InsertDataDB {

	@Autowired
	SupplierRepository repositorySupplierRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ExpenseRepository expenseRepository;
	@Autowired
	SellRepository sellRepository;
	@Autowired
	RevenueRepository revenueRepository;
	@Autowired
	BuyRepository buyRepository;
	@Autowired
	ConfigurationRepository configurationRepository;
	@Autowired
	WareHouseRepository wareHouseRepository;
	@Autowired
	EmployeeRepository employeeRepository;

	public InsertDataDB() {
		// TODO Auto-generated constructor stub
	}

	public void populate() {
		Supplier supplier = new Supplier("CommonFit", "6T876554", "contact@commonfit.org", "CommonFit", "Panama",
				"Active", "N/A");
		Client client = new Client("Gratiana Nalini", "987979970", "Miami", "gratiana.nalini", "Active", "N/A");
		Category category = new Category("Electronic", "Active", "void");
		Product product = new Product("IPhone 6s", category, supplier, "unit", "233", "324", "231", "#JNU8H7", "15",
				"warehouse", "N/A", "H78HHO");
		Expense expense = new Expense("12/09/2021", supplier, "Cash", "US 7556 675786 68587", "86965", "N/A");
		Sell sell = new Sell(client, "12/09/2021", "Active", "#IU7HO7");
		Revenue revenue = new Revenue("23/à8/2021", client, "type", "US 868 76988 9687 ", "342", "N/A");
		Buy buy = new Buy(supplier, product, "23/10/2020", "#O989", "pending");
		Configuration configuration = new Configuration("Stockbay", "contact@stockbay.cim", "", "English", "Dollar");
		Employee employee = new Employee("Sorley Olyvia", "sorleyolyvia@gmail.com", "7656760909", "Russia", "active");
		WareHouse wareHouse = new WareHouse("WareHouse 005", "Active", "void");
		repositorySupplierRepository.save(supplier);
		clientRepository.save(client);
		categoryRepository.save(category);
		productRepository.save(product);
		expenseRepository.save(expense);
		sellRepository.save(sell);
		revenueRepository.save(revenue);
		buyRepository.save(buy);
		configurationRepository.save(configuration);
		employeeRepository.save(employee);
		wareHouseRepository.save(wareHouse);
	}
}

package dev.delta.stockbay.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.delta.stockbay.entities.Product;
import dev.delta.stockbay.services.ProductService;

@RestController
@RequestMapping("/stockbay/product")
@CrossOrigin
public class ProductController {
	@Autowired
	ProductService categoryService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Product projectProduct, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		Product newPT = categoryService.saveOrUpdate(projectProduct);

		return new ResponseEntity<Product>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Product> getAllProducts() {
		return categoryService.findAll();
	}

	@GetMapping("/size")
	public long getAllProductSize() {
		return categoryService.size();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product category = categoryService.findById(id);
		return new ResponseEntity<Product>(category, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		categoryService.delete(id);
		return new ResponseEntity<String>("category was deleted", HttpStatus.OK);
	}
}

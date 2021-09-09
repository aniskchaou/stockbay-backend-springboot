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

import dev.delta.stockbay.entities.Income;
import dev.delta.stockbay.services.IncomeService;

@RestController
@RequestMapping("/stockbay/income")
@CrossOrigin
public class IncomeController {
	@Autowired
	IncomeService incomeService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Income projectIncome, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		Income newPT = incomeService.saveOrUpdate(projectIncome);

		return new ResponseEntity<Income>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Income> getAllIncomes() {
		return incomeService.findAll();
	}

	@GetMapping("/size")
	public long getIncomeSize() {
		return incomeService.size();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Income> getIncomeById(@PathVariable Long id) {
		Income income = incomeService.findById(id);
		return new ResponseEntity<Income>(income, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteIncome(@PathVariable Long id) {
		incomeService.delete(id);
		return new ResponseEntity<String>("income was deleted", HttpStatus.OK);
	}
}

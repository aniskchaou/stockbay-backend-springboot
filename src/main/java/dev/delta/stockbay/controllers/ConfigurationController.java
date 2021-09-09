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

import dev.delta.stockbay.entities.Configuration;
import dev.delta.stockbay.services.ConfigurationService;

@RestController
@RequestMapping("/stockbay/configuration")
@CrossOrigin
public class ConfigurationController {
	@Autowired
	ConfigurationService configurationService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Configuration projectConfiguration,
			BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		Configuration newPT = configurationService.saveOrUpdate(projectConfiguration);

		return new ResponseEntity<Configuration>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Configuration> getAllConfigurations() {
		return configurationService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Configuration> getConfigurationById(@PathVariable Long id) {
		Configuration configuration = configurationService.findById(id);
		return new ResponseEntity<Configuration>(configuration, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteConfiguration(@PathVariable Long id) {
		configurationService.delete(id);
		return new ResponseEntity<String>("configuration was deleted", HttpStatus.OK);
	}
}

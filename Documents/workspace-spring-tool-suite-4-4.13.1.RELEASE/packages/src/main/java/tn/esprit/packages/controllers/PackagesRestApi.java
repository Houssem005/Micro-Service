package tn.esprit.packages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import tn.esprit.packages.entities.Packages;
import tn.esprit.packages.services.PackagesServices;
@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class PackagesRestApi {
	private String title = "Hello,I'm the packages Microservice";
	@Autowired
	PackagesServices PKService;

	@RequestMapping("/hello")
	public String sayHello() {

		System.out.println(title);
		return title;
	}
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Packages> createReservation(@RequestBody Packages a) {

		return new ResponseEntity<>(PKService.addPackages(a), HttpStatus.OK);
	}

	@GetMapping("/list")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Packages>> getReservations() {

		return new ResponseEntity<>(PKService.getAllPackages(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Packages> getByIdPackages(@PathVariable(value = "id") int id) {

		return new ResponseEntity<>(PKService.getByIdPackages(id), HttpStatus.OK);
	}
	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Packages updatePackages(@PathVariable(value = "id") int id, @RequestBody Packages a) {

		return PKService.updatePackages(id, a);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deletePackages(@PathVariable(value = "id") int id) {

		return new ResponseEntity<String>(PKService.deletePackages(id), HttpStatus.OK);
	}

}

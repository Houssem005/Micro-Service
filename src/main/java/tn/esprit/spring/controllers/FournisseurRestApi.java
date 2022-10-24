package tn.esprit.spring.controllers;
import org.springframework.http.HttpStatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.services.FournisseurService;


@CrossOrigin("*")
@RestController
@RequestMapping("/Fournisseur")
public class FournisseurRestApi {
	private String title = "Hello,I'm the reservation Microservice";
	@Autowired
	FournisseurService FournisseurService;

	@RequestMapping("/hellof")
	public String sayHello() {

		System.out.println(title);
		return title;
	}
	@PostMapping("/addFournisseur")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Fournisseur> createFournisseur(@RequestBody Fournisseur a) {

		return new ResponseEntity<>(FournisseurService.addFournisseur(a), HttpStatus.OK);
	}

	@GetMapping("/listFournisseur")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Fournisseur>> getFournisseur() {

		return new ResponseEntity<>(FournisseurService.getAllFournisseur(), HttpStatus.OK);
	}
	
	@GetMapping("/getFournisseur/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Fournisseur> getByIdFournisseur(@PathVariable(value = "id") int id) {

		return new ResponseEntity<>(FournisseurService.getByIdFournisseur(id), HttpStatus.OK);
	}

	@PutMapping("/editFournisseur/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Fournisseur updateFournisseur(@PathVariable(value = "id") int id, @RequestBody Fournisseur a) {

		return FournisseurService.updateFournisseur(id, a);
	}

	@DeleteMapping("/deleteFournisseur/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteFournisseur(@PathVariable(value = "id") int id) {

		return new ResponseEntity<String>(FournisseurService.deleteFournisseur(id), HttpStatus.OK);
	}

}

package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.repositories.FournisseurRepository;

@Service
public class FournisseurService {

	@Autowired
	private FournisseurRepository fournisseurRepository;
		
		public Fournisseur addFournisseur(Fournisseur fournisseur) {
			return fournisseurRepository.save(fournisseur);

		}
		public List<Fournisseur> getAllFournisseur() {

			return fournisseurRepository.findAll();
		}
		
		public Fournisseur getByIdFournisseur(int id) {
			Fournisseur r = fournisseurRepository.findById(id).get();

			return r;
		}

		public String deleteFournisseur(int id) {

			if (fournisseurRepository.findById(id).isPresent()) {
			    fournisseurRepository.deleteById(id);
				return "Fournisseur supprimé";
			}
			else
				return " Fournisseur non supprimé";
		}

		public Fournisseur updateFournisseur(int id, Fournisseur a) {

			if (fournisseurRepository.findById(id).isPresent()) {
				Fournisseur existingFournisseur = fournisseurRepository.findById(id).get();
				existingFournisseur.setEmail(a.getEmail());
				existingFournisseur.setNom(a.getNom());
				existingFournisseur.setPrenom(a.getPrenom());
				return fournisseurRepository.save(existingFournisseur);

			}
			else
				return null;

		}
}

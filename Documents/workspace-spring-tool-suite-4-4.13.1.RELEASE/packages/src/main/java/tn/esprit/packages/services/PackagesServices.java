package tn.esprit.packages.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.packages.repositories.PackagesRepository;
import tn.esprit.packages.entities.Packages;

@Service
public class PackagesServices {


	@Autowired
	private PackagesRepository PKRepository;
		
		public Packages addPackages(Packages pk) {
			return PKRepository.save(pk);

		}
		public List<Packages> getAllPackages() {

			return PKRepository.findAll();
		}
		
		public Packages getByIdPackages(int id) {
			Packages r = PKRepository.findById(id).get();

			return r;
		}

		public String deletePackages(int id) {

			if (PKRepository.findById(id).isPresent()) {
				PKRepository.deleteById(id);
				return "Packages supprimé";
			}
			else
				return " Packages non supprimé ";
		}

		public Packages updatePackages(int id, Packages a) {

			if (PKRepository.findById(id).isPresent()) {
				Packages existingPK = PKRepository.findById(id).get();
				existingPK.setNom(a.getNom());;
				existingPK.setCap(a.getCap());;
				
				return PKRepository.save(existingPK);

			}
			else
				return null;

		}
}

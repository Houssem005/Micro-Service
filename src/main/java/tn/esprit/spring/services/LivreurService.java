package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Livreur;
import tn.esprit.spring.repositories.LivreurRepository;

@Service
public class LivreurService {

	@Autowired
	private LivreurRepository reservationRepository;
		
		public Livreur addReservation(Livreur reservation) {
			return reservationRepository.save(reservation);

		}
		public List<Livreur> getAllReservation() {

			return reservationRepository.findAll();
		}
		
		public Livreur getByIdReservation(int id) {
			Livreur r = reservationRepository.findById(id).get();

			return r;
		}

		public String deleteReservation(int id) {

			if (reservationRepository.findById(id).isPresent()) {
				reservationRepository.deleteById(id);
				return "reservation supprimé";
			}
			else
				return " reservation non supprimé";
		}

		public Livreur updateReservation(int id, Livreur a) {

			if (reservationRepository.findById(id).isPresent()) {
				Livreur existingReservation = reservationRepository.findById(id).get();
				existingReservation.setEmail(a.getEmail());;
				existingReservation.setNom(a.getNom());;
				existingReservation.setPrenom(a.getPrenom());
				return reservationRepository.save(existingReservation);

			}
			else
				return null;

		}
}

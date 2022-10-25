package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Livreur;

public interface LivreurRepository extends JpaRepository<Livreur, Integer> {

}

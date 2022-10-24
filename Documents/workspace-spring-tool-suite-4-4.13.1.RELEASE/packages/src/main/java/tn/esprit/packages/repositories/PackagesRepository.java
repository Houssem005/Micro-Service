package tn.esprit.packages.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.packages.entities.Packages;

public interface PackagesRepository extends JpaRepository<Packages, Integer> {


}

package tn.esprit.packages.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Packages implements  Serializable {
	private static final long sertianVersionUID = 6;
@Id
@GeneratedValue
	private int id;
	private String nom ; 
	private int cap ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public static long getSertianversionuid() {
		return sertianVersionUID;
	} 
	public Packages(int id, String nom, String prenom, int cap) {
		super();
		this.id = id;
		this.nom = nom;
		this.cap = cap;
	
	}
	public Packages() {
		super();
		// TODO Auto-generated constructor stub
	}
}

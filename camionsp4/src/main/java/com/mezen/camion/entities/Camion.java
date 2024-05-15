package com.mezen.camion.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
public class Camion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcamion;
	@NotNull
	@Size (min = 4,max = 15)
	private String nomcamion;
	@Min(value = 10)
	 @Max(value = 10000)
	private Double prixcamion;
	private String description;
	@ManyToOne
	private Marque marque;
	public Long getIdcamion() {
		return idcamion;
	}
	public void setIdcamion(Long idcamion) {
		this.idcamion = idcamion;
	}
	public String getNomcamion() {
		return nomcamion;
	}
	public void setNomcamion(String nomcamion) {
		this.nomcamion = nomcamion;
	}
	public Double getPrixcamion() {
		return prixcamion;
	}
	public void setPrixcamion(Double prixcamion) {
		this.prixcamion = prixcamion;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Camion( String nomcamion, Double prixcamion, String description) {
		super();

		this.nomcamion = nomcamion;
		this.prixcamion = prixcamion;
		this.description = description;
	}
	public Camion() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Camion [idcamion=" + idcamion + ", nomcamion=" + nomcamion + ", prixcamion=" + prixcamion
				+ ", description=" + description + "]";
	}
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}






}


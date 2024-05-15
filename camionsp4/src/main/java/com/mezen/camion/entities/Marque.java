package com.mezen.camion.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Marque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idmar;
	private String nommar;
	private String descriptionmar;
	@JsonIgnore
	@OneToMany(mappedBy = "marque")
	private List<Camion> camions;

}


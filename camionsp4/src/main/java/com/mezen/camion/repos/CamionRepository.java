package com.mezen.camion.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mezen.camion.entities.Camion;
import com.mezen.camion.entities.Marque;


public interface CamionRepository extends JpaRepository<Camion, Long> {
	List<Camion> findBynomcamion(String nom);
	List<Camion> findBynomcamionContains(String nom);
	@Query("select c from Camion c where c.nomcamion like %?1 and c.prixcamion > ?2")
	List<Camion> findByNomPrix (String nom, Double prix);
	@Query("select c from Camion c where c.marque = ?1")
	List<Camion> findByMarque (Marque marque);
	List<Camion> findByMarqueIdmar(Long id);

	List<Camion> findByOrderByNomcamionAsc();
	@Query("select c from Camion c order by c.nomcamion ASC, c.prixcamion DESC")
	List<Camion> trierCamionsNomsPrix ();


}

package com.mezen.camion.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mezen.camion.entities.Camion;
import com.mezen.camion
.entities.Marque;
import com.mezen.camion.repos.CamionRepository;
import com.mezen.camion.repos.MarqueRepository;
@Service
public class CamionServiceImpl implements CamionService {

	@Autowired
	CamionRepository camionRepository;

	@Autowired
	MarqueRepository marqueRepository;



	@Override
	public Camion saveCamion(Camion c) {
		return camionRepository.save(c);
	}

	@Override
	public Camion updateCamion(Camion c) {
		return camionRepository.save(c);
	}

	@Override
	public void deleteCamion(Camion c) {
		camionRepository.delete(c);

	}

	@Override
	public void deleteCamionById(Long id) {
		camionRepository.deleteById(id);

	}

	@Override
	public Camion getCamion(Long id) {
		return camionRepository.findById(id).get();
	}

	@Override
	public List<Camion> getAllCamions() {
		return camionRepository.findAll();
	}
	@Override
	public Page<Camion> getAllCamionsParPage(int page, int size) {
	return camionRepository.findAll(PageRequest.of(page, size));
}
	@Override
	public List<Camion> findBynomcamion(String nom) {

		return camionRepository.findBynomcamion(nom);
	}

	@Override
	public List<Camion> findBynomcamionContains(String nom) {
		return camionRepository.findBynomcamionContains(nom);
	}

	@Override
	public List<Camion> findByNomPrix(String nom, Double prix) {
		return camionRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Camion> findByMarque(Marque marque) {
		return camionRepository.findByMarque(marque);
	}

	@Override
	public List<Camion> findByMarqueIdmar(Long id) {
		return camionRepository.findByMarqueIdmar(id);
	}

	@Override
	public List<Camion> findByOrderByNomcamionAsc() {
		return camionRepository.findByOrderByNomcamionAsc();
	}

	@Override
	public List<Camion> trierCamionsNomsPrix() {
		return camionRepository.trierCamionsNomsPrix();
	}

	@Override
	public List<Marque> getAllMarques() {

		return marqueRepository.findAll();
	}



}

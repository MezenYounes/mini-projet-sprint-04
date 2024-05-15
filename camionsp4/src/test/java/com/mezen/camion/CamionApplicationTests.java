package com.mezen.camion;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mezen.camion.entities.Camion;
import com.mezen.camion.entities.Marque;
import com.mezen.camion.repos.CamionRepository;
import com.mezen.camion.service.CamionService;

@SpringBootTest
class CamionApplicationTests {


		@Autowired
		private CamionRepository camionRepository;
		@Autowired
		private CamionService camionservice;
		@Test
		public void testCreateCamion() {
		Camion cam = new Camion("Tacoma",45000.00,"Le Toyota Tacoma est un camion compact durable et fiable");
		camionRepository.save(cam);
		}
		 @Test
		 public void testFindCamion()
		 {
		 Camion c = camionRepository.findById(1L).get();
		 System.out.println(c);
		 }
		 @Test
		 public void testUpdateCamion()
		 {
		 Camion c = camionRepository.findById(1L).get();
		 c.setPrixcamion(30000.00);
		 camionRepository.save(c);
		 }
		 @Test
		 public void testDeleteCamion()
		 {
			 camionRepository.deleteById(1L);
		 }
		 @Test
		 public void testListerTousCamions()
		 {
		 List<Camion> cams = camionRepository.findAll();
		 for (Camion c : cams)
		 {
		 System.out.println(c);
		 }}
		// @Test
		// public void testFindByNomProduitContains()
		 {
		 //Page<Camion> cams = camionservice.getAllCamionsParPage(0,2);
		 //System.out.println(cams.getSize());
		// System.out.println(cams.getTotalElements());
		// System.out.println(cams.getTotalPages());
		// cams.getContent().forEach(p -> {System.out.println(p.toString());
		//  });

		 }
		 @Test
		 public void testFindBynomcamion()
		 {
		 List<Camion> cams = camionRepository.findBynomcamion("Tacoma");
		 for (Camion c : cams)
		 {
		 System.out.println(c);
		 }
		 }
		 @Test
		 public void testFindBynomcamionContains()
		 {
			 List<Camion> cams = camionRepository.findBynomcamionContains("a");
			 for (Camion c : cams)
			 {
			 System.out.println(c);
			 }
			 }
		 @Test
		 public void testfindByNomPrix()
		 {
		 List<Camion> cams = camionRepository.findByNomPrix("Tacoma", 40000.0);
		 for (Camion c : cams)
		 {
		 System.out.println(c);
		 }
		 }
		 @Test
		 public void testfindByMarque()
		 {
			 Marque mar = new Marque();
		 mar.setIdmar(1L);
		 List<Camion> cams = camionRepository.findByMarque(mar);
		 for (Camion c : cams)
		 {
		 System.out.println(c);
		 }
		 }
		 @Test
		 public void testfindByByMarqueIdmar()
		 {
		 List<Camion> cams = camionRepository.findByMarqueIdmar(1L);
		 for (Camion c : cams)
		 {
		 System.out.println(c);
		 }
		  }
		 @Test
		 public void testfindByOrderByNomcamionAsc()
		 {
		 List<Camion> cams =
		 camionRepository.findByOrderByNomcamionAsc();
		 for (Camion c : cams)
		 {
		 System.out.println(c);
		 }
		 }
		 @Test
		 public void testCamionsNomsPrix()
		 {
		 List<Camion> cams = camionRepository.trierCamionsNomsPrix();
		 for (Camion c : cams)
		 {
		 System.out.println(c);
		 }
}}
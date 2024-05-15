package com.mezen.camion.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mezen.camion.entities.Camion;
import com.mezen.camion.service.CamionService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CamionRESTController {
	@Autowired
	private CamionService camionservice;
	@RequestMapping(method = RequestMethod.GET)
	public List<Camion> getAllCamions() {
		return camionservice.getAllCamions();
		}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Camion getCamionById(@PathVariable("id") Long id) {
	return camionservice.getCamion(id);
}
	@RequestMapping(method = RequestMethod.POST)
	public Camion createCamion(@RequestBody Camion camion) {
	return camionservice.saveCamion(camion);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Camion updateCamion(@RequestBody Camion camion) {
	return camionservice.updateCamion(camion);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteCamion(@PathVariable("id") Long id)
	{
	camionservice.deleteCamionById(id);
	}
	@RequestMapping(value="/CamionMarq/{Idmar}",method = RequestMethod.GET)
	public List<Camion> getCamionByIdmar(@PathVariable("Idmar") Long Idmar) {
	return camionservice.findByMarqueIdmar(Idmar);
	}
}

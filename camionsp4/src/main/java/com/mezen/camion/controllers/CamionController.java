package com.mezen.camion.controllers;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mezen.camion.entities.Camion;
import com.mezen.camion.entities.Marque;
import com.mezen.camion.service.CamionService;

import jakarta.validation.Valid;

@Controller
public class CamionController {
	@Autowired
	private CamionService camionservice;

	@RequestMapping("/listeCamions")
	public String listeCamions(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Camion> cams = camionservice.getAllCamionsParPage(page, size);
	modelMap.addAttribute("camions", cams);
	modelMap.addAttribute("pages", new int[cams.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);

	return "listeCamions";
	}
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Marque> mar = camionservice.getAllMarques();
		if (mar != null && !mar.isEmpty()) {

			modelMap.addAttribute("camion", new Camion());
			modelMap.addAttribute("mode", "new");
			modelMap.addAttribute("marques", mar);
		} else {

			System.out.println("marques list is empty!");
		}

		return "formCamion";
	}
	@RequestMapping("/saveCamion")
	public String saveCamion(@Valid Camion camion, BindingResult bindingResult,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {

		int currentPage;
		boolean isNew = false;
		if (bindingResult.hasErrors())
			return "formCamion";
		if (camion.getIdcamion() == null) // ajout
			isNew = true;

		camionservice.saveCamion(camion);
		if (isNew) // ajout
		{
			Page<Camion> cams = camionservice.getAllCamionsParPage(page, size);
			currentPage = cams.getTotalPages() - 1;
		} else // modif
			currentPage = page;

		return ("redirect:/listeCamions?page=" + currentPage + "&size=" + size);
	}

	@RequestMapping("/supprimerCamion")
	public String supprimerCamion(@RequestParam("id") Long id,ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		camionservice.deleteCamionById(id);
		Page<Camion> cams = camionservice.getAllCamionsParPage(page, size);
	modelMap.addAttribute("camions", cams);
	modelMap.addAttribute("pages", new int[cams.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);


	return "listeCamions";
	}
	@RequestMapping("/modifierCamion")
	public String editerCCamion(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {

		Camion c = camionservice.getCamion(id);
		List<Marque> mar = camionservice.getAllMarques();
		modelMap.addAttribute("camion", c);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("marques", mar);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);

		return "formCamion";
	}
	@RequestMapping("/updateCamion")
	public String updateCamion(@ModelAttribute("camion") Camion camion, ModelMap modelMap) throws ParseException
	{

		camionservice.updateCamion(camion);
	 List<Camion> cams = camionservice.getAllCamions();
	 modelMap.addAttribute("camions", cams);
	return "listeCamions";
	}
	@GetMapping(value = "/")
	public String welcome() {
	 return "index";
	}



	}







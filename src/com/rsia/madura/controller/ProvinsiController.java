package com.rsia.madura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Timestamp;

import com.rsia.madura.entity.m_Provinsi;
import com.rsia.madura.service.ProvinsiService;


@Controller
@RequestMapping("/provinsi")
public class ProvinsiController {
	
	@Autowired
	private ProvinsiService provinsiService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String ProvinsiFormView(Model model, @RequestParam(value="page", required=false) int page, 
			@RequestParam(value="limit", required=false) int limit){
		List<m_Provinsi> result = provinsiService.getProvinsis(page, limit);
		String link = provinsiService.createLinks(page, limit);
		
		model.addAttribute("provinsi", result);
		model.addAttribute("link", link);
		
		return "/provinsi/WilayahProvinsiListView";
	}
	
	@RequestMapping(value="/form-add")
	public String ProvinsiFormView(Model model){
		m_Provinsi provinsiModel = new m_Provinsi();
		
		model.addAttribute("provinsiModel", provinsiModel);
		
		return "/provinsi/WilayahProvinsiAddForm";
	}
	
	@RequestMapping(value="/store", method=RequestMethod.POST)
	public String provinsiStore(@ModelAttribute("provinsiModel") m_Provinsi provinsiModel) {
		
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		provinsiModel.setPropinsiAktif("Y");
		provinsiModel.setPropinsiCreatedBy("Rizki");
		provinsiModel.setPropinsiCreatedDate(currentTime);
		
		provinsiService.store(provinsiModel);
		
		return "redirect:http://localhost:8080/com.rsia.modura/provinsi/list/?page=1&limit=10";
	}

}

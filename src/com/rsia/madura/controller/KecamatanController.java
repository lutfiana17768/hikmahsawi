package com.rsia.madura.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rsia.madura.entity.m_Kecamatan;
import com.rsia.madura.entity.m_Kota;
import com.rsia.madura.service.KecamatanService;
import com.rsia.madura.service.KotaService;

@Controller
@RequestMapping("/kecamatan")
public class KecamatanController {
	@Autowired
	private KecamatanService kecamatanService;
	@Autowired
	private KotaService kotaService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String KecamatanListView(Model model, @RequestParam(value="page", required=false) int page, 
			@RequestParam(value="limit", required=false) int limit){
		List<m_Kecamatan> resultKecamatan = kecamatanService.getKecamatans(page, limit);
		String link = kecamatanService.createLinks(page, limit);
		
		model.addAttribute("kecamatan", resultKecamatan);
		model.addAttribute("link", link);
		
		return "/kecamatan/WilayahKecamatanListView";
	}
	
	@RequestMapping(value="/form-add")
	public String KecamatanFormAdd(Model model){
		List<m_Kota> resultKota = kotaService.getKotas();
		m_Kecamatan kecamatanModel = new m_Kecamatan();
		
		model.addAttribute("kota", resultKota);
		model.addAttribute("kecamatanModel", kecamatanModel);
		
		return "/kecamatan/WilayahKecamatanAddForm";
	}
	
	@RequestMapping(value="/store", method=RequestMethod.POST)
	public String kecamatanStore(@ModelAttribute("kecamatanModel") m_Kecamatan kecamatanModel) {
		
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		kecamatanModel.setKecamatanAktif("Y");
		kecamatanModel.setKecamatanCreatedBy("Rizki");
		kecamatanModel.setKecamatanCreatedDate(currentTime);
		
		kecamatanService.store(kecamatanModel);
		
		return "redirect:http://localhost:8080/com.rsia.modura/kecamatan/list/?page=1&limit=10";
	}
}

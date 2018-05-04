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

import com.rsia.madura.entity.m_Kelurahan;
import com.rsia.madura.service.KelurahanService;
import com.rsia.madura.entity.m_Kecamatan;
import com.rsia.madura.service.KecamatanService;


@Controller
@RequestMapping("/kelurahan")
public class KelurahanController {
	
	@Autowired
	private KelurahanService kelurahanService;
	@Autowired
	private KecamatanService kecamatanService;
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String KelurahanListView(Model model, @RequestParam(value="page", required=false) int page, 
			@RequestParam(value="limit", required=false) int limit){
		List<m_Kelurahan> resultKelurahan = kelurahanService.getKelurahans(page, limit);
		String link = kelurahanService.createLinks(page, limit);
		
		model.addAttribute("kelurahan", resultKelurahan);
		model.addAttribute("link", link);
		
		return "/kelurahan/WilayahKelurahanListView";
	}
	
	@RequestMapping(value="/form-add")
	public String KelurahanFormAddView(Model model){
		List<m_Kecamatan> resultKecamatan = kecamatanService.getKecamatans();
		m_Kelurahan kelurahanModel = new m_Kelurahan();
		
		model.addAttribute("kecamatan", resultKecamatan);
		model.addAttribute("kelurahanModel", kelurahanModel);
		
		return "/kelurahan/WilayahKelurahanAddForm";
	}
	
	@RequestMapping(value="/store", method=RequestMethod.POST)
	public String kelurahanStore(@ModelAttribute("kelurahanModel") m_Kelurahan kelurahanModel) {
		
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		kelurahanModel.setKelurahanAktif("Y");
		kelurahanModel.setKelurahanCreatedBy("Rizki");
		kelurahanModel.setKelurahanCreatedDate(currentTime);
		
		kelurahanService.store(kelurahanModel);
		
		return "redirect:http://localhost:8080/com.rsia.modura/kelurahan/list/?page=1&limit=10";
	}
}

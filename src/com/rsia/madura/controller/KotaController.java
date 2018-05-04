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

import com.rsia.madura.entity.m_Kota;
import com.rsia.madura.entity.m_Provinsi;
import com.rsia.madura.service.KotaService;
import com.rsia.madura.service.ProvinsiService;

@Controller
@RequestMapping("/kota")
public class KotaController {
		
		@Autowired
		private KotaService kotaService;
		@Autowired
		private ProvinsiService provinsiService;
		
		@RequestMapping(value="/list", method=RequestMethod.GET)
		public String KotaFormView(Model model, @RequestParam(value="page", required=false) int page, 
				@RequestParam(value="limit", required=false) int limit){
			List<m_Kota> resultKota = kotaService.getKotas(page, limit);
			String links = kotaService.createLinks(page, limit);
			model.addAttribute("kota", resultKota);
			model.addAttribute("link", links);

			return "/kota/WilayahKotaListView";
		}
		
		@RequestMapping(value="/form-add")
		public String KotaFormView(Model model){
			List<m_Provinsi> resultProvinsi = provinsiService.getProvinsis();
			m_Kota kotaModel = new m_Kota();
			
			model.addAttribute("provinsi", resultProvinsi);
			model.addAttribute("kotaModel", kotaModel);

			return "/kota/WilayahKotaAddForm";
		}
		
		@RequestMapping(value="/store", method=RequestMethod.POST)
		public String kotaStore(@ModelAttribute("kotaModel") m_Kota kotaModel) {
			
			Timestamp currentTime = new Timestamp(System.currentTimeMillis());
			
			kotaModel.setkotaAktif("Y");
			kotaModel.setkotaCreatedBy("Rizki");
			kotaModel.setkotaCreatedDate(currentTime);
			
			kotaService.store(kotaModel);
			
			return "redirect:http://localhost:8080/com.rsia.modura/kota/list/?page=1&limit=10";
		}
}

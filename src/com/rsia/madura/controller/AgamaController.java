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

import com.rsia.madura.entity.m_Agama;
import com.rsia.madura.service.AgamaService;

@Controller
@RequestMapping("/Agama")
public class AgamaController {
	@Autowired
	private AgamaService agamaService;
	
	private String uri ="redirect:http://localhost:8080/com.rsia.modura/Agama/tambah/?page=1&limit=10" ;
		
	@RequestMapping(value="/tambah", method=RequestMethod.GET)
	public String FormView(Model model, 
			@RequestParam(value="page", required=false) int page, 
			@RequestParam(value="limit", required=false) int limit){
		
		List<m_Agama> result = agamaService.getAgamas(page, limit);
		String link = agamaService.createLinks(page, limit);
		m_Agama agamaModel = new m_Agama();
		
		model.addAttribute("agama", result);
		model.addAttribute("link", link);
		model.addAttribute("agamaModel", agamaModel);
		
		return "/Agama/AgamaAddForm";
	}

	@RequestMapping(value="/store", method=RequestMethod.POST)
	public String Store(@ModelAttribute("agamaModel") m_Agama agamaModel) {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		agamaModel.setAgamaAktif("Y");
		agamaModel.setAgamaCreatedBy("Admin");	
		agamaModel.setAgamacreatedDate(currentTime);
		
		agamaService.store(agamaModel);
		
		return this.uri;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String DeleteUpdate(Model model, @RequestParam(value="Id", required=false) int id) {
		
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		m_Agama agamaModel = agamaService.getAgama(id);
		
		agamaModel.setAgamaAktif("T");
		agamaModel.setAgamaDeletedDate(currentTime);
		
		agamaService.delete(agamaModel);
		
		return this.uri;
	}
	
	@RequestMapping(value="/form-update", method=RequestMethod.GET)
	public String UpdateFormView(Model model, @RequestParam(value="Id", required=false) int id){
		
		m_Agama result = agamaService.getAgama(id);
		
		model.addAttribute("agamaModel", result);
		
		return "/Agama/AgamaUpdateForm";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String Update(@ModelAttribute("agamaModel") m_Agama agamaModel) {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		agamaModel.setAgamaAktif("Y");
		agamaModel.setAgamaCreatedBy("Admin");
		agamaModel.setAgamaUpdatedDate(currentTime);;
		
		agamaService.update(agamaModel);
		
		return this.uri;
	}
}

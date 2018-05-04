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

import com.rsia.madura.entity.m_Jabatan;
import com.rsia.madura.service.JabatanService;

@Controller
@RequestMapping("/jabatan")
public class JabatanController {
	@Autowired
	private JabatanService jabatanService;
	
	@RequestMapping(value="/list")
	public String JabatanListView(Model model) {
		List<m_Jabatan> resultJabatan = jabatanService.getJabatans();
		model.addAttribute("jabatan", resultJabatan);
		
		return "/jabatan/JabatanListView";
	}
	
	@RequestMapping(value="/form-add")
	public String JabatanFormAddView(Model model) {
		
		m_Jabatan jabatanModel = new m_Jabatan();
		model.addAttribute("jabatanModel", jabatanModel);
		
		return "/jabatan/JabatanAddForm";
	}
	
	@RequestMapping(value="/store", method=RequestMethod.POST)
	public String JabatanStore(@ModelAttribute("jabatanModel") m_Jabatan jabatanModel) {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		jabatanModel.setJabatanAktif('Y');
		jabatanModel.setJabatanCreatedBy("Admin");
		jabatanModel.setJabatanCreatedDate(currentTime);
		
		jabatanService.store(jabatanModel);
		
		return "redirect:http://localhost:8080/com.rsia.modura/jabatan/list";
	}
	
	@RequestMapping(value="/form-update", method=RequestMethod.GET)
	public String JabatanFormUpdateView(Model model, @RequestParam("jabatanId") int jabatanId) {
		m_Jabatan result = jabatanService.getJabatan(jabatanId);
		
		model.addAttribute("jabatanModel", result);
		
		return "/jabatan/JabatanUpdateForm";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String JabatanUpdate(@ModelAttribute("jabatanModel") m_Jabatan jabatanModel) {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		jabatanModel.setJabatanUpdatedBy("Admin");
		jabatanModel.setJabatanUpdatedDate(currentTime);
		
		jabatanService.update(jabatanModel);
		
		return "redirect:http://localhost:8080/com.rsia.modura/jabatan/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String JabatanDelete(@RequestParam("jabatanId") int jabatanId) {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		m_Jabatan jabatanModel = jabatanService.getJabatan(jabatanId);
		
		jabatanModel.setJabatanAktif('T');
		jabatanModel.setJabatanDeletedDate(currentTime);
		
		jabatanService.delete(jabatanModel);
		
		return "redirect:http://localhost:8080/com.rsia.modura/jabatan/list";
	}

}

package com.rsia.madura.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Pelayanan")
public class PelayananController {	
	
	private String uri ="redirect:http://localhost:8080/com.rsia.modura/Pelayanan/tambah/?page=1&limit=10" ;
		
	@RequestMapping(value="/tambah", method=RequestMethod.GET)
	public String FormView(Model model, 
			@RequestParam(value="page", required=false) int page, 
			@RequestParam(value="limit", required=false) int limit){
		
		return "/Pelayanan/PelayananAddForm";
	}
	
	@RequestMapping(value="/form-update", method=RequestMethod.GET)
	public String UpdateFormView(Model model, @RequestParam(value="Id", required=false) int id){
		
		return "/Pelayanan/PelayananUpdateForm";
	}
}

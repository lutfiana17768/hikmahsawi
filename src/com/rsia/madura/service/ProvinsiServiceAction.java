package com.rsia.madura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsia.madura.dao.ProvinsiDAO;
import com.rsia.madura.entity.m_Provinsi;

@Service
public class ProvinsiServiceAction implements ProvinsiService {
	@Autowired
	private ProvinsiDAO provinsiDAO;
	
	@Override
	@Transactional
	public List<m_Provinsi> getProvinsis() {
		// TODO Auto-generated method stub
		return provinsiDAO.getProvinsis();
	}
	
	@Override
	@Transactional
	public List<m_Provinsi> getProvinsis(int page, int limit){
		return provinsiDAO.getProvinsis(page, limit);
	}
	
	
	public String createLinks(int page, int limit) {
		return provinsiDAO.createLinks(page, limit);
	}
	
	@Override
	@Transactional
	public int store(m_Provinsi provinsiModel) {
		
		return provinsiDAO.provinsiStore(provinsiModel);
	}
}

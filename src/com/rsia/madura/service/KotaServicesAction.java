package com.rsia.madura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsia.madura.dao.KotaDAO;
import com.rsia.madura.entity.m_Kota;

@Service
public class KotaServicesAction implements KotaService{
	@Autowired
	private KotaDAO kotaDAO;
	
	@Override
	@Transactional
	public List<m_Kota> getKotas(int page, int limit) {
		
		return kotaDAO.getKotas(page, limit);
	}
	
	@Override
	@Transactional
	public List<m_Kota> getKotas() {
		
		return kotaDAO.getKotas();
	}
	
	public String createLinks(int page, int limit) {
		return kotaDAO.createLinks(page, limit);
	}

	@Override
	@Transactional
	public int store(m_Kota kotaModel) {
		
		return kotaDAO.kotaStore(kotaModel);
	}

}

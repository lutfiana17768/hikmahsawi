package com.rsia.madura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsia.madura.dao.KelurahanDAO;
import com.rsia.madura.entity.m_Kelurahan;

@Service
public class KelurahanServiceAction implements KelurahanService{
	
	@Autowired
	private KelurahanDAO kelurahanDAO;
	
	@Transactional
	@Override
	public List<m_Kelurahan> getKelurahans() {
		return kelurahanDAO.getKelurahans();
	}
	@Override
	@Transactional
	public List<m_Kelurahan> getKelurahans(int page, int limit){
		return kelurahanDAO.getKelurahans(page, limit);
	}
	
	@Override
	@Transactional
	public String createLinks(int page, int limit) {
		return kelurahanDAO.createLinks(page, limit);
	}
	
	@Override
	@Transactional
	public int store(m_Kelurahan kelurahanModel) {
		return kelurahanDAO.kelurahanStore(kelurahanModel);
		
	}
}

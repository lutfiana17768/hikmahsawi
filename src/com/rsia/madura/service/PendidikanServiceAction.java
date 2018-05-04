package com.rsia.madura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsia.madura.dao.PendidikanDAO;
import com.rsia.madura.entity.m_Pendidikan;

@Service
public class PendidikanServiceAction implements PendidikanService{
	@Autowired
	private PendidikanDAO pendidikanDAO;
	
	@Transactional
	@Override
	public List<m_Pendidikan> getPendidikan(){
		return pendidikanDAO.getPendidikan();
	}
}

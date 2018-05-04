package com.rsia.madura.service;

import java.util.List;

import com.rsia.madura.entity.m_Kota;

public interface KotaService {
	public List<m_Kota> getKotas(int page, int limit);
	public List<m_Kota> getKotas();
	public String createLinks(int page, int limit);
	
	public int store(m_Kota kotaModel);
}

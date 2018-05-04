package com.rsia.madura.service;

import java.util.List;

import com.rsia.madura.entity.m_Kecamatan;

public interface KecamatanService {
	public List<m_Kecamatan> getKecamatans();
	public List<m_Kecamatan> getKecamatans(int page, int limit);
	public String createLinks(int page, int limit);
	
	public int store(m_Kecamatan kecamatanModel);
}

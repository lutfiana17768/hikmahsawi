package com.rsia.madura.service;

import java.util.List;
import com.rsia.madura.entity.m_Provinsi;

public interface ProvinsiService {
	public List<m_Provinsi> getProvinsis();
	public List<m_Provinsi> getProvinsis(int page, int limit);
	
	public String createLinks(int page, int limit);
	public int store(m_Provinsi provinsiModel);
	
}

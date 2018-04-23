package com.rsia.madura.service;

import java.util.List;
 
import com.rsia.madura.entity.m_Agama;

public interface AgamaService {	
	public List<m_Agama> getAgamas();
	public List<m_Agama> getAgamas(int page, int limit);
	public String createLinks(int page, int limit);
	public m_Agama getAgama(int id);
	
	public int store(m_Agama data);
	public void update(m_Agama data);
	public void delete(m_Agama data);
}

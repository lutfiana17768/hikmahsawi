package com.rsia.madura.dao;

import java.util.List;

import com.rsia.madura.entity.m_Agama;

public interface AgamaDAO {
	public List<m_Agama> getAgamas();
	public List<m_Agama> getAgamas(int page, int limit);
	public String createLinks(int page, int limit);
	public m_Agama getAgama(int AgamaId);
	
	public int AgamaStore(m_Agama AgamaModel);
	public void AgamaUpdate(m_Agama AgamaModel);
	public void AgamaDelete(m_Agama AgamaModel);
}

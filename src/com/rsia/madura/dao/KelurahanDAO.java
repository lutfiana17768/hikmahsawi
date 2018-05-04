package com.rsia.madura.dao;

import java.util.List;

import com.rsia.madura.entity.m_Kelurahan;

public interface KelurahanDAO {
	public List<m_Kelurahan> getKelurahans();
	public List<m_Kelurahan> getKelurahans(int page, int limit);
	public String createLinks(int page, int limit);
	public m_Kelurahan getKelurahan(int kelurahanId);
	
	public int kelurahanStore(m_Kelurahan kelurahanModel);
	public int kelurahanUpdate(m_Kelurahan kelurahanModel);
	public int kelurahanDelete(m_Kelurahan kelurahanModel);
}

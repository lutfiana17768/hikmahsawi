package com.rsia.madura.dao;

import java.util.List;

import com.rsia.madura.entity.m_Kecamatan;

public interface KecamatanDAO {
	public List<m_Kecamatan> getKecamatans();
	public List<m_Kecamatan> getKecamatans(int page, int limit);
	public String createLinks(int page, int limit);
	public m_Kecamatan getKecamatan(int kecamatanId);
	
	public int kecamatanStore(m_Kecamatan kecamatanModel);
	public int kecamatanUpdate(m_Kecamatan kecamatanModel);
	public int kecamatanDelete(m_Kecamatan kecamatanModel);
	
}

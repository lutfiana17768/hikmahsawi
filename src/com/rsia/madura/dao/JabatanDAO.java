package com.rsia.madura.dao;

import java.util.List;

import com.rsia.madura.entity.m_Jabatan;

public interface JabatanDAO {
	public List<m_Jabatan> getJabatans();
	public m_Jabatan getJabatan(int jabatanId);
	
	public int jabatanStore(m_Jabatan jabatanModel);
	public int jabatanUpdate(m_Jabatan jabatanModel);
	public int jabatanDelete(m_Jabatan jabatanModel);
}

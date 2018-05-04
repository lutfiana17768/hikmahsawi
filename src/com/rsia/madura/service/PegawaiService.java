package com.rsia.madura.service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.rsia.madura.entity.m_Pegawai;
import com.rsia.madura.entity.getPegawai;

public interface PegawaiService {
	public List<getPegawai> getPegawais();
	public m_Pegawai getPegawai(int pegawaiId);
	
	public int store(m_Pegawai pegawaiModel);
	public int getId();
	public int update(m_Pegawai pegawaiModel);
	public int delete(m_Pegawai pegawaiModel);
	public String upload(HttpServletRequest request, CommonsMultipartFile pegawaiFoto) throws IOException ;
	
	public Date convertDateToSQLType(Date date) throws Exception;
}

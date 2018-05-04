package com.rsia.madura.service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.rsia.madura.dao.PegawaiDAO;
import com.rsia.madura.entity.m_Pegawai;
import com.rsia.madura.entity.getPegawai;

@Service
public class PegawaiServiceAction implements PegawaiService {
	@Autowired
	private PegawaiDAO pegawaiDAO;
	
	@Override
	@Transactional
	public List<getPegawai> getPegawais() {
		
		return pegawaiDAO.getPegawais();
	}

	@Override
	@Transactional
	public m_Pegawai getPegawai(int pegawaiId) {
		
		return pegawaiDAO.getPegawai(pegawaiId);
	}

	@Override
	@Transactional
	public int store(m_Pegawai pegawaiModel) {
		
		return pegawaiDAO.pegawaiStore(pegawaiModel);
	}

	@Override
	@Transactional
	public int update(m_Pegawai pegawaiModel) {
		
		return pegawaiDAO.pegawaiUpdate(pegawaiModel);
	}

	@Override
	@Transactional
	public int delete(m_Pegawai pegawaiModel) {
		
		return pegawaiDAO.pegawaiDelete(pegawaiModel);
	}
	
	

	@Override
	public Date convertDateToSQLType(Date date) throws Exception {
		
		return pegawaiDAO.convertDateToSQLType(date);
	}

	@Override
	public String upload(HttpServletRequest request, CommonsMultipartFile pegawaiFoto) throws IOException {
		return pegawaiDAO.pegawaiUpload(request, pegawaiFoto);
		
	}
	
	@Override
	public int getId() {
		
		return pegawaiDAO.getId();
	}
}

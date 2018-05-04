package com.rsia.madura.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.rsia.madura.entity.m_Pegawai;
import com.rsia.madura.entity.getPegawai;

@Repository
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
public class PegawaiAction implements PegawaiDAO {
	@Autowired
	private SessionFactory sessionFactory;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public List<getPegawai> getPegawais() {
		Session current = sessionFactory.getCurrentSession();
		
		Query<getPegawai> pegawaiQuery = current.createQuery("from getPegawai where pegawaiAktif = 'Y'", getPegawai.class);
		List<getPegawai> result = pegawaiQuery.getResultList();
		
		return result;
	}

	@Override
	public m_Pegawai getPegawai(int pegawaiId) {
		Session current = sessionFactory.getCurrentSession();
		
		m_Pegawai result = current.get(m_Pegawai.class, pegawaiId);
		
		return result;
	}

	@Override
	public int pegawaiStore(m_Pegawai pegawaiModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.save(pegawaiModel);
		
		current.flush();
		
		this.id = pegawaiModel.getPegawai_id();
		
		return pegawaiModel.getPegawai_id();

	}

	@Override
	public int pegawaiUpdate(m_Pegawai pegawaiModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.saveOrUpdate(pegawaiModel);
		current.flush();
		
		return pegawaiModel.getPegawai_id();

	}

	@Override
	public int pegawaiDelete(m_Pegawai pegawaiModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.saveOrUpdate(pegawaiModel);
		current.flush();
		
		return pegawaiModel.getPegawai_id();
	}

	@Override
	public Date convertDateToSQLType(Date date) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String now = format.format(date);
		Date result = new Date(format.parse(now).getTime());
		
		return result;
		
	}

	@Override
	public String pegawaiUpload(HttpServletRequest request, CommonsMultipartFile pegawaiFoto )
			throws IOException {
		String appPath = request.getServletContext().getRealPath("");
        
        String savePath = appPath + "images/" + pegawaiFoto.getOriginalFilename();
        
        File fileSaveDir = new File(savePath);
        
        pegawaiFoto.transferTo(fileSaveDir);
        
        return savePath;
	}
}

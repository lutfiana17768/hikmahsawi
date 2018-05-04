package com.rsia.madura.service;

import java.sql.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsia.madura.dao.GajiDAO;
import com.rsia.madura.entity.t_Gaji;
import com.rsia.madura.entity.getGaji;

@Service
public class GajiServiceAction implements GajiService {
	@Autowired
	private GajiDAO gajiDAO;
	
	@Override
	@Transactional
	public List<getGaji> getGajis() {
	
		return gajiDAO.getGajis();
	}

	@Override
	@Transactional
	public t_Gaji getGaji(int gajiId) {
		
		return gajiDAO.getGaji(gajiId);	
	}
	
	@Override
	@Transactional
	public getGaji getReport(int gajiId) {
		
		return gajiDAO.getReport(gajiId);	
	}

	@Override
	public void getTotal(t_Gaji gajiModel) {
		
		gajiDAO.getTotal(gajiModel);

	}

	@Override
	@Transactional
	public int store(t_Gaji gajiModel) {
		
		return gajiDAO.gajiStore(gajiModel);

	}

	@Override
	@Transactional
	public int update(t_Gaji gajiModel) {
		
		return gajiDAO.gajiUpdate(gajiModel);

	}

	@Override
	@Transactional
	public int delete(t_Gaji gajiModel) {
		
		return gajiDAO.gajiDelete(gajiModel);

	}

	@Override
	public Date convertDateToSQLType(Date date) throws Exception {
		
		return gajiDAO.convertDateToSQLType(date);
	}

}
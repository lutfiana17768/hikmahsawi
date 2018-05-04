package com.rsia.madura.dao;

import java.sql.Date;
import java.util.List;

import com.rsia.madura.entity.t_Gaji;
import com.rsia.madura.entity.getGaji;

public interface GajiDAO {
	public List<getGaji> getGajis();
	public t_Gaji getGaji(int gajiId);
	public getGaji getReport(int gajiId);
	public void getTotal(t_Gaji gajiModel);
	
	public int gajiStore(t_Gaji gajiModel);
	public int gajiUpdate(t_Gaji gajiModel);
	public int gajiDelete(t_Gaji gajiModel);
	public Date convertDateToSQLType(Date date) throws Exception;
}

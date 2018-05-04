package com.rsia.madura.dao;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rsia.madura.entity.t_Gaji;
import com.rsia.madura.entity.getGaji;

@Repository
public class GajiAction implements GajiDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<getGaji> getGajis() {
		Session current = sessionFactory.getCurrentSession();
		
		Query<getGaji> gajiQuery = current.createQuery("from getGaji where gajiAktif = 'Y'", getGaji.class);
		List<getGaji> result = gajiQuery.getResultList();
		
		return result;
	}

	@Override
	public t_Gaji getGaji(int gajiId) {
		Session current = sessionFactory.getCurrentSession();
		
		t_Gaji result = current.get(t_Gaji.class, gajiId);
		
		return result;
	}
	
	@Override
	public getGaji getReport(int gajiId) {
		Session current = sessionFactory.getCurrentSession();
		
		getGaji result = current.get(getGaji.class, gajiId);
		
		return result;
	}

	@Override
	public void getTotal(t_Gaji gajiModel) {
		
		gajiModel.setGajiPendapatan(((gajiModel.getGajiPokok() + gajiModel.getGajiBonus()) - gajiModel.getGajiPotongan()) );
		
		double potonganPajak = gajiModel.getGajiPendapatan() * (gajiModel.getGajiPajak()/(double)100);
		
		gajiModel.setGajiPendapatan(gajiModel.getGajiPendapatan() - potonganPajak);
		
	}

	@Override
	public int gajiStore(t_Gaji gajiModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.save(gajiModel);
		current.flush();
		
		return gajiModel.getGaji_id();

	}

	@Override
	public int gajiUpdate(t_Gaji gajiModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.saveOrUpdate(gajiModel);
		current.flush();
		
		return gajiModel.getGaji_id();
	}

	@Override
	public int gajiDelete(t_Gaji gajiModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.saveOrUpdate(gajiModel);
		current.flush();
		
		return gajiModel.getGaji_id();
	}

	@Override
	public Date convertDateToSQLType(Date date) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String now = format.format(date);
		Date result = new Date(format.parse(now).getTime());
		
		return result;
	}

}

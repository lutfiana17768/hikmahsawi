package com.rsia.madura.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rsia.madura.entity.m_Pendidikan;

@Repository
public class PendidikanAction implements PendidikanDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<m_Pendidikan> getPendidikan() {
		Session current = sessionFactory.getCurrentSession();
		
		Query<m_Pendidikan> query = current.createQuery("from m_Pendidikan", m_Pendidikan.class);
		
		List<m_Pendidikan> Pendidikan = query.getResultList();
		return Pendidikan;
	}

}

package com.rsia.madura.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.rsia.madura.entity.s_User;

@Repository
public class UserAction implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<s_User> getUsers() {
		Session current = sessionFactory.getCurrentSession();
		
		Query<s_User> query = current.createQuery("from s_User where userAktif = 'Y'", s_User.class);
		 
		List<s_User> result = query.getResultList();
		
		return result;
	}

	@Override
	public s_User getUser(int userId) {
		Session current = sessionFactory.getCurrentSession();
		
		s_User result = current.get(s_User.class, userId);
		
		return result;
	}

	@Override
	public int userStore(s_User userModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.save(userModel);
		current.flush();
		
		return userModel.getUser_id();
	}

	@Override
	public int userUpdate(s_User userModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.saveOrUpdate(userModel);
		current.flush();
		
		return userModel.getUser_id();
	}

	@Override
	public int userDelete(s_User userModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.saveOrUpdate(userModel);
		current.flush();
		
		return userModel.getUser_id();

	}

}

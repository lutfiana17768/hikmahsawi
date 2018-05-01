package com.rsia.madura.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rsia.madura.entity.m_Agama;

@Repository
public class AgamaAction implements AgamaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public int total;

	@Override
	public List<m_Agama> getAgamas() {
		// TODO Auto-generated method stub
		Session current = sessionFactory.getCurrentSession();

		Query<m_Agama> query = current.createQuery("from m_agama", m_Agama.class);

		List<m_Agama> agama = query.getResultList();

		return agama;
	}

	@Override
	public List<m_Agama> getAgamas(int page, int limit) {
		// TODO Auto-generated method stub
		Session current = sessionFactory.getCurrentSession();
		Query<m_Agama> query = current.createQuery("from m_Agama where agamaAktif = 'Y'", m_Agama.class);
		List<m_Agama> agama = query.getResultList();
		this.total = agama.size();
		agama = this.getData(page, limit);

		return agama;
	}

	public List<m_Agama> getData(int page, int limit) {
		Session current = sessionFactory.getCurrentSession();
		Query<m_Agama> query = current.createQuery("from m_Agama where agamaAktif = 'Y'", m_Agama.class).setFirstResult((page - 1) * limit)
				.setMaxResults(limit);
		List<m_Agama> Result = query.getResultList();

		return Result;
	}

	@Override
	public String createLinks(int page, int limit) {
		// TODO Auto-generated method stub
		double last = Math.ceil((double) this.total / (double) limit);

		int start = ((page - 5) > 0) ? page - 5 : 1;
		int end = (int) (((page + 5) < last) ? page + 5 : last);

		String html = "<ul class='pagination'>";

		String first = (page == 1) ? "disabled" : "";
		html = html + "<li class='page-first' " + first + "><a href='?limit=" + limit + "&page=" + (page - 1)
				+ "'>&laquo;</a></li>";

		if (start > 1) {
			html = html + "<li class='page-number'><a href='?limit=" + limit + "&page=1'>1</a></li>";
			html = html + "<li class='page-number disabled'><span>...</span></li>";
		}

		for (int i = start; i <= end; i++) {
			String position = (page == i) ? "active" : "";
			html = html + "<li class='page-number ' " + position + "'><a href='?limit=" + limit + "&page=" + i + "'> "
					+ i + "</a></li>";
		}

		if (end < last) {
			html = html + "<li class='page-number disabled'><span>...</span></li>";
			html = html + "<li class='page-number'><a href='?limit=" + limit + "&page=" + (int) last + "'>" + (int) last
					+ "</a></li>";
		}

		String status = (page == (int) last) ? "disabled" : "";
		html = html + "<li class='page-number " + status + "'><a href='?limit=" + limit + "&page=" + (page + 1)
				+ "'>&raquo;</a></li>";

		html = html + "</ul>";

		return html;
	}

	@Override
	public m_Agama getAgama(int agamaId) {
		// TODO Auto-generated method stub
		Session current = sessionFactory.getCurrentSession();

		m_Agama result = current.get(m_Agama.class, agamaId);

		return result;
	}

	@Override
	public int AgamaStore(m_Agama AgamaModel) {
		Session current = sessionFactory.getCurrentSession();

		return (int)current.save(AgamaModel);

	}

	@Override
	public void AgamaUpdate(m_Agama AgamaModel) {
		Session current = sessionFactory.getCurrentSession();

		current.saveOrUpdate(AgamaModel);
	}

	@Override
	public void AgamaDelete(m_Agama AgamaModel) {
		Session current = sessionFactory.getCurrentSession();

		current.saveOrUpdate(AgamaModel);

	}
}

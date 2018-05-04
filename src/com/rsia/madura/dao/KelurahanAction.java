package com.rsia.madura.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rsia.madura.entity.m_Kelurahan;

@Repository
public class KelurahanAction implements KelurahanDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public int total;
	
	@Override
	public List<m_Kelurahan> getKelurahans() {
		Session current = sessionFactory.getCurrentSession();
		
		Query<m_Kelurahan> query = current.createQuery("from m_Kelurahan where kelurahanAktif = 'y'", m_Kelurahan.class);
		
		List<m_Kelurahan> Kelurahan = query.getResultList();
		
		return Kelurahan;
	}
	
	@Override
	public List<m_Kelurahan> getKelurahans(int page, int limit) {
		Session current = sessionFactory.getCurrentSession();
		
		this.total = ((Long)current.createQuery("select count(*) from m_Kelurahan").uniqueResult()).intValue();
		
		List<m_Kelurahan> Kelurahan = this.getData(page, limit);
		
		return Kelurahan;
	}
	
	public List<m_Kelurahan> getData( int page, int limit) {
    	Session current = sessionFactory.getCurrentSession();
    	Query<m_Kelurahan> query = current.createQuery("from m_Kelurahan where kelurahanAktif = 'y'", m_Kelurahan.class).setFirstResult((page-1)*limit).setMaxResults(limit);
        List<m_Kelurahan> Result = query.getResultList();

        return Result;
    }
	
	@Override
    public String createLinks(int page, int limit) {
        double last       = Math.ceil( (double)this.total / (double)limit );

        int start      = ( ( page - 5 ) > 0 ) ? page - 5 : 1;
        int end        = (int) (( ( page + 5 ) < last ) ? page + 5 : last);

        String html       = "<ul class='pagination'>";

        String first     = ( page == 1 ) ? "disabled" : "";
        html = html + "<li class='page-first' "+ first + "><a href='?limit=" + limit + "&page=" + ( page - 1 ) + "'>&laquo;</a></li>";

        if ( start > 1 ) {
            html   = html + "<li class='page-number'><a href='?limit="+ limit + "&page=1'>1</a></li>";
            html   = html + "<li class='page-number disabled'><span>...</span></li>";
        }

        for ( int i = start ; i <= end; i++ ) {
            String position  = ( page == i ) ? "active" : "";
            html   = html + "<li class='page-number ' " + position + "'><a href='?limit=" + limit + "&page=" + i + "'> "+ i + "</a></li>";
        }

        if ( end < last ) {
            html   = html + "<li class='page-number disabled'><span>...</span></li>";
            html   = html + "<li class='page-number'><a href='?limit=" + limit + "&page=" + (int)last + "'>" + (int)last + "</a></li>";
        }

        String status      = ( page == (int)last ) ? "disabled" : "";
        html       = html + "<li class='page-number " + status + "'><a href='?limit=" + limit + "&page=" + ( page + 1 ) + "'>&raquo;</a></li>";

        html       = html + "</ul>";

        return html;
    }

	@Override
	public m_Kelurahan getKelurahan(int kelurahanId) {
		Session current = sessionFactory.getCurrentSession();
		
		m_Kelurahan result = current.get(m_Kelurahan.class, kelurahanId);
		return result;
	}

	@Override
	public int kelurahanStore(m_Kelurahan kelurahanModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.save(kelurahanModel);
		current.flush();
		
		return kelurahanModel.getKelurahan_id();
		
	}

	@Override
	public int kelurahanUpdate(m_Kelurahan kelurahanModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.saveOrUpdate(kelurahanModel);
		current.flush();
		
		return kelurahanModel.getKelurahan_id();
		
	}

	@Override
	public int kelurahanDelete(m_Kelurahan kelurahanModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.saveOrUpdate(kelurahanModel);
		current.flush();
		
		return kelurahanModel.getKelurahan_id();
	}
}

package com.rsia.madura.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rsia.madura.entity.m_Provinsi;

@Repository
public class ProvinsiAction implements ProvinsiDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	public int total;
	
	@Override
	public List<m_Provinsi> getProvinsis() {
		Session current = sessionFactory.getCurrentSession();
		
		Query<m_Provinsi> query = current.createQuery("from m_Provinsi where propinsiAktif = 'Y'", m_Provinsi.class);
		
		List<m_Provinsi> provinsi = query.getResultList();
		return provinsi;
	}
	
	@Override
	public List<m_Provinsi> getProvinsis(int page, int limit){
		Session current = sessionFactory.getCurrentSession();
		
		this.total = ((Long)current.createQuery("select count(*) from m_Kota").uniqueResult()).intValue();
		
		List<m_Provinsi> provinsi = this.getData(page, limit);
		
		return provinsi;
	}
	
	public List<m_Provinsi> getData( int page, int limit) {
    	Session current = sessionFactory.getCurrentSession();
    	Query<m_Provinsi> query = current.createQuery("from m_Provinsi", m_Provinsi.class).setFirstResult((page-1)*limit).setMaxResults(limit);
        List<m_Provinsi> Result = query.getResultList();

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
	public int provinsiStore(m_Provinsi provinsiModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.save(provinsiModel);
		current.flush();
		
		return provinsiModel.getPropinsi_id();
	}

	@Override
	public m_Provinsi getProvinsi(int provinsiId) {
		Session current = sessionFactory.getCurrentSession();
		
		m_Provinsi result = current.get(m_Provinsi.class, provinsiId);
		
		return result;
	}

	@Override
	public int provinsiUpdate(m_Provinsi provinsiModel) {
		
		Session current = sessionFactory.getCurrentSession();
		
		current.saveOrUpdate(provinsiModel);
		current.flush();
		
		return provinsiModel.getPropinsi_id();		
	}

	@Override
	public int provinsiDelete(m_Provinsi provinsiModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.saveOrUpdate(provinsiModel);
		current.flush();
		
		return provinsiModel.getPropinsi_id();
	}
}

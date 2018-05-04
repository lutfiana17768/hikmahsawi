package com.rsia.madura.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rsia.madura.entity.m_Kota;

@Repository
public class kotaAction implements KotaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public int total;
	
	@Override
	public List<m_Kota> getKotas(int page, int limit) {
		Session current = sessionFactory.getCurrentSession();
		
		this.total = ((Long)current.createQuery("select count(*) from m_Kota").uniqueResult()).intValue();
		
		List<m_Kota> kota = this.getData(page, limit);
		
		return kota;
	}
	
	@Override
	public List<m_Kota> getKotas() {
		Session current = sessionFactory.getCurrentSession();
		
		Query<m_Kota> query = current.createQuery("from m_Kota", m_Kota.class);
		List<m_Kota> kota = query.getResultList();
		
		return kota;
	}
    
    public List<m_Kota> getData( int page, int limit) {
    	Session current = sessionFactory.getCurrentSession();
    	Query<m_Kota> query = current.createQuery("from m_Kota", m_Kota.class).setFirstResult((page-1)*limit).setMaxResults(limit);
        List<m_Kota> Result = query.getResultList();

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

        String status      = ( page == last ) ? "disabled" : "";
        html       = html + "<li class='page-number " + status + "'><a href='?limit=" + limit + "&page=" + ( page + 1 ) + "'>&raquo;</a></li>";

        html       = html + "</ul>";

        return html;
    }

	@Override
	public m_Kota getKota(int kotaId) {
		Session current = sessionFactory.getCurrentSession();
		
		m_Kota result = current.get(m_Kota.class, kotaId);
		return result;
	}

	@Override
	public int kotaStore(m_Kota kotaModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.save(kotaModel);
		current.flush();
		
		return kotaModel.getkota_id();
		
	}

	@Override
	public int kotaUpdate(m_Kota kotaModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.saveOrUpdate(kotaModel);
		current.flush();
		
		return kotaModel.getkota_id();
	}

	@Override
	public int kotaDelete(m_Kota kotaModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.saveOrUpdate(kotaModel);
		current.flush();
		
		return kotaModel.getkota_id();
	}
}

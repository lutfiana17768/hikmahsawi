package com.rsia.madura.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rsia.madura.entity.m_Kecamatan;

@Repository
public class KecamatanAction implements KecamatanDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public int total;
	
	@Override
	public List<m_Kecamatan> getKecamatans() {
		Session current = sessionFactory.getCurrentSession();
		
		Query<m_Kecamatan> query = current.createQuery("from m_Kecamatan where kecamatanAktif= 'Y'", m_Kecamatan.class);
		
		List<m_Kecamatan> Kecamatan = query.getResultList();
		return Kecamatan;
	}
	
	@Override
	public List<m_Kecamatan> getKecamatans(int page, int limit){
		Session current = sessionFactory.getCurrentSession();
		
		this.total = ((Long)current.createQuery("select count(*) from m_Kecamatan").uniqueResult()).intValue();
		
		List<m_Kecamatan> Kecamatan = this.getData(page, limit);
		
		return Kecamatan;
	}
	
	public List<m_Kecamatan> getData( int page, int limit) {
    	Session current = sessionFactory.getCurrentSession();
    	Query<m_Kecamatan> query = current.createQuery("from m_Kecamatan", m_Kecamatan.class).setFirstResult((page-1)*limit).setMaxResults(limit);
        List<m_Kecamatan> Result = query.getResultList();

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
	public m_Kecamatan getKecamatan(int kecamatanId) {
		Session current = sessionFactory.getCurrentSession();
		
		m_Kecamatan result = current.get(m_Kecamatan.class, kecamatanId);
		
		return result;
	}

	@Override
	public int kecamatanStore(m_Kecamatan kecamatanModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.save(kecamatanModel);
		current.flush();
		
		return kecamatanModel.getKecamatan_id();
	}

	@Override
	public int kecamatanUpdate(m_Kecamatan kecamatanModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.saveOrUpdate(kecamatanModel);
		current.flush();
		
		return kecamatanModel.getKecamatan_id();
	}

	@Override
	public int kecamatanDelete(m_Kecamatan kecamatanModel) {
		Session current = sessionFactory.getCurrentSession();
		
		current.saveOrUpdate(kecamatanModel);
		current.flush();
		
		return kecamatanModel.getKecamatan_id();
		
	}
}

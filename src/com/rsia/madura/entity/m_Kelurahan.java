package com.rsia.madura.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="m_kelurahan")
public class m_Kelurahan {
	
	@Column(name="kelurahan_id")
	private int kelurahan_id;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="kelurahan_kode")
	private String kelurahanKode;
	
	@Column(name="kelurahan_nama")
	private String kelurahanNama;
	
	@Column(name="kelurahan_aktif")
	private String kelurahanAktif;
	
	@Column(name="kelurahan_created_by")
	private String kelurahanCreatedBy;
	
	@Column(name="kelurahan_created_date")
	private Timestamp kelurahanCreatedDate;
	
	@Column(name="kelurahan_updated_by")
	private String kelurahanUpdatedBy;
	
	@Column(name="kelurahan_updated_date")
	private Timestamp kelurahanUpdatedDate;
	
	@Column(name="kelurahan_revised")
	private Integer kelurahanRevised;
	
	@Column(name="kelurahan_deleted_date")
	private Timestamp kelurahanDeletedDate;
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="m_kecamatan_kode", referencedColumnName="kecamatan_kode")
	private m_Kecamatan kecamatanKode;

	public int getKelurahan_id() {
		return kelurahan_id;
	}

	public void setKelurahan_id(int kelurahan_id) {
		this.kelurahan_id = kelurahan_id;
	}

	public String getKelurahanKode() {
		return kelurahanKode;
	}

	public void setKelurahanKode(String kelurahanKode) {
		this.kelurahanKode = kelurahanKode;
	}

	public String getKelurahanNama() {
		return kelurahanNama;
	}

	public void setKelurahanNama(String kelurahanNama) {
		this.kelurahanNama = kelurahanNama;
	}

	public String getKelurahanAktif() {
		return kelurahanAktif;
	}

	public void setKelurahanAktif(String kelurahanAktif) {
		this.kelurahanAktif = kelurahanAktif;
	}

	public String getKelurahanCreatedBy() {
		return kelurahanCreatedBy;
	}

	public void setKelurahanCreatedBy(String kelurahanCreatedBy) {
		this.kelurahanCreatedBy = kelurahanCreatedBy;
	}

	public Timestamp getKelurahanCreatedDate() {
		return kelurahanCreatedDate;
	}

	public void setKelurahanCreatedDate(Timestamp kelurahanCreatedDate) {
		this.kelurahanCreatedDate = kelurahanCreatedDate;
	}

	public String getKelurahanUpdatedBy() {
		return kelurahanUpdatedBy;
	}

	public void setKelurahanUpdatedBy(String kelurahanUpdatedBy) {
		this.kelurahanUpdatedBy = kelurahanUpdatedBy;
	}

	public Timestamp getKelurahanUpdatedDate() {
		return kelurahanUpdatedDate;
	}

	public void setKelurahanUpdatedDate(Timestamp kelurahanUpdatedDate) {
		this.kelurahanUpdatedDate = kelurahanUpdatedDate;
	}

	public Integer getKelurahanRevised() {
		return kelurahanRevised;
	}

	public void setKelurahanRevised(Integer kelurahanRevised) {
		this.kelurahanRevised = kelurahanRevised;
	}

	public Timestamp getKelurahanDeletedDate() {
		return kelurahanDeletedDate;
	}

	public void setKelurahanDeletedDate(Timestamp kelurahanDeletedDate) {
		this.kelurahanDeletedDate = kelurahanDeletedDate;
	}

	public m_Kecamatan getKecamatanKode() {
		return kecamatanKode;
	}

	public void setKecamatanKode(m_Kecamatan kecamatanKode) {
		this.kecamatanKode = kecamatanKode;
	}

	@Override
	public String toString() {
		return "m_Kelurahan [kelurahan_id=" + kelurahan_id + ", kelurahanKode=" + kelurahanKode + ", kelurahanNama="
				+ kelurahanNama + ", kelurahanAktif=" + kelurahanAktif + ", kelurahanCreatedBy=" + kelurahanCreatedBy
				+ ", kelurahanCreatedDate=" + kelurahanCreatedDate + ", kelurahanUpdatedBy=" + kelurahanUpdatedBy
				+ ", kelurahanUpdatedDate=" + kelurahanUpdatedDate + ", kelurahanRevised=" + kelurahanRevised
				+ ", kelurahanDeletedDate=" + kelurahanDeletedDate + ", kecamatanKode=" + kecamatanKode + "]";
	}

	
	
	
}

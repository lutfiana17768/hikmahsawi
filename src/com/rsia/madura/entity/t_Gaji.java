package com.rsia.madura.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_gaji")
public class t_Gaji {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="gaji_id")
	private int gaji_id;
	
	@Column(name="gaji_no")
	private String gajiNo;
	
	@Column(name="gaji_tglbayar")
	private Date gajiTglBayar;
	
	@Column(name="gaji_bulan")
	private String gajiBulan;
	
	@Column(name="gaji_tahun")
	private String gajiTahun;
	
	@Column(name="gaji_pegawai_id")
	private int gajiPegawaiId;
	
	@Column(name="gaji_pokok")
	private double gajiPokok;
	
	@Column(name="gaji_pajak")
	private double gajiPajak;
	
	@Column(name="gaji_pendapatan")
	private double gajiPendapatan;
	
	@Column(name="gaji_potongan")
	private double gajiPotongan;
	
	@Column(name="gaji_bonus")
	private double gajiBonus;
	
	@Column(name="gaji_keterangan")
	private String gajiKeterangan;
	
	@Column(name="gaji_aktif")
	private char gajiAktif;
	  
	@Column(name="gaji_created_by")
	private String gajiCreatedBy;
	
	@Column(name="gaji_created_date")
	private Timestamp gajiCreatedDate;
	  
	@Column(name="gaji_updated_by")
	private String gajiUpdatedBy;
	
	@Column(name="gaji_updated_date")
	private Timestamp gajiUpdatedDate;
	
	@Column(name="gaji_revised")
	private int gajiRevised;
	
	@Column(name="gaji_file")
	private String gajiFile;
	
	@Column(name="gaji_deleted_date")
	private Timestamp gajiDeletedDate;

	public t_Gaji() {
	
	}

	public int getGaji_id() {
		return gaji_id;
	}

	public void setGaji_id(int gaji_id) {
		this.gaji_id = gaji_id;
	}

	public String getGajiNo() {
		return gajiNo;
	}

	public void setGajiNo(String gajiNo) {
		this.gajiNo = gajiNo;
	}

	public Date getGajiTglBayar() {
		return gajiTglBayar;
	}

	public void setGajiTglBayar(Date gajiTglBayar) {
		this.gajiTglBayar = gajiTglBayar;
	}

	public String getGajiBulan() {
		return gajiBulan;
	}

	public void setGajiBulan(String gajiBulan) {
		this.gajiBulan = gajiBulan;
	}

	public String getGajiTahun() {
		return gajiTahun;
	}

	public void setGajiTahun(String gajiTahun) {
		this.gajiTahun = gajiTahun;
	}

	public double getGajiPokok() {
		return gajiPokok;
	}

	public void setGajiPokok(double gajiPokok) {
		this.gajiPokok = gajiPokok;
	}

	public double getGajiPendapatan() {
		return gajiPendapatan;
	}

	public void setGajiPendapatan(double gajiPendapatan) {
		this.gajiPendapatan = gajiPendapatan;
	}

	public double getGajiPotongan() {
		return gajiPotongan;
	}

	public void setGajiPotongan(double gajiPotongan) {
		this.gajiPotongan = gajiPotongan;
	}

	public double getGajiBonus() {
		return gajiBonus;
	}

	public void setGajiBonus(double gajiBonus) {
		this.gajiBonus = gajiBonus;
	}

	public String getGajiKeterangan() {
		return gajiKeterangan;
	}

	public void setGajiKeterangan(String gajiKeterangan) {
		this.gajiKeterangan = gajiKeterangan;
	}

	public char getGajiAktif() {
		return gajiAktif;
	}

	public void setGajiAktif(char gajiAktif) {
		this.gajiAktif = gajiAktif;
	}

	public String getGajiCreatedBy() {
		return gajiCreatedBy;
	}

	public void setGajiCreatedBy(String gajiCreatedBy) {
		this.gajiCreatedBy = gajiCreatedBy;
	}

	public Timestamp getGajiCreatedDate() {
		return gajiCreatedDate;
	}

	public void setGajiCreatedDate(Timestamp gajiCreatedDate) {
		this.gajiCreatedDate = gajiCreatedDate;
	}

	public String getGajiUpdatedBy() {
		return gajiUpdatedBy;
	}

	public void setGajiUpdatedBy(String gajiUpdatedBy) {
		this.gajiUpdatedBy = gajiUpdatedBy;
	}

	public Timestamp getGajiUpdatedDate() {
		return gajiUpdatedDate;
	}

	public void setGajiUpdatedDate(Timestamp gajiUpdatedDate) {
		this.gajiUpdatedDate = gajiUpdatedDate;
	}

	public int getGajiRevised() {
		return gajiRevised;
	}

	public void setGajiRevised(int gajiRevised) {
		this.gajiRevised = gajiRevised;
	}

	public String getGajiFile() {
		return gajiFile;
	}

	public void setGajiFile(String gajiFile) {
		this.gajiFile = gajiFile;
	}

	public Timestamp getGajiDeletedDate() {
		return gajiDeletedDate;
	}

	public void setGajiDeletedDate(Timestamp gajiDeletedDate) {
		this.gajiDeletedDate = gajiDeletedDate;
	}

	public double getGajiPajak() {
		return gajiPajak;
	}

	public void setGajiPajak(double gajiPajak) {
		this.gajiPajak = gajiPajak;
	}

	public int getGajiPegawaiId() {
		return gajiPegawaiId;
	}

	public void setGajiPegawaiId(int gajiPegawaiId) {
		this.gajiPegawaiId = gajiPegawaiId;
	}

	@Override
	public String toString() {
		return "t_Gaji [gaji_id=" + gaji_id + ", gajiNo=" + gajiNo + ", gajiTglBayar=" + gajiTglBayar + ", gajiBulan="
				+ gajiBulan + ", gajiTahun=" + gajiTahun + ", gajiPegawaiId=" + gajiPegawaiId + ", gajiPokok="
				+ gajiPokok + ", gajiPajak=" + gajiPajak + ", gajiPendapatan=" + gajiPendapatan + ", gajiPotongan="
				+ gajiPotongan + ", gajiBonus=" + gajiBonus + ", gajiKeterangan=" + gajiKeterangan + ", gajiAktif="
				+ gajiAktif + ", gajiCreatedBy=" + gajiCreatedBy + ", gajiCreatedDate=" + gajiCreatedDate
				+ ", gajiUpdatedBy=" + gajiUpdatedBy + ", gajiUpdatedDate=" + gajiUpdatedDate + ", gajiRevised="
				+ gajiRevised + ", gajiFile=" + gajiFile + ", gajiDeletedDate=" + gajiDeletedDate + "]";
	}
}

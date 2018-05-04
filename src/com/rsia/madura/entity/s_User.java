package com.rsia.madura.entity;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="s_user")
public class s_User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="s_usergroup_id")
	private int userGroupId;
	
	@Column(name="user_revised")
	private int userRevised;
	
	@Column(name="m_pegawai_id")
	private int pegawaiId;
	
	@Column(name="user_aktif")
	private char userAktif;
	
	@Column(name="user_created_date")
	private Timestamp userCreatedDate;
	
	@Column(name="user_created_by")
	private String userCreatedBy;
	
	@Column(name="user_updated_date")
	private Timestamp userUpdatedDate;
	
	@Column(name="user_updated_by")
	private String userUpdatedBy;
	
	@Column(name="user_counterid")
	private int userCounterId;
	
	@Column(name="user_login")
	private Timestamp userLogin;
	
	@Column(name="user_logout")
	private Timestamp userLogout;
	
	@Column(name="user_starttime")
	private Time userStartTime;
	
	@Column(name="user_endtime")
	private Time userEndTime;
	
	@Column(name="user_cabang")
	private int userCabang;
	
	@Column(name="reg_apps_id")
	private int regAppsId;
	
	@Column(name="user_unit")
	private String userUnit;
	
	@Column(name="user_deleted_date")
	private Timestamp userDeletedDate;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(int userGroupId) {
		this.userGroupId = userGroupId;
	}

	public int getUserRevised() {
		return userRevised;
	}

	public void setUserRevised(int userRevised) {
		this.userRevised = userRevised;
	}

	public int getPegawaiId() {
		return pegawaiId;
	}

	public void setPegawaiId(int pegawaiId) {
		this.pegawaiId = pegawaiId;
	}

	public char getUserAktif() {
		return userAktif;
	}

	public void setUserAktif(char userAktif) {
		this.userAktif = userAktif;
	}

	public Timestamp getUserCreatedDate() {
		return userCreatedDate;
	}

	public void setUserCreatedDate(Timestamp userCreatedDate) {
		this.userCreatedDate = userCreatedDate;
	}

	public String getUserCreatedBy() {
		return userCreatedBy;
	}

	public void setUserCreatedBy(String userCreatedBy) {
		this.userCreatedBy = userCreatedBy;
	}

	public Timestamp getUserUpdatedDate() {
		return userUpdatedDate;
	}

	public void setUserUpdatedDate(Timestamp userUpdatedDate) {
		this.userUpdatedDate = userUpdatedDate;
	}

	public String getUserUpdatedBy() {
		return userUpdatedBy;
	}

	public void setUserUpdatedBy(String userUpdatedBy) {
		this.userUpdatedBy = userUpdatedBy;
	}

	public int getUserCounterId() {
		return userCounterId;
	}

	public void setUserCounterId(int userCounterId) {
		this.userCounterId = userCounterId;
	}

	public Timestamp getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(Timestamp userLogin) {
		this.userLogin = userLogin;
	}

	public Timestamp getUserLogout() {
		return userLogout;
	}

	public void setUserLogout(Timestamp userLogout) {
		this.userLogout = userLogout;
	}

	public Time getUserStartTime() {
		return userStartTime;
	}

	public void setUserStartTime(Time userStartTime) {
		this.userStartTime = userStartTime;
	}

	public Time getUserEndTime() {
		return userEndTime;
	}

	public void setUserEndTime(Time userEndTime) {
		this.userEndTime = userEndTime;
	}

	public int getUserCabang() {
		return userCabang;
	}

	public void setUserCabang(int userCabang) {
		this.userCabang = userCabang;
	}

	public int getRegAppsId() {
		return regAppsId;
	}

	public void setRegAppsId(int regAppsId) {
		this.regAppsId = regAppsId;
	}

	public String getUserUnit() {
		return userUnit;
	}

	public void setUserUnit(String userUnit) {
		this.userUnit = userUnit;
	}

	public Timestamp getUserDeletedDate() {
		return userDeletedDate;
	}

	public void setUserDeletedDate(Timestamp userDeletedDate) {
		this.userDeletedDate = userDeletedDate;
	}

	@Override
	public String toString() {
		return "s_User [user_id=" + user_id + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userGroupId=" + userGroupId + ", userRevised=" + userRevised + ", pegawaiId=" + pegawaiId
				+ ", userAktif=" + userAktif + ", userCreatedDate=" + userCreatedDate + ", userCreatedBy="
				+ userCreatedBy + ", userUpdatedDate=" + userUpdatedDate + ", userUpdatedBy=" + userUpdatedBy
				+ ", userCounterId=" + userCounterId + ", userLogin=" + userLogin + ", userLogout=" + userLogout
				+ ", userStartTime=" + userStartTime + ", userEndTime=" + userEndTime + ", userCabang=" + userCabang
				+ ", regAppsId=" + regAppsId + ", userUnit=" + userUnit + ", userDeletedDate=" + userDeletedDate + "]";
	}
}

package com.Myex.base.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Groups")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	protected Integer nrstudent;
	protected Integer nrprof;
	protected Integer clas;
	protected String nume;
	protected String prenume;
	protected String email;
	protected String tel;
	protected String orasos;
	protected Date date;
	
	public Group() {
		
	}

	public Group(Integer id, Integer nrstudent, Integer nrprof, Integer clas, String nume, String prenume, String email,
			String tel, String orasos, Date date) {
		super();
		this.id = id;
		this.nrstudent = nrstudent;
		this.nrprof = nrprof;
		this.clas = clas;
		this.nume = nume;
		this.prenume = prenume;
		this.email = email;
		this.tel = tel;
		this.orasos = orasos;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNrstudent() {
		return nrstudent;
	}

	public void setNrstudent(Integer nrstudent) {
		this.nrstudent = nrstudent;
	}

	public Integer getNrprof() {
		return nrprof;
	}

	public void setNrprof(Integer nrprof) {
		this.nrprof = nrprof;
	}

	public Integer getClas() {
		return clas;
	}

	public void setClas(Integer clas) {
		this.clas = clas;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getOrasos() {
		return orasos;
	}

	public void setOrasos(String orasos) {
		this.orasos = orasos;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}

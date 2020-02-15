package com.Myex.base.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="Experiments")
public class Experiment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	@Lob 
	@Column(name="name", length=512)
	protected String name;
	@Lob 
	@Column(name="what", length=512)
	protected String what;
	@Lob 
	@Column(name="why", length=512)
	protected String why;
	@Lob 
	@Column(name="expl", length=512)
	protected String expl;
	protected String picpath;
	protected String videourl;
	
	public Experiment() {
		
	}

	public Experiment(Integer id, String name, String what, String why, String expl, String picpath, String videourl) {
		super();
		this.id = id;
		this.name = name;
		this.what = what;
		this.why = why;
		this.expl = expl;
		this.picpath = picpath;
		this.videourl = videourl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}

	public String getWhy() {
		return why;
	}

	public void setWhy(String why) {
		this.why = why;
	}

	public String getExpl() {
		return expl;
	}

	public void setExpl(String expl) {
		this.expl = expl;
	}
	

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public String getVideourl() {
		return videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}
	
	
	
	
	
	
}

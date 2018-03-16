package com.sys.model;

import java.io.Serializable;
import java.util.Date;

public class BikeInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String bikeid;

	private String bikename;

	private String bikemodel;

	private String biketype;

	private Long bikeamount;

	private String bikeicon;

	private Double rentunitprice;

	private Date edttime;

	private String isusing;

	public String getBikeid() {
		return bikeid;
	}

	public void setBikeid(String bikeid) {
		this.bikeid = bikeid == null ? null : bikeid.trim();
	}

	public String getBikename() {
		return bikename;
	}

	public void setBikename(String bikename) {
		this.bikename = bikename == null ? null : bikename.trim();
	}

	public String getBikemodel() {
		return bikemodel;
	}

	public void setBikemodel(String bikemodel) {
		this.bikemodel = bikemodel == null ? null : bikemodel.trim();
	}

	public String getBiketype() {
		return biketype;
	}

	public void setBiketype(String biketype) {
		this.biketype = biketype == null ? null : biketype.trim();
	}

	public Long getBikeamount() {
		return bikeamount;
	}

	public void setBikeamount(Long bikeamount) {
		this.bikeamount = bikeamount;
	}

	public String getBikeicon() {
		return bikeicon;
	}

	public void setBikeicon(String bikeicon) {
		this.bikeicon = bikeicon == null ? null : bikeicon.trim();
	}

	public Double getRentunitprice() {
		return rentunitprice;
	}

	public void setRentunitprice(Double rentunitprice) {
		this.rentunitprice = rentunitprice;
	}

	public Date getEdttime() {
		return edttime;
	}

	public void setEdttime(Date edttime) {
		this.edttime = edttime;
	}

	public String getIsusing() {
		return isusing;
	}

	public void setIsusing(String isusing) {
		this.isusing = isusing == null ? null : isusing.trim();
	}
}
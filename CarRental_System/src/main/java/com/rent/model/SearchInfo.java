package com.rent.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class SearchInfo implements Serializable{
	
	
	@NotEmpty
	private String begindate;
	
	

	public String getBegindate() {
		return begindate;
	}


	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}


	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


	public String getZipCode() {
		return ZipCode;
	}


	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}

    @NotEmpty
	private String enddate;
	
	
	@NotEmpty
	private String ZipCode;

}
	
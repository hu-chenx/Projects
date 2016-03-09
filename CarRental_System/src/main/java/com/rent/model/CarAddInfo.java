package com.rent.model;

import java.io.IOException;
import java.io.Serializable;




import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class CarAddInfo implements Serializable{

private String type;
	

private int id;
    
    @NotEmpty
	private String begindate;
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



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



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getMemprice() {
		return memprice;
	}



	public void setMemprice(String memprice) {
		this.memprice = memprice;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getZipcode() {
		return zipcode;
	}



	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}



	public String getDetails() {
		return details;
	}



	public void setDetails(String details) {
		this.details = details;
	}



	public String getTotal() {
		return total;
	}



	public void setTotal(String total) {
		this.total = total;
	}



	public String getUseTime() {
		return useTime;
	}



	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}


    @NotEmpty
	private String enddate;
	

    @NotEmpty
	private String brand;
	
	
    @NotEmpty
	private String price;
	
	
	

	private String memprice;
	
	
	@NotEmpty
	private String location;
	

	private String street;
	

    @NotEmpty
	private String zipcode;
	

	private String details;
	

	private String total;
	


	private String useTime;
  
	
	private MultipartFile photo;
	
	
	private byte[] photoBytes;
	
private String photoContentType; 
	
	private String photoFilename;



	public MultipartFile getPhoto() {
		return photo;
	}



	public void setPhoto(MultipartFile photo) {
this.photo = photo;
		
		setPhotoContentType(photo.getContentType());
		setPhotoFilename(photo.getOriginalFilename());
		
		try {
			setPhotoBytes(photo.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public byte[] getPhotoBytes() {
		return photoBytes;
	}



	public void setPhotoBytes(byte[] photoBytes) {
		this.photoBytes = photoBytes;
	}



	public String getPhotoContentType() {
		return photoContentType;
	}



	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}



	public String getPhotoFilename() {
		return photoFilename;
	}



	public void setPhotoFilename(String photoFilename) {
		this.photoFilename = photoFilename;
	}
}

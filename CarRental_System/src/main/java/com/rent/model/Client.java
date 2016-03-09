package com.rent.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.security.auth.login.AccountException;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.rent.model.Message;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
@Table(name="client")
public class Client implements Serializable {
	
	
  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
  

  @Email
  @Column(name="email",length=45)
	 private String email;
	 
  @Column(name="membership",length=45)
	 private String membership;
	 
  @Column(name="license",length=45)
	 private String license;
	 
  
  @Column(name="age")
	 private Integer age;
	 
  @NotEmpty
  @Column(name="fisrtname",length=45)
	 private String firstname;
	 
  
  @NotEmpty
  @Column(name="lastname",length=45)
	 private String lastname;
  
  @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="client")
  private Set<Message> messages;
  
  @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="client")
  private Account account;
  
  @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="client")
  private Set<ShopCart> shopcart; 
  
  
  @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="client")
  private Users users;

	public Users getUsers() {
	return users;
}



public void setUsers(Users users) {
	this.users = users;
}







	public Set<ShopCart> getShopcart() {
	return shopcart;
}



public void setShopcart(Set<ShopCart> shopcart) {
	this.shopcart = shopcart;
}



	public Account getAccount() {
	return account;
}



public void setAccount(Account account) {
	this.account = account;
}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



}

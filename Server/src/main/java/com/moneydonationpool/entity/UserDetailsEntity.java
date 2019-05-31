package com.moneydonationpool.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user_details")
@JsonInclude(Include.NON_NULL)
public class UserDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "ph_no")
	private String phNo;
	
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Column(name = "modified_date")
	private Date modifiedDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "user_type")
	private String userType;
	
	@Column(name = "account_balence")
	private String accountBalence;
	
	@Column(name = "image_name")
	private String imageName;
	

}

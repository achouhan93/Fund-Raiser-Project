package com.moneydonationpool.entity;

import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name = "cause")
@JsonInclude(Include.NON_NULL)
public class CauseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cause_id")
	private int causeId;
	
	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "cause_target_amt")
	private int causeTargetAmt;
	
	@Column(name = "creation_date")
	private Timestamp creationDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "cause_expiration_date")
	private Date causeExpirationDate;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "collected_amt")
	private int collectedAmt;
	
	@Column(name = "cause_title")
	private String causeTitle;
	
	@Column(name = "created_by")
	private int createdBy;
	
	@Column(name = "cause_for")
	private String causeFor;
	
	@Column(name = "accountNumber")
	private String bankAccountNumber;
	
	@Column(name = "BIC")
	private String bic;

	@Column(name = "image_name")
	private String imageName;
}

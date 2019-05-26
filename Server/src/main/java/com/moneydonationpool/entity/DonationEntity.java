package com.moneydonationpool.entity;

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
@Table(name = "donation")
@JsonInclude(Include.NON_NULL)
public class DonationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "donation_id")
	private int donationId;
	
	@Column(name = "donated_by")
	private int donatedBy;
	
	@Column(name = "cause_id")
	private int causeId;
	
	@Column(name = "amount_donated")
	private int amountDonated;

}

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
@Table(name = "Login")
@JsonInclude(Include.NON_NULL)
public class LoginEntity {
	
	
	@Column(name = "user_id")
	private int userId;
	
	@Id
	@Column(name = "access_token")
	private String accessToken;

}

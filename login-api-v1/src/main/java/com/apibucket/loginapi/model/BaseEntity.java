package com.apibucket.loginapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(unique = true, nullable = false, updatable = false)
	@Setter(AccessLevel.NONE)
	private long id;

	@Column(name = "creation_date", updatable = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Setter(AccessLevel.NONE)
	private Date creationDate;

	@Column(name = "Last_Modified_Date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Setter(AccessLevel.NONE)
	private Date rod;

}

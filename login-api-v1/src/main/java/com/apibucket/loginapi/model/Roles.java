package com.apibucket.loginapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Roles extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3069956239651154931L;

	@Column(length = 50, nullable = false)
	private String role;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,optional=false)
	@JoinColumn(name = "users_id", nullable = false)
	@JsonBackReference
	protected Users users;
}

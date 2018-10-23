package com.apibucket.loginapi.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Users extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1246293657209005613L;
	private String name;
	@Email
	private String emailId;
	@Column(length = 15)
	private String mobileNo;
	private String password;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Roles> roles;

	public Users(Users users) {
		this.emailId = users.getEmailId();
		this.mobileNo = users.getMobileNo();
		this.name = users.getName();
		this.password = users.getPassword();
		this.roles = users.getRoles();
	}

	public void addRoles(Roles role) {
		if (roles == null) {
			roles = new ArrayList<>();
		}
		role.users = this;
		roles.add(role);
	}
}

package com.mytechra.spring.playground.security;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
public class User implements UserDetails {
	@Id
	@Column(name="uid")
	@NotNull
	@GeneratedValue
	private int iUid;
	
	private static final long serialVersionUID = 1L;
	@Column(name = "uname")
	@NotNull
	private String sUserName;
	
	@Column(name = "password")
	private String sPassWord;

	public enum Role implements GrantedAuthority {
		DRIVER, USER;

		@Override
		public String getAuthority() {
			return this.name();
		}
	}

	@Column(name = "role")
	private Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(role);
	}

	@Override
	public String getPassword() {
		return this.sPassWord;
	}

	@Override
	public String getUsername() {
		return this.sUserName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

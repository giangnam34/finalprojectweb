package com.laptrinhweb.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity()
@Table(name = "User")
public class UserEntity {

	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	@Column(name = "firstname", nullable = false, length = 32)
	private String firstname;
	@Column(name = "lastname", nullable = false, length = 32)
	private String lastname;
	@Column(name = "slug", unique = true)
	private String slug;
	@Column(name = "cmnd", unique = true)
	private String cmnd;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "phone", unique = true)
	private String phone;
	@Column(name = "isEmailActive", columnDefinition = "boolean default false")
	private Boolean isEmailActive;
	@Column(name = "isPhoneActive", columnDefinition = "boolean default false")
	private Boolean isPhoneActive;
	@Column(name = "salt")
	private String salt;
	@Column(name = "hashed_password")
	private String hashed_password;
	@Column(name = "role", columnDefinition = "varchar(20) default 'user' ")
	private String role;
	@Column(name = "address", length = 200)
	private String address;
	@Column(name = "avatar")
	private String avatar;
	@Column(name = "point")
	private String point;
	@Column(name = "e_wallet", columnDefinition = "integer default 0")
	private Long e_wallet;
	@Column(name = "createdAt")
	private Date createdAt;
	@Column(name = "updatedAt")
	private Date updateAt;
	
	
	
}

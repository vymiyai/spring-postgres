package com.rhcloud.tutorials.spring_postgres;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class DiscordUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String username;

	@CreationTimestamp
	private Date creation_date;

	@UpdateTimestamp
	private Date last_change;

	private String access_token;

	protected DiscordUser() {
	}

	public DiscordUser(String username, String access_token) {
		this.username = username;
		this.access_token = access_token;
	}

	@Override
	public String toString() {
		return String.format("Customer[id='%d', username='%s'creation_date='%s', last_change='%s', access_token='%s']",
				this.id, this.username, this.creation_date, this.last_change, this.access_token);
	}

}
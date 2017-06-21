package com.rhcloud.tutorials.spring_postgres;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DiscordUserRepository extends CrudRepository<DiscordUser, Long> {

	List<DiscordUser> findByUsername(String username);
}
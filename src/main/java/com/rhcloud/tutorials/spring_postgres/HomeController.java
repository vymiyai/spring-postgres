package com.rhcloud.tutorials.spring_postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	private DiscordUserRepository repository;

	@RequestMapping("/")
	public String index() {
		StringBuilder sb = new StringBuilder();
		sb.append("Database entries:\n\n");
		
		for (DiscordUser user : this.repository.findAll()) {
			sb.append(user.toString());
			sb.append('\n');
		}

		return sb.toString();
	}

}
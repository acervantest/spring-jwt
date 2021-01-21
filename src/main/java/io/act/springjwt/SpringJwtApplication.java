package io.act.springjwt;

import io.act.springjwt.entity.User;
import io.act.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringJwtApplication {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers(){

		List<User> users = Stream.of(
				new User(101, "user", "user", "user@email.com"),
				new User(102, "user1", "user1", "user1@email.com"),
				new User(103, "user2", "user2", "user2@email.com"),
				new User(104, "user3", "user3", "user3@email.com")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtApplication.class, args);
	}

}

package com.moshJava.stores;

import com.moshJava.stores.entities.User;
import com.moshJava.stores.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.moshJava.stores.repositories")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class StoresApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoresApplication.class, args);

		var repository = context.getBean(UserRepository.class);

		var user = User.builder()
				.email("aadarsh.tussar@gmail.com")
				.name("Aadarsh")
				.password("bankai")
				.build();

		repository.save(user);
	}

}

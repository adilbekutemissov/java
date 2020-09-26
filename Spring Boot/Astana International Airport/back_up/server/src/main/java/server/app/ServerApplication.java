package server.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("server")
@EntityScan("server.model")
@EnableJpaRepositories("server.repositories")
@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {

		SpringApplication.run(ServerApplication.class, args);
		System.out.println();

	}
}

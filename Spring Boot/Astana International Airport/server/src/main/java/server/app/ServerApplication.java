package server.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("server")
@EntityScan("server.model")
@EnableJpaRepositories("server.repositories")
@SpringBootApplication
public class ServerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServerApplication.class);
    }

//	private BookTicketController bookTicketController;

//	public ServerApplication(BookTicketController bookTicketController) {
//		this.bookTicketController = bookTicketController;
//	}

	public static void main(String[] args) {



//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//
//		SpringApplication serverApplication = (SpringApplication) applicationContext.getBean("app");
//
//		serverApplication.run();


		SpringApplication.run(ServerApplication.class, args);

	}
}

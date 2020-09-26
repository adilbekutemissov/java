package cz.cvut.fel.nss.tripguide;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/**
 * The class Trip guide application.
 */
@SpringBootApplication
@EnableCaching
public class TripGuideApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(TripGuideApplication.class, args);
	}

	/**
	 * Create new topic with name "ExcursionTicketReport"
	 * Using for kafka
	 *
	 * @return the new topic
	 */
	@Bean
	public NewTopic adviceTopic() {
		return new NewTopic("ExcursionTicketReport", 3, (short) 1);
	}
}

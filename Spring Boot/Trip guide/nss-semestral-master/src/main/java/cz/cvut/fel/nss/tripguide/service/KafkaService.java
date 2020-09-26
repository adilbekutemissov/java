package cz.cvut.fel.nss.tripguide.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The class Kafka service.
 */
@Service
public class KafkaService {

    /**
     * Consumes message and store to file report.txt
     *
     * @param message the message
     * @throws IOException the io exception
     */
    @KafkaListener(topics = "ExcursionTicketReport", groupId = "group_id")
    public void consume(String message) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/files/report.txt", true));
        writer.write(message);
        writer.close();
    }
}

package com.attractor.lesson_49.util;

import com.attractor.lesson_49.entity.Candidate;
import com.attractor.lesson_49.repository.CandidateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class PreloadDatabaseWithData {

    @Bean
    CommandLineRunner initDatabase(CandidateRepository repository) {

        repository.deleteAll();

        return (args) -> Stream.of(candidates())
                .peek(System.out::println)
                .forEach(repository::save);
    }

    private Candidate[] candidates() {
        return new Candidate[]{
                new Candidate("Markus Sillman", "1.jpg"),
                new Candidate("Nikita Culler", "2.jpg"),
                new Candidate("Tawanna Melanson", "3.jpg"),
                new Candidate("Brunilda Mikels", "4.jpg"),
                new Candidate("Hubert Takahashi", "5.jpg"),
                new Candidate("Hershel Caffrey", "6.jpg")};
    }
}

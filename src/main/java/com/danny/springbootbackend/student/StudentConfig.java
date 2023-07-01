package com.danny.springbootbackend.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
           Student james =  new Student(
                    "Ouma",
                    "James",
                    LocalDate.of(2011,Month.APRIL,5),
                    "jm@gmail.com"
            );

            Student Kilama =  new Student(
                    "Denis",
                    "Kilama",
                    LocalDate.of(2004,Month.APRIL,5),
                    "kilama@gmail.com"
            );

            Student olal =  new Student(
                    "Olal",
                    "David",
                    LocalDate.of(2002,Month.APRIL,5),
                    "olal@gmail.com"
            );

            studentRepository.saveAll(
                    List.of(james,Kilama,olal)
            );
        };
    }
}

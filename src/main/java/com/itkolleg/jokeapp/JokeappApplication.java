package com.itkolleg.jokeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JokeappApplication implements ApplicationRunner {

    @Autowired //Automatic Dependency Injection
            //SpringBoot sucht zum Laufzeit eine Interface die das implementieren kann.
    JokesRepository myJokesRepository;

    public static void main(String[] args) {
        SpringApplication.run(JokeappApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        myJokesRepository.save(new Jokes(null, "Chuck Norris pausiert Online Spiele", "Chuck-Norris-Witze", 0));
        myJokesRepository.save(new Jokes(null, "Chuck Norris isst keinen Honig, er kaut Biene", "Chuck-Norris-Witze", 0));
        myJokesRepository.save(new Jokes(null, "Chuck Norris zerschneidet ein Messer mit einem Brot", "Chuck-Norris-Witze", 0));
        myJokesRepository.save(new Jokes(null, "Chuck Norris wird nicht Krank, er biete Viren ein Unterschlupf", "Chuck-Norris-Witze", 0));

        System.out.println("Hello App Runner");
    }
}

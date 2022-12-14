package com.itkolleg.jokeapp;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/jokes")
public class JokerestApi {
    @Autowired
    JokesRepository jokesRepository;

    @PostMapping
    public ResponseEntity<Jokes> insertJOke(@RequestBody Jokes jokes){
        jokes.setId(null);
        Jokes jokeInserted = this.jokesRepository.save(jokes);
        return ResponseEntity.ok(jokeInserted );
    }

    @GetMapping("/{id}") //react nur auf get request
    public ResponseEntity<Jokes> getJokeById(@PathVariable Long id){
        Optional<Jokes> optionalJokes = jokesRepository.findById(id);
        if(optionalJokes.isPresent()){
            return ResponseEntity.ok(optionalJokes.get());
        }else{
            throw new JokeNotFoundException("This joke is not in our Database");
        }

    }
    @GetMapping
    public ResponseEntity<List<Jokes>>getAllJokes(){
        return ResponseEntity.ok(jokesRepository.findAll());
    }

    @DeleteMapping
    public ResponseEntity<Jokes>deleteJokeById(@PathVariable Long id){
        Jokes jokeToDelete = jokesRepository.findById(id).orElseThrow(()->new JokeNotFoundException("This joke is not in our Database"));
        jokesRepository.deleteById(id);
        return ResponseEntity.ok(jokeToDelete);
        /*
        Optional<Jokes> optionalJokes = jokesRepository.findById(id);
        if(optionalJokes.isPresent()){
            jokesRepository.deleteById(id);
            return ResponseEntity.ok(optionalJokes.get());
        }else{
            throw new JokeNotFoundException("This joke is not in our Database");
        }*/
    }

}

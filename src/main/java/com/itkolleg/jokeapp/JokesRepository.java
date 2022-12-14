package com.itkolleg.jokeapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//<Jokes, Long> Generics, Parameterisieren
//PagingAndSorting liefert eine bestimmte List size zurück oder sorted List zurück
public interface JokesRepository extends JpaRepository<Jokes,Long> {
    public List<Jokes> getAllByGenre(String genre);
}

package com.itkolleg.jokeapp;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Jokes {
    @Id             //Private Key
    @GeneratedValue //Automatic Incrementation
    private Long id;
    private String jokeText;
    private String genre;
    private int usk;



}

package com.eventhub.event_hub.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @ManyToMany(mappedBy = "users")
    private List<Event> events;

    public User(){
    }

    public User(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Verifica se il nome è nullo o contiene solo spazi vuoti
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nome della categoria non può essere vuoto");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        // Verifica se il nome è nullo o contiene solo spazi vuoti
        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nome della categoria non può essere vuoto");
        }
        this.surname = surname;
    }
}

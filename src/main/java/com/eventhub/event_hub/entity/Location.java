package com.eventhub.event_hub.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "location")
    private List<Event> events;

    public Location(){
    }

    public Location(long id, String name) {
        this.id = id;
        this.name = name;
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
    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", events=" + events +
                '}';
    }
}
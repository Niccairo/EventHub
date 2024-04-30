package com.eventhub.event_hub.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private  String description;
    @Column(name="ticket_price")
    private double priceTicket;
    @Column(name="email")
    private String email;
    @Column(name = "max_num_of_partecipants")
    private int maxNumberOfPartecipants;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "starting_time")
    private LocalTime startingTime;
    @Column(name = "end_time")
    private LocalTime endTime;
    //    private Location location;
    //    private Category category;
    @ManyToMany
    @JoinTable(
            name = "participants",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users ;

    public Event(long id, String name, String description, double priceTicket, String email, int maxNumberOfPartecipants) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priceTicket = priceTicket;
        this.email = email;
        this.maxNumberOfPartecipants = maxNumberOfPartecipants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Location getLocation() {
//        return location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMaxNumberOfPartecipants() {
        return maxNumberOfPartecipants;
    }

    public void setMaxNumberOfPartecipants(int maxNumberOfPartecipants) {
        this.maxNumberOfPartecipants = maxNumberOfPartecipants;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
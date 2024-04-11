package com.example.factory.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Events")
public class EventsEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Integer id;

    String event;

}

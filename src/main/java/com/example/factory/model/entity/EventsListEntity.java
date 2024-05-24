package com.example.factory.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "events_list")
public class EventsListEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Integer id;

    String name;

    @OneToMany(cascade = CascadeType.ALL)
    List<EventsEntity> events;
}

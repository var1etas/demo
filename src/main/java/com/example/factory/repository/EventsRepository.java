package com.example.factory.repository;

import com.example.factory.model.entity.EventsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends CrudRepository<EventsEntity, Integer> {
}

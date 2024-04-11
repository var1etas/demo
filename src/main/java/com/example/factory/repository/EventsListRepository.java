package com.example.factory.repository;

import com.example.factory.model.entity.EventsListEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsListRepository extends CrudRepository<EventsListEntity, Integer> {
}

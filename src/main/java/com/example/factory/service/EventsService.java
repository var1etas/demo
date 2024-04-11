package com.example.factory.service;

import com.example.factory.model.dto.EventsDto;
import com.example.factory.repository.EventsListRepository;
import com.example.factory.service.mapper.EventsConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventsService {

    private final EventsListRepository eventsListRepository;

    private final EventsConverter eventsConverter;

    public void save(EventsDto eventsDto) {
        eventsListRepository.save(eventsConverter.dtoToEntity(eventsDto));
    }

    public List<EventsDto> get() {
        return eventsConverter.entityToDto(eventsListRepository.findAll());
    }

}

package com.example.factory.service;

import com.example.factory.model.dto.EventsDtoRequest;
import com.example.factory.model.dto.EventsDtoResponse;
import com.example.factory.repository.EventsListRepository;
import com.example.factory.service.converter.EventsConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventsService {

    private final EventsListRepository eventsListRepository;

    private final EventsConverter eventsConverter;

    public void save(EventsDtoRequest eventsDtoRequest) {
        eventsListRepository.save(eventsConverter.dtoToEntity(eventsDtoRequest));
    }

    public List<EventsDtoResponse> get() {
        return eventsConverter.entityToDto(eventsListRepository.findAll());
    }

}

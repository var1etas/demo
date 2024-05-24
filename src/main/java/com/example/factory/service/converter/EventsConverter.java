package com.example.factory.service.converter;

import com.example.factory.model.dto.EventsDtoRequest;
import com.example.factory.model.dto.EventsDtoResponse;
import com.example.factory.model.entity.EventsEntity;
import com.example.factory.model.entity.EventsListEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventsConverter {

    public List<String> entityToString(List<EventsEntity> entity) {
        List<String> entityString = new ArrayList<>();
        entity.forEach(x -> entityString.add(x.getEvent()));
        return entityString;
    }

    public List<EventsEntity> stringToEntity(List<String> string) {
        List<EventsEntity> eventsEntities = new ArrayList<>();
        string.forEach(x -> {
            EventsEntity event = new EventsEntity();
            event.setEvent(x);
            eventsEntities.add(event);
        });
        return eventsEntities;
    }

    public List<EventsDtoResponse> entityToDto(Iterable<EventsListEntity> event) {
        List<EventsDtoResponse> dtoList = new ArrayList<>();
        event.forEach(x -> {
            EventsDtoResponse dto = new EventsDtoResponse(x.getName(), entityToString(x.getEvents()));
            dtoList.add(dto);
        });
        return dtoList;
    }

    public EventsListEntity dtoToEntity(EventsDtoRequest eventsDtoRequest) {
        EventsListEntity listEntity = new EventsListEntity();
        listEntity.setName(eventsDtoRequest.name());
        listEntity.setEvents(stringToEntity(eventsDtoRequest.events()));
        return listEntity;
    }
}

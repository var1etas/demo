package com.example.factory.service.converter;

import com.example.factory.model.dto.EventsDto;
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

    public List<EventsDto> entityToDto(Iterable<EventsListEntity> event) {
        List<EventsDto> dtoList = new ArrayList<>();
        event.forEach(x -> {
            EventsDto dto = new EventsDto(x.getName(), entityToString(x.getEvents()));
            dtoList.add(dto);
        });
        return dtoList;
    }

    public EventsListEntity dtoToEntity(EventsDto eventsDto) {
        EventsListEntity listEntity = new EventsListEntity();
        listEntity.setName(eventsDto.name());
        listEntity.setEvents(stringToEntity(eventsDto.events()));
        return listEntity;
    }
}

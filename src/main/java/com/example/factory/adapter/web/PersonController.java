package com.example.factory.adapter.web;

import com.example.factory.adapter.web.dto.Person;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Log4j2
@Validated
@RequestMapping(value = "/api/dto", produces = APPLICATION_JSON_VALUE)
public class PersonController {

    @PostMapping("/person")
    public @ResponseBody String checkPerson(@Valid @RequestBody Person person) {
        return person.name() + ", your data is correct";
    }
}

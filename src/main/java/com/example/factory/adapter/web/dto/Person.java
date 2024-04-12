package com.example.factory.adapter.web.dto;

import com.example.factory.adapter.web.validation.EmailConstraint;
import com.example.factory.adapter.web.validation.NameConstraint;

public record Person(
        @NameConstraint String name,
        @EmailConstraint String email,
        String message
) {
    public Person {
        if (message == null) message = name + ", your data is correct";
    }

}

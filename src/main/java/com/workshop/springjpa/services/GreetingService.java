package com.workshop.springjpa.services;

import com.workshop.springjpa.controllers.Greeting.requests.Greeting;
import com.workshop.springjpa.validatos.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GreetingService {

    private final ObjectsValidator<Greeting> greetingObjectsValidator;

    /*public  String saveGreeting(Greeting greeting) {
        var violations = greetingObjectsValidator.validate(greeting);

        if (!violations.isEmpty()) {
            return violations
                    .stream().
                    collect(Collectors.joining("\n"));
        }

        return "Greeting message <<" +
                greeting.getMsg()
                + ">> from: " +
                greeting.getFrom().toUpperCase() +
                " to: " +
                greeting.getTo().toUpperCase();
    }*/

    public  String saveGreeting(Greeting greeting) {
        greetingObjectsValidator.validate(greeting);
        return "Greeting message <<" +
                greeting.getMsg()
                + ">> from: " +
                greeting.getFrom().toUpperCase() +
                " to: " +
                greeting.getTo().toUpperCase();
    }

    public String throwException() {
        throw new IllegalStateException("Some Exception happened");
    }

}

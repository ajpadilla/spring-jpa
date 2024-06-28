package com.workshop.springjpa.controllers.Greeting;

import com.workshop.springjpa.controllers.Greeting.requests.Greeting;
import com.workshop.springjpa.services.GreetingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/greetings")
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService service;

    @PostMapping
    public ResponseEntity<String> postGreeting(@RequestBody /*@Valid*/ Greeting greeting /*,BindingResult bindingResult*/) {

      /*  if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    bindingResult.getAllErrors()
                            .stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining())
            );
        }*/

        final String greetingMsg = service.saveGreeting(greeting);
        return ResponseEntity.accepted().body(greetingMsg);
    }


    @GetMapping ("/error")
    ResponseEntity<?> throwException() {
        return ResponseEntity.ok(service.throwException());
    }
}























package com.example.tdddemo.GreetingController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GreetingsController {

    @GetMapping("/greeting")
    public ResponseEntity greetings(
            @RequestParam("name") String name,
            @RequestParam("gender") String gender
    ) {
        String salutation = gender.equals("male") ? "Mr." : "Mrs.";
        String response = String.format("Hello %s %s. How are you?",salutation, name);
        return new ResponseEntity<>(response,
                HttpStatus.OK);
    }


}

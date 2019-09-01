package com.example.tdddemo.GreetingController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultRouteContoller {
    @RequestMapping("**")
    public ResponseEntity notFound() {
        return new ResponseEntity("Page not found", HttpStatus.NOT_FOUND);
    }
}

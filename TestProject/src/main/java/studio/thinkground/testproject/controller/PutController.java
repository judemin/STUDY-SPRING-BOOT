package studio.thinkground.testproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PutMapping(value="/default")
    public ResponseEntity<String> putMethod(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello Spring Accepted!");
    }
}

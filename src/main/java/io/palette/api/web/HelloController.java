package io.palette.api.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class HelloController {
    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/eunji")
    public ResponseEntity<String> eunji() {
        return ResponseEntity.ok("hi22");
    }
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("this is test");
    }
}

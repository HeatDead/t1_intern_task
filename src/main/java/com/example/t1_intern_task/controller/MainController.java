package com.example.t1_intern_task.controller;

import com.example.t1_intern_task.service.MainService;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class MainController {
    private MainService mainService;

    @GetMapping("/num")
    public ResponseEntity<String> getNumOfChars(@RequestParam @NotEmpty String s){
        String out = mainService.getNumOfChars(s);
        return ResponseEntity.ok().body(out);
    }
}

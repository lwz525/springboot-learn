package com.demo.controller;

import com.demo.entity.Person;
import com.demo.exception.ResourceNotFoundException;
import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExceptionController {
    @GetMapping("/resourceNotFound")
    public void throwException() {
        Person person = new Person(1L, "maple223344");
        throw new ResourceNotFoundException(ImmutableMap.of("person name:", person.getName()));
    }
}

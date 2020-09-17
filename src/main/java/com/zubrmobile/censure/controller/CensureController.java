package com.zubrmobile.censure.controller;

import com.zubrmobile.censure.service.CensureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CensureController {

    @Autowired
    private CensureService censureService;

    @GetMapping("/")
    public String censure(@RequestParam("text") String text) {
        return censureService.censure(text);
    }
}

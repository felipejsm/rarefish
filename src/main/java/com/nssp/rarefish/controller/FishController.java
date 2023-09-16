package com.nssp.rarefish.controller;

import com.nssp.rarefish.model.fish.Fish;
import com.nssp.rarefish.service.FishService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/fish")
public class FishController {
    private FishService fishService;
    public FishController(FishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping
    public List<Fish> get() {
        return this.fishService.get();
    }
}

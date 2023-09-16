package com.nssp.rarefish.service;

import com.nssp.rarefish.model.fish.Fish;
import com.nssp.rarefish.model.fish.FishRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FishService {
    private FishRepository repository;
    public FishService(FishRepository repository) {
        this.repository = repository;
    }

    public List<Fish> get() {
        return this.repository.findAll();
    }

    @Transactional("primaryTransactionManager")
    public void save(Fish fish) {
        this.repository.save(fish);
    }
}

package com.nssp.rarefish.model.fish;

import com.nssp.rarefish.model.fish.Fish;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishRepository extends ListCrudRepository<Fish, Long> {}

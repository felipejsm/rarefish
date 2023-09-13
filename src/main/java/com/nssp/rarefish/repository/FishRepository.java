package com.nssp.rarefish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nssp.rarefish.model.fish.Fish;
public interface FishRepository extends JpaRepository<Fish, Long> {}

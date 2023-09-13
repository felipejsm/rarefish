package com.nssp.rarefish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nssp.rarefish.model.shipping.Shipping;
public interface ShippingRepository extends JpaRepository<Shipping, Long> {}

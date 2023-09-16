package com.nssp.rarefish.model.shipping;

import com.nssp.rarefish.model.shipping.Shipping;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends ListCrudRepository<Shipping, Long> {}

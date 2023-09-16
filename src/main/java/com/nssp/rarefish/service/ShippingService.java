package com.nssp.rarefish.service;

import com.nssp.rarefish.model.shipping.Shipping;
import com.nssp.rarefish.model.shipping.ShippingRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingService {
    private ShippingRepository repository;
    public ShippingService(ShippingRepository repository) {
        this.repository = repository;
    }

    public List<Shipping> get() {
        return this.repository.findAll();
    }

    @Transactional("secondTransactionManager")
    public void save(Shipping shipping) {
        this.repository.save(shipping);
    }
}

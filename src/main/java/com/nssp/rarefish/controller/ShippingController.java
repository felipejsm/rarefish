package com.nssp.rarefish.controller;

import com.nssp.rarefish.model.shipping.Shipping;
import com.nssp.rarefish.service.ShippingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
    private ShippingService shippingService;
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping
    public List<Shipping> get() {
        return this.shippingService.get();
    }
}

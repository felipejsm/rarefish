package com.nssp.rarefish;

import com.nssp.rarefish.model.fish.Fish;
import com.nssp.rarefish.model.shipping.Shipping;
import com.nssp.rarefish.service.FishService;
import com.nssp.rarefish.service.ShippingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RarefishApplication {

	private FishService fishService;
	private ShippingService shippingService;

	public RarefishApplication(FishService fishService,
							   ShippingService shippingService) {
		this.fishService = fishService;
		this.shippingService = shippingService;
	}

	public static void main(String[] args) {
		SpringApplication.run(RarefishApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			Fish myRareFish = Fish.builder()
					.name("peppermint angelfish")
					.id(1L)
					.build();
			Shipping shipping = Shipping.builder()
					.id(1L)
					.name("Naersk")
					.build();
			this.shippingService.save(shipping);
			this.fishService.save(myRareFish);

		};
	}
}

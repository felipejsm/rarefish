package com.nssp.rarefish.model.shipping;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "shipping_db")
public class Shipping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
}

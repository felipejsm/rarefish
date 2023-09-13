package com.nssp.rarefish.model.fish;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fish_db")
public class Fish {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
}

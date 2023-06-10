package com.abhishekanand.inventoryservice;

import com.abhishekanand.inventoryservice.model.Inventory;
import com.abhishekanand.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory = Inventory.builder()
					.skuCode("iPhone")
					.quantity(100)
					.build();
			Inventory inventory1 = Inventory.builder()
					.skuCode("vivo")
					.quantity(0)
					.build();

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}

}

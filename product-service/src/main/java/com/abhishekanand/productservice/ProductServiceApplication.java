package com.abhishekanand.productservice;

import com.abhishekanand.productservice.dto.ProductRequest;
import com.abhishekanand.productservice.model.Product;
import com.abhishekanand.productservice.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}

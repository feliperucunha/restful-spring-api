package com.felipecunha.viasoft.webscrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.felipecunha.viasoft.webscrapper")
@EntityScan(basePackages = "com.felipecunha.viasoft.webscrapper.model")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

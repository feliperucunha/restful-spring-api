package com.felipecunha.viasoft.webscrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.IOException;


@SpringBootApplication(scanBasePackages = "com.felipecunha.viasoft.webscrapper")
@EntityScan(basePackages = "com.felipecunha.viasoft.webscrapper.model")
public class Application {

	public Application() throws IOException {
	}

	public static void main(String[] args) {SpringApplication.run(Application.class, args);
	}

}

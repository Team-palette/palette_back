package io.palette.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaletteBackApplication {

	public static final String VERSION = "/v1";

	public static void main(String[] args) {
		SpringApplication.run(PaletteBackApplication.class, args);
	}

}

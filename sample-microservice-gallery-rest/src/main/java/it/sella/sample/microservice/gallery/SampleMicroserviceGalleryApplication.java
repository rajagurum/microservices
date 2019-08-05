package it.sella.sample.microservice.gallery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class SampleMicroserviceGalleryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleMicroserviceGalleryApplication.class, args);
	}

}

@Configuration
class RestTemplateConfig {

	// Create a bean for restTemplate to call services
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}


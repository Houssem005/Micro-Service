package tn.esprit.spring;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import tn.esprit.spring.entities.Livreur;
import tn.esprit.spring.repositories.LivreurRepository;

@SpringBootApplication
@EnableEurekaClient
public class DeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryApplication.class, args);
	}
	@Bean
	 ApplicationRunner init(LivreurRepository repository){
		return args ->{
			Stream.of("houssem","abidi","houss@esprit.tn").forEach(nom ->{
				repository.save(new Livreur(nom));
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}

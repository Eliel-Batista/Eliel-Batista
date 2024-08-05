package com.example.adress_maneger;

import com.example.adress_maneger.Model.Adress;
import com.example.adress_maneger.Repositories.AdressRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdressManegerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdressManegerApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(AdressRepository adressRepository){
		return args -> {
//			adressRepository.deleteAll();
//			Adress ad = new Adress();
//			ad.setStreet("Rua X");
//			ad.setCity("Salvador");
//			ad.setComplement("Complemento");
//			ad.setNumber(33);
//			ad.setDistrict("Amaralina");
//			ad.setState("Bahia");
//
//			adressRepository.save(ad);
		};
	}

}

package com.softeng.dressily;

import com.softeng.dressily.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DressilyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DressilyApplication.class, args);
	}

}

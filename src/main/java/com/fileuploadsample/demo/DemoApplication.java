package com.fileuploadsample.demo;

import com.fileuploadsample.demo.model.FileInfo;
import com.fileuploadsample.demo.model.FileInfoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
	@Bean
	CommandLineRunner runner(FileInfoRepository repository){
		return args -> {
			//repository.save( new FileInfo("TEST-1"));
			//repository.save( new FileInfo("AAA-2"));
		};
	}*/

}

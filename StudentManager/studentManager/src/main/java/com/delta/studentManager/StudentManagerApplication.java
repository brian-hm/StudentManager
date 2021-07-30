package com.delta.studentManager;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.delta.studentManager.service.FilesStorageService;




@SpringBootApplication
public class StudentManagerApplication implements CommandLineRunner{

	@Resource
	FilesStorageService storageService;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentManagerApplication.class, args);
	}
	
	@Override
	public void run (String... arg) throws Exception{
		storageService.init();
	}
	
}

package com.example.seleniumpoc;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.seleniumpoc.script.SeleniumScript;

@SpringBootApplication
public class SeleniumpocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeleniumpocApplication.class, args);

	}

	@Bean
	public CommandLineRunner runSeleniumScript(SeleniumScript seleniumScript) {
		return args -> {
			seleniumScript.run();
		};
	}
}
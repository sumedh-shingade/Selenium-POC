package com.example.seleniumpoc;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumpocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeleniumpocApplication.class, args);

		WebDriver driver = new ChromeDriver();

		// Open a website
		driver.get("https://www.flipkart.com");

		driver.manage().window().maximize();
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("iphone 15 plus");
		searchBox.submit();
		String mainPage = driver.getWindowHandle();

		driver.findElement(By.xpath("//div[normalize-space()='Apple iPhone 15 Plus (Blue, 128 GB)']")).click();
		;
		Set<String> allPages = driver.getWindowHandles();

		for (String page : allPages) {
			if (!page.equals(mainPage)) {
				driver.switchTo().window(page);
				break;
			}
		}

		System.out.println(driver.getCurrentUrl());

		List<WebElement> products = driver.findElements(By.className("cPHDOP col-6-12"));
		System.out.println(products.size());
		for (WebElement product : products) {
			System.out.println(product.getText());
		}
		driver.findElement(By.xpath(
				"//body/div[@id='container']/div/div[@class='_39kFie N3De93 JxFEK3 _48O0EI']/div[@class='DOjaWF YJG4Cf']/div[@class='DOjaWF gdgoEp col-8-12']/div[8]/div[1]"));

	}

}

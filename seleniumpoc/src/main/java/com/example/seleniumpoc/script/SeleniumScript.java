package com.example.seleniumpoc.script;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

@Component
public class SeleniumScript {

    public void run() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://www.flipkart.com");

        driver.manage().window().maximize();
        
        // Close the login popup if it appears
        try {
            WebElement closeLoginPopup = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
            closeLoginPopup.click();
        } catch (Exception e) {
            System.out.println("Login popup did not appear.");
        }

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("iphone 15 plus");
        searchBox.submit();
        String mainPage = driver.getWindowHandle();

        driver.findElement(By.xpath("//div[normalize-space()='Apple iPhone 15 Plus (Blue, 128 GB)']")).click();
        
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
        
        driver.quit();
    }
}

package com.cydeo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T001_FaceBookTitleCheck {
    public static void main(String[] args) throws InterruptedException {
        /*
        TC #1: Facebook title verification
1. Open Chrome browser
2. Go to https://www.facebook.com
3. Verify title:
Expected: “Facebook – log in or sign up”
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //Go to https://www.facebook.com
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        // Verify title:
        //Expected: “Facebook – log in or sign up”
        System.out.println(driver.getTitle());
        String expectedTitle="Facebook - log in or sign up";
        String actualTitle=driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        Thread.sleep(3000);


    }
}

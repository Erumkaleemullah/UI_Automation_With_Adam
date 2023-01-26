package com.cydeo.tests;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T002_FaceBookUrlCheck {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("facebook")) {
            System.out.println("Test is passed");
        } else {
            System.out.println("Test is failed");
        }
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Facebook")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        driver.navigate().to("https://www.google.com");
        currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        if (currentUrl.contains("google")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        driver.get("https://www.facebook.com");
        String currentTitle = driver.getTitle();
        if (currentTitle.contains("Facebook")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        driver.navigate().to("https://www.google.com");
        currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("google")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        driver.navigate().back();
        currentUrl = driver.getCurrentUrl();


        verifyWordContains(currentUrl, "facebook");
        driver.navigate().forward();
        currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("google")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
    private static void verifyWordContains(String sentence, String word) {
        if (sentence.contains(word)) {

            System.out.println("PASS");
        } else {
            System.err.println("FAIL");
        }

    }

    private static void waitfor(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {

        }
    }

    }





/*
TC #2: Title and Url check
        1. Open Chrome browser
        2. Go to https://www.facebook.com
        3. Verify url contains facebook
        4. Verify title contains Facebook
        5. Navigate to https://www.google.com
        6. Verify url contains google
        7. Verify title contains Google
        8. Navigate back
        9. Verify url contains facebook
        10.Navigate forward
        11.Verify url contains google
 */
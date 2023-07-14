package com.jops;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

//https://rahulshettyacademy.com/locatorspractice/
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        //Getting chrome driver location
        System.setProperty("webdriver.chrome.driver","\\PROG\\VC-X\\selenium\\atividades\\chromedriver.exe");

        //enable logs on console
        ChromeDriverService service = new ChromeDriverService.Builder()
                .withLogOutput(System.out)
                .build();


        //create driver
        WebDriver driver = new ChromeDriver(service);

        //wait 5 seconds if there isnt any element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        //method to get the password
        String password = getPassword(driver);

        
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys("Joao");
        driver.findElement(By.name("inputPassword")).sendKeys("teste");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Joao");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("jops@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("1234");
        
        //wait for animation end
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());


        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        driver.findElement(By.id("inputUsername")).sendKeys("Joao");

        driver.findElement(By.name("inputPassword")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#chkboxTwo")).click();
        driver.findElement(By.className("signInBtn")).click();
        driver.quit();
    }


    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText =driver.findElement(By.cssSelector("form p")).getText();
        //Please use temporary password 'rahulshettyacademy' to Login.
        String[] passwordArray = passwordText.split("'");
        // String[] passwordArray2 = passwordArray[1].split("'");
        // passwordArray2[0]
        String password = passwordArray[1].split("'")[0];
        return password;
        //0th index - Please use temporary password
        //1st index - rahulshettyacademy' to Login.
        //0th index - rahulshettyacademy
        //1st index - to Login.
    }

}

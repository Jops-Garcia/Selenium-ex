package com.jops;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriverService;


public class App 
{
    public static void main( String[] args )
    {
        System.setProperty("webdriver.chrome.driver","\\PROG\\VC-X\\selenium\\atividades\\chromedriver.exe");
        
        //trazer log pro console, adicionar o servico em chrome Driver
        //ChromeDriverService service = new ChromeDriverService.Builder().withLogOutput(System.out).build();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com.br/?hl=pt-BR");

        System.out.println(driver.getTitle());

        System.out.println(driver.getCurrentUrl());

        //fecha a aba inicial, quit fecha o navegador inteiro
        driver.close();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mvc.facultad.servicios.test;

/**
 *
 * @author Julian_Velasco
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EstudianteServicioSelTest {
  public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Julian_Velasco\\Desktop\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080");

        driver.quit();
    }
}
package com.record.crowdar;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestLoginFailed {
	WebDriver driver;
	By logotipo = By.className("login_logo");
	By username = By.id("user-name");
	By pass = By.id("password");
	By login = By.id("login-button");
	By imagen_login = By.className("bot_column");
	By mensaje_error = By.className("error-button");
	
	
  @Test
  public void login() {
	  
	  assertTrue(driver.findElement(imagen_login).isDisplayed(),"NO CARGÓ CORRECTAMENTE LA WEB");
	  WebElement usuario = driver.findElement(username);
	  usuario.sendKeys("standard_user");
	  
	  WebElement password = driver.findElement(pass);
	  password.sendKeys("secret_sauce2222");
	  
	  WebElement confirmar = driver.findElement(login);
	  confirmar.click();
	  
	  WebElement msj_error = driver.findElement(mensaje_error);
	  assertEquals(msj_error.getText(), "Epic sadface: Username and password do not match any user in this service");
	  
	  
	  
  }


  @BeforeClass
  @Parameters({"URL", "BrowserType"})
  public void beforeClass(String url, String browserType) {
	  if(browserType.equalsIgnoreCase("Chrome")) {
		  System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromeDriver/chromedriver.exe");
		  driver = new ChromeDriver();
	  } else if(browserType.equalsIgnoreCase("Firefox")) {
		  System.setProperty("webdriveer.gecko.driver", "./src/test/resources/firefoxDriver/geckodriver.exe");
		  driver = new FirefoxDriver();
	  } 
	  
	  driver.manage().window().maximize();
	  driver.get(url);
	  
	  System.out.println("Navegador: " + browserType);
  }
  
  

  @AfterClass
  public void afterClass() {
	  driver.close();
  }
}

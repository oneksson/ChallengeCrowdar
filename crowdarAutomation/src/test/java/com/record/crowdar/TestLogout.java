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

public class TestLogout {
	WebDriver driver;
	By logotipo = By.className("login_logo");
	By username = By.id("user-name");
	By pass = By.id("password");
	By login = By.id("login-button");
	By imagen_login = By.className("bot_column");
	By presentacion = By.className("app_logo");
	By hamburguesa = By.id("react-burger-menu-btn");
	By desloguear = By.id("logout_sidebar_link");
	By agreguar_item = By.id("add-to-cart-sauce-labs-backpack");
	By remover_item = By.id("remove-sauce-labs-backpack");
	By carrito = By.className("shopping_cart_container");
	By titulo = By.className("title");
	By nombre_del_inventario = By.className("inventory_item_name");
	By checkout = By.id("checkout");
	By nombre = By.id("first-name");
	By apellido = By.id("last-name");
	By cp = By.id("postal-code");
	By continuar = By.id("continue");
	By finalizar = By.id("finish");
	By gracias = By.className("complete-header");
	By logo_gracias = By.className("pony_express");
	By home = By.id("back-to-products");
	
  
  @Test
  public void logout() {
	  
	  assertTrue(driver.findElement(logotipo).isDisplayed(),"NO CARGÓ CORRECTAMENTE LA WEB");
	  WebElement usuario = driver.findElement(username);
	  usuario.sendKeys("standard_user");
	  
	  WebElement password = driver.findElement(pass);
	  password.sendKeys("secret_sauce");
	  
	  WebElement confirmar = driver.findElement(login);
	  confirmar.click();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  assertTrue(driver.findElement(presentacion).isDisplayed(), "NO SE LOGUEÓ CORRECTAMENTE");
	  
	  WebElement pendorcho = driver.findElement(hamburguesa);
	  pendorcho.click();
	  
	  WebElement logout = driver.findElement(desloguear);
	  
	  logout.click();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  assertTrue(driver.findElement(imagen_login).isDisplayed(),"NO CARGÓ CORRECTAMENTE LA WEB");
	  
	  
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

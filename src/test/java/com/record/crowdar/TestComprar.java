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

public class TestComprar {
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
  public void comprar() {
	  
	  assertTrue(driver.findElement(logotipo).isDisplayed(),"NO CARGÓ CORRECTAMENTE LA WEB");
	  WebElement usuario = driver.findElement(username);
	  usuario.sendKeys("standard_user");
	  
	  WebElement password = driver.findElement(pass);
	  password.sendKeys("secret_sauce");
	  
	  WebElement confirmar = driver.findElement(login);
	  confirmar.click();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  assertTrue(driver.findElement(presentacion).isDisplayed(), "NO SE LOGUEÓ CORRECTAMENTE");
	  
	  WebElement agregar_elemento = driver.findElement(agreguar_item);
	  agregar_elemento.click();
	  
	  WebElement eliminar_elemento = driver.findElement(remover_item);
	  
	  assertEquals(eliminar_elemento.getText(), "REMOVE");
	  
	  
	  WebElement carrito_compra = driver.findElement(carrito);
	  carrito_compra.click();
	  
	  assertTrue(driver.findElement(checkout).isDisplayed(), "NO CARGÓ CORRECTAMENTE LA WEB");
	  
	  WebElement nombre_instancia_de_compra = driver.findElement(titulo);
	  assertEquals(nombre_instancia_de_compra.getText(), "YOUR CART");
	  
	  WebElement nombre_de_item = driver.findElement(nombre_del_inventario);
	  assertEquals(nombre_de_item.getText(), "Sauce Labs Backpack");
	  
	  WebElement checkout_btn = driver.findElement(checkout);
	  checkout_btn.click();
	  
	  assertEquals(nombre_instancia_de_compra.getText(), "CHECKOUT: YOUR INFORMATION");
	  
	  WebElement continuar_btn = driver.findElement(continuar);
	  assertTrue(continuar_btn.isDisplayed(), "NO CARGÓ CORRECTAMENTE LA WEB");
	  
	  WebElement nombre_comprador = driver.findElement(nombre);
	  WebElement apellido_comprador = driver.findElement(apellido);
	  WebElement cp_comprador = driver.findElement(cp);
	  
	  nombre_comprador.sendKeys("Jorgito");
	  apellido_comprador.sendKeys("Mira");
	  cp_comprador.sendKeys("1234");
	  continuar_btn.click();
	  
	  assertEquals(nombre_instancia_de_compra.getText(), "CHECKOUT: OVERVIEW");
	 
	  assertEquals(nombre_de_item.getText(), "Sauce Labs Backpack");
	  
	  WebElement finalizar_btn = driver.findElement(finalizar);
	  finalizar_btn.click();
	  
	  assertEquals(nombre_instancia_de_compra.getText(), "CHECKOUT: COMPLETE!");
	  
	  WebElement felicitaciones = driver.findElement(gracias);
	  assertEquals(felicitaciones.getText(), "THANK YOU FOR YOUR ORDER");
	  WebElement logo_felicitaciones = driver.findElement(logo_gracias);
	  assertTrue(logo_felicitaciones.isDisplayed(), "NO SE PUDO REALIZAR LA COMPRA");
	  
	  WebElement volver_btn = driver.findElement(home);
	  assertTrue(logo_felicitaciones.isDisplayed(), "NO SE PUDO REALIZAR LA COMPRA");
			 
		 
	  
	  
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

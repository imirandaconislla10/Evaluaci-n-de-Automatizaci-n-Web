package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import com.nttdata.page.MyStorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class MyStoreSteps {
    public WebDriver driver;

    //constructor
    public MyStoreSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(MyStorePage.usuario);
        userInputElement.sendKeys(user);
        //Espera implicita
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));

        //Se espera explicita
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.IniciarSesionBtn));
    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(MyStorePage.password).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(MyStorePage.IniciarSesionBtn).click();
    }


    public  void clickBtnContactar(){
        driver.findElement(By.xpath("//*[@id=\"_desktop_contact_link\"]/a")).click();
    }

    public void validarItems(InventorySteps inventorySteps) {
        int itemsListSize = inventorySteps.getItemSize();
        //prueba: validar que al menos exista un item
        screenShot();
        Assertions.assertTrue(itemsListSize > 0, "El tamaño de la lista es: " + itemsListSize);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}

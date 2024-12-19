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

    public void selectCategory(String categoria) {
        this.driver.findElement(MyStorePage.CategoriaBtn).click();
    }

    public void selectSubcategory(String subcategoria) {
        this.driver.findElement(MyStorePage.MenCategoriaBtn).click();
    }
    public void irAProducto() {
        this.driver.findElement(MyStorePage.productList).click();
    }
    public void CantidadProducto2(int cantidad) {
        WebElement quantityField=   this.driver.findElement(MyStorePage.Cantidad);
        quantityField.clear();
        quantityField.sendKeys("2");

    }

    public void addProductToCart(int productIndex, int cantidad) {
        this.driver.findElement(MyStorePage.addToCartButton).click();
    }


    public void confirmacionProducto() {
        this.driver.findElement(MyStorePage.ProductoConfirmado).click();
    }

    public void proceedToCheckout() {
        // Espera explícita para asegurarse de que el botón de checkout esté visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // Localiza el botón o enlace para proceder al checkout
        WebElement checkoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.FinalizarCompraButtom)); // Asegúrate de tener este selector en MyStorePage
        // Hacer clic en el botón de checkout
        checkoutButton.click();


    }

    /**
     * Obtener el monto total del popup
     * @return el monto total como un valor double
     */
    public double getTotalAmount() {
        // Espera explícita para asegurarse de que el total del popup esté visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Localiza el elemento que muestra el total en el popup
        WebElement totalAmountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.totalAmount)); // Asegúrate de tener este selector en MyStorePage

        // Obtener el texto del elemento y convertirlo a un valor double
        String totalAmountText = totalAmountElement.getText().replace("$", "").replace(",", "").trim(); // Ajusta según el formato de tu moneda
        return Double.parseDouble(totalAmountText);
    }
}
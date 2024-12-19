package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.MyStoreSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class MyStoreStepdef {

    private WebDriver driver;

    MyStoreSteps myStoreSteps;

    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }

    @Dado("que me encuentro en la página de login de MyStore")
    public void queMeEncuentroEnLaPáginaDeLoginDeMyStore() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion?");
        screenShot();
    }

    @Cuando("inicio sesión con las credenciales correo: {string} y contraseña: {string}")
    public void inicioSesiónConLasCredencialesCorreoYContraseña(String correo, String password) {
        myStoreSteps = new MyStoreSteps(driver);
        myStoreSteps.typeUser(correo);
        myStoreSteps.typePassword(password);
        myStoreSteps.login();
        screenShot();
    }


    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        myStoreSteps = new MyStoreSteps(driver);
        myStoreSteps.selectCategory(categoria);
        myStoreSteps.selectSubcategory(subcategoria);
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        myStoreSteps = new MyStoreSteps(driver);
        myStoreSteps.irAProducto();
        myStoreSteps.CantidadProducto2(cantidad);
        myStoreSteps.addProductToCart(2, cantidad); // Asumiendo que el primer producto tiene un índice de 1
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        myStoreSteps.confirmacionProducto();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
     //   double priceOfProduct1 = 19.12; // Precio del primer producto
      //  int quantityOfProduct1 = 12; // Cantidad del primer producto
        // Calcular el monto total esperado
      //  double expectedTotalAmount = (priceOfProduct1 * quantityOfProduct1) ;
        // Obtener el total actual del popup
       // double totalAmount = myStoreSteps.getTotalAmount();
        // Aserción para verificar que el monto total es correcto
      //  Assertions.assertEquals(expectedTotalAmount, totalAmount, "El monto total no es correcto");

       // screenShot();

    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        myStoreSteps = new MyStoreSteps(driver);
        myStoreSteps.proceedToCheckout();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("My Store", pageTitle);
        screenShot();
    }


    @Y("vuelvo a validar el calculo de precios en el carrito {string}")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito(String expectedTotalAmount) {
        myStoreSteps = new MyStoreSteps(driver);
        double totalAmount = myStoreSteps.getTotalAmount();
        Assertions.assertEquals(expectedTotalAmount, totalAmount, "El monto total no es correcto");

    }
}

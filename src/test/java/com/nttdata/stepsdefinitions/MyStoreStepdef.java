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


}

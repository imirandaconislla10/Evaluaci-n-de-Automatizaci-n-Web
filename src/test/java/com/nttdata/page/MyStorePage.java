package com.nttdata.page;

import org.openqa.selenium.By;

public class MyStorePage {

    //Localizadores de elementos
    public static By usuario= By.xpath("//*[@id=\"field-email\"]");
    public static By password= By.xpath("//*[@id=\"field-password\"]");
    public static By IniciarSesionBtn= By.xpath("//*[@id=\"submit-login\"]");
    public static By CategoriaBtn = By.xpath("//*[@id=\"category-3\"]/a");
    public static By MenCategoriaBtn = By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li/a");
    public static By productList = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/picture/img");
    public static By addToCartButton = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    public static By ProductoConfirmado= By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
    public static By totalAmount = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");
    public static By FinalizarCompraButtom = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a");
    public static By Cantidad = By.xpath("//*[@id=\"quantity_wanted\"]");

}

#language: es
@testMyStore
Característica: Product - Store


  @test1
  Escenario: Validación del precio de un producto
    Dado que me encuentro en la página de login de MyStore
    Cuando inicio sesión con las credenciales correo: "imirandaconislla@gmail.com" y contraseña: "741852963Ivan@1234"
    Cuando navego a la categoria "Clothes" y subcategoria "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito "S/ 229.44"


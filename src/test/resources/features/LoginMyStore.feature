#language: es
@testMyStore
Característica: Login
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión
  Para ver todos los items

  @test
  Escenario: Login exitoso
    Dado que me encuentro en la página de login de MyStore
    Cuando inicio sesión con las credenciales correo: "imirandaconislla@gmail.com" y contraseña: "741852963Ivan@1234"
    Entonces valido que debería aparecer el texto de "Productos Destacados"


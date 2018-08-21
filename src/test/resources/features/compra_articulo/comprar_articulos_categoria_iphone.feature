@tag
Feature: Comprar articulos en la categor�a IPhone
  Como un cliente, yo quiero comprar un articulo para recibirlo
  en un lugar de destino

  @tag1
  Scenario: Comprar un articulo con 2 cantidades
    Given anadi el articulo "Apple iPhone 4S 16GB SIM" al carrito
    And aumente la cantidad a 2
    When compro el producto
      | Pais     | Estado    | Ciudad   | Email                  | Nombre | Apellidos | Direccion            | Telefono |
      | Colombia | Antioquia | Medellin | juancamiloau@gmail.com | Hamilton | Tabares | Cll Siempre Viva 123 |  4441234 |
    Then me aparece un resumen de transaccion
      | Precio  |
      | $270.00 |

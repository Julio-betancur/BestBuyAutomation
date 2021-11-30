#language: en
#Author: Julio Cesar Betancur Salazar
  Feature: Busqueda de productos
    Como usuario quiero buscar productos para poder comprarlos.

    Scenario: Realizar busqueda de productos por medio de la caja de texto
      Given Que me encuentro en la pagina de Bestbuy
      When  Ingreso el nombre de un producto en la caja de texto y doy clic en la lupa
      Then  la pagina me muestra un listado de productos que coinciden con el que busque

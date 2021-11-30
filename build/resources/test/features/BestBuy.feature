#language: en
#Author: Julio Cesar Betancur Salazar
  Feature: Busqueda de productos
    Como usuario quiero buscar productos para poder comprarlos.

    Scenario: Realizar busqueda de productos por medio de la caja de texto
      Given Que me encuentro en la pagina de Bestbuy
      When  Ingreso el nombre de un producto en la caja de texto, doy clic en la lupa y selecciono un producto del listado
      Then  la pagina me muestra un producto que coincide con el buscado

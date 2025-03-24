# Proyecto de Franquicias

Este proyecto es una aplicación web que gestiona franquicias, sucursales y productos utilizando Spring WebFlux. La aplicación interactúa con una base de datos relacional en Amazon Aurora MySQL.

## Tabla de Contenidos

1. [Descripción](#descripción)
2. [Características](#características)
3. [Tecnologías Utilizadas](#tecnologías-utilizadas)
4. [Requisitos Previos](#requisitos-previos)
5. [Instalación](#instalación)
6. [Ejecucion del proyecto](#ejecucion-del-proyecto)
7.  [Endpoints](#endpoints)


## Descripción

Este es un sistema de gestión de franquicias donde puedes realizar las siguientes operaciones:

- Agregar una Nueva Franquicia.
- Agregar una nueva Sucursal.
- Agregar un Nuevo Producto.
- Agregar un producto existente a una Sucursal.
- Eliminar un producto de una Sucursal.
- Actualizar el stock de un producto en una franquicia
- Listar los productos con mayor stock por sucursal de una franquicia determinada.
- Actualizar el nombre de una franquicia.
- Actualizar el nombre de una sucursal.
- Actualizar el nombre de un producto.
- Listar todas las franquicias existentes.
- Listar todos las sucursales existentes.
- Listar todos los productos existentes.



La aplicación está construida con **Spring WebFlux** para soporte reactivo, lo que permite una mayor eficiencia en el manejo de solicitudes concurrentes.

## Características

- Conexión a base de datos **Amazon Aurora MySQL**.
- Endpoints para gestionar franquicias, sucursales y productos.
- Acceso a los datos de manera eficiente utilizando patrones reactivos.

## Tecnologías Utilizadas

- **Spring WebFlux**: Framework reactivo para crear aplicaciones web asíncronas.
- **Spring Data R2DBC**: Acceso reactivo a bases de datos relacionales.
- **Amazon Aurora MySQL**: Base de datos gestionada en AWS.
- **Java 17** o superior.
- **Gradle** para la gestión de dependencias.
- **Intellij Comunity edition** IDE para el desarrollo del proyecto.
  
## Requisitos Previos

Para poder ejecutar y desarrollar este proyecto, asegúrate de tener instalados los siguientes requisitos:

- **JDK 21** o superior.
- **Gradle** para la gestion de dependencias
- **MySQL o Dbeaver** para la visualizacion de la base de datos en aurora RDS.

## Instalación

1. **Clonar el repositorio**:
   el primer paso es clonar el repositorio del proyecto.
   git clone https://github.com/CamiloAGarciaMorales/franquicias.git

2. **Buildear las dependencias**:
   Para que el proyecto funcione de manera local necesitamos Realizar un build a las dependencias del proyecto, para esto se recomienda utilizar Intellij como IDE del proyecto. 
   Para esto Abriremos un nuevo terminal, nos ubicaremos en la carpeta del proyecto y ejecutaremos los siguientes comandos:
   ```bash
   ./gradlew clean
   ./gradlew build
                

3. **Configuracion de la base de datos**:
   La Base de datos se encuentra alojada en AWS Aurora RDS en la nube, por lo tanto si se desea tener una mejor visibilidad de la base de datos se recomienda utilizar Dbeaver para tener la informacion en un entorno local
   Para esto necestitaremos las credenciales de acceso y la URL de Conexión a la base de datos, toda esta informacion se puede encontrar en el archivo application.properties en los recursos del proyecto.

4. **Herramienta para realizar de peticiones**:
   Se recomienda tener un aplicativo que permita realizar peticiones a los diferentes Endpoints expuestos por el aplicativo, se recomienda utilizar Postman para mas facilidad, ademas de esto se adjuntara una collecion de Postman
   con todos los Endpoints configurados. 


## Ejecucion del proyecto
Despues de realizar los pasos y tener las herramientas listas, podremos ejecutar el proyecto utilizando el siguiente comando:
```bash
./gradlew bootRun
```
Una vez terminada la Ejecucion el servidor local quedara listo para recibir las peticiones. 

## Endpoints
En este apartado tendremos los request que podremos realizar al servicio:

- Agregar franquicia
```bash
curl --location 'http://localhost:8080/api/franquicias' \
--header 'Content-Type: application/json' \
--data '{
    "nombre": "Franquicia H",
    "direccion": "Calle 321, ibague"
}'
```

- Agregar Sucursal
```bash
curl --location 'http://localhost:8080/api/sucursales' \
--header 'Content-Type: application/json' \
--data '{
  "nombre": "Sucursal C",
  "direccion": "Calle 789, Ciudad",
  "franquiciaId": 1
}'
```

- Agregar Producto
```bash
curl --location 'http://localhost:8080/api/productos' \
--header 'Content-Type: application/json' \
--data '{
  "nombre": "Lapiceros",
  "descripcion": "Lapicero de tinta color negro",
  "precio": 3.0
}
'
```

- Agregar Producto a Sucursal

```bash
curl --location 'http://localhost:8080/api/sucursal-producto' \
--header 'Content-Type: application/json' \
--data '{
  "productoId": 4,
  "sucursalId": 3,
  "stock": 1000
}'
```


- Eliminar Producto de sucursal.

Para eliminar un producto debemos saber el id del producto y el id de la sucursal en el que se encuentra y modificar estos valores en la URL del servicio 
```bash
curl --location --request DELETE 'http://localhost:8080/api/sucursal-producto?productoId=1&sucursalId=1'
```

- Actualizar stock del producto

Para Actializar el stock de un producto debemos saber el id del producto y el id de la sucursal en el que se encuentra y modificar estos 3 valores en la URL del servicio. 
```bash
curl --location --request PUT 'http://localhost:8080/api/sucursal-producto/actualizar-stock?productoId=1&sucursalId=1&stock=50'
```

- Listar producto con mas stock por sucursal de una franquicia en especifico

Para listar el producto con mas Stock por sucursal de una franquisia debemos conocer el id de la franquicia objetivo. 
```bash
curl --location 'http://localhost:8080/api/sucursal-producto/1/productos-mas-stock'
```

- Actualizar nombre de franquicia
```bash
curl --location --request PUT 'http://localhost:8080/api/franquicias/cambio-nombre/1' \
--header 'Content-Type: application/json' \
--data '{
    "nombre": "Franquicia Coca-Cola"
}'
```

- Actualizar nombre de sucursal 
```bash
curl --location --request PUT 'http://localhost:8080/api/sucursales/cambio-nombre/1' \
--header 'Content-Type: application/json' \
--data '{
    "nombre": "Sucursal Nueva"
}'
```

- Actualizar nombre de un producto 
```bash
curl --location --request PUT 'http://localhost:8080/api/productos/cambio-nombre/1' \
--header 'Content-Type: application/json' \
--data '{
    "nombre": "Producto Actualizado"
}'
```

- Listar todas las franquicias
```bash
curl --location 'http://localhost:8080/api/franquicias/all'
```

- Listar todas las sucursales por franquicia

Para listar las sucursales por franquicia debemos conocer el id de la franquicia objetivo. 
```bash
curl --location 'http://localhost:8080/api/sucursales/allByFranquisiaId/1'
```

- Listar todos los productos
```bash
curl --location 'http://localhost:8080/api/productos/all'
```
Para una mayor comodidad del usuario se agragara una collecion de Postman con todas las peticiones en los recursos del proyecto. 